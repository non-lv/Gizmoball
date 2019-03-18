package Model;

import physics.Circle;
import physics.LineSegment;
import physics.Vect;
import physics.Geometry.VectPair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;

import static physics.Geometry.*;

public class Model extends Observable implements Cloneable {

    private static final double moveTime = 0.05;
    private static final int gridSizeX = 20;
    private static final int gridSizeY = 20;
    private static final int ballMass = 1;
    private static double mu = 0.025;
    private static double mu2 = 0.025;
    private static double gravity = 25;

    private List<IGizmo> iGizmos;
    private List<LineSegment> walls;
    private List<Ball> balls;

    private HashMap<IGizmo, Connection> connections;
    private HashMap<Integer, KeyConnection> keyConnections;

    public Model() {
        iGizmos = new ArrayList<>();
        walls = new ArrayList<>();
        balls = new ArrayList<>();

        connections = new HashMap<>();
        keyConnections = new HashMap<>();

        walls.add(new LineSegment(0, 0, gridSizeX, 0));
        walls.add(new LineSegment(0, 0, 0, gridSizeY));
        walls.add(new LineSegment(gridSizeX, 0, gridSizeX, gridSizeY));
        walls.add(new LineSegment(0, gridSizeY, gridSizeX, gridSizeY));
    }

    public void moveBalls() {
        double moveTime = Model.moveTime;
        CollisionDetails cd = null;

        for (Ball ball : balls) {
            if(ball.isMoving()) {
                CollisionDetails cd_ = timeUntilCollision(ball);
                if (cd == null || cd.getTuc() > cd_.getTuc())
                    cd = cd_;
            }
        }

        double tuc = cd == null ? moveTime : cd.getTuc();

        moveFlippersForTime(tuc > moveTime ? moveTime : tuc);

        for (Ball ball : balls) {
            if (ball.isMoving()) {
                if (tuc > moveTime) {
                    moveBallForTime(ball, moveTime);

                    friction(ball, moveTime);
                    gravity(ball, moveTime);
                } else {
                    if (cd.hasCollision(ball)) {
                        if (cd.isBallToBallCollision()) {
                            if (cd.getBall_() == ball)
                                continue;
                            Ball ball_ = cd.getBall_();
                            moveBallForTime(ball, tuc);
                            moveBallForTime(ball_, tuc);

                            ball.setVelocity(cd.getVelocityPair().v1);
                            ball_.setVelocity(cd.getVelocityPair().v2);

                            friction(ball, tuc);
                            friction(ball_, tuc);
                            gravity(ball, tuc);
                            gravity(ball_, tuc);
                        } else {
                            moveBallForTime(ball, tuc);

                            ball.setVelocity(cd.getVelocity());

                            friction(ball, tuc);
                            gravity(ball, tuc);

                            if (cd.getGizmo() != null) {
                                if (connections.containsKey(cd.getGizmo()))
                                    connections.get(cd.getGizmo()).triggered(ball);
                            }
                        }
                    } else {
                        moveBallForTime(ball, tuc);

                        friction(ball, tuc);
                        gravity(ball, tuc);
                    }
                }
            }
        }

        this.setChanged();
        this.notifyObservers();
    }


    private CollisionDetails timeUntilCollision(Ball ball) {
        Circle ballCircle = ball.getCircle();
        Vect ballVelocity = ball.getVelocity();
        Vect newVelo = new Vect(0.0D, 0.0D);

        double shortestTime = Double.MAX_VALUE;
        double time;
        IGizmo gizmo = null;

        for (IGizmo iIGizmo : iGizmos) {
            // Ignore collisions if ball is inside Absorber
            if (iIGizmo instanceof AbsorberGizmo && ((AbsorberGizmo) iIGizmo).isInside(ball))
                continue;

            if (iIGizmo instanceof FlipperGizmo && ((FlipperGizmo) iIGizmo).isMoving()) {
                // Moving Flipper physics
                double angularVelocity = Math.toRadians(((FlipperGizmo) iIGizmo).getAngularVelocity());

                Vect center = ((FlipperGizmo) iIGizmo).getRotationCenter();
                for (Circle circle : iIGizmo.getCircles()) {
                    time = timeUntilRotatingCircleCollision(circle, center, angularVelocity, ballCircle, ballVelocity);
                    if (time < shortestTime) {
                        gizmo = iIGizmo;
                        shortestTime = time;
                        newVelo = reflectRotatingCircle(circle, center, angularVelocity, ballCircle, ballVelocity, .95D);
                    }
                }

                for (LineSegment line : iIGizmo.getLines()) {
                    time = timeUntilRotatingWallCollision(line, center, angularVelocity, ballCircle, ballVelocity);
                    if (time < shortestTime) {
                        gizmo = iIGizmo;
                        shortestTime = time;
                        newVelo = reflectRotatingWall(line, center, angularVelocity, ballCircle, ballVelocity, .95D);
                    }
                }
            } else {
                // Static Physics
                for (Circle circle : iIGizmo.getCircles()) {
                    time = timeUntilCircleCollision(circle, ballCircle, ballVelocity);
                    if (time < shortestTime) {
                        gizmo = iIGizmo;
                        shortestTime = time;
                        newVelo = reflectCircle(circle.getCenter(), ballCircle.getCenter(), ballVelocity);
                    }
                }

                for (LineSegment line : iIGizmo.getLines()) {
                    time = timeUntilWallCollision(line, ballCircle, ballVelocity);
                    if (time < shortestTime) {
                        gizmo = iIGizmo;
                        shortestTime = time;
                        newVelo = reflectWall(line, ballVelocity, 1.0D);
                    }
                }
            }
        }

        for (LineSegment line : walls) {
            time = timeUntilWallCollision(line, ballCircle, ballVelocity);
            if (time < shortestTime) {
                shortestTime = time;
                newVelo = reflectWall(line, ballVelocity, 1.0D);
            }
        }

        Ball ball_ = null;
        VectPair newVelo_ = null;
        for (Ball b : balls) {
            if (b != ball) {
                time = timeUntilBallBallCollision(ballCircle, ballVelocity, b.getCircle(), b.getVelocity());
                if (time < shortestTime) {
                    ball_ = b;
                    shortestTime = time;
                    newVelo_ = reflectBalls(ballCircle.getCenter(), ballMass, ballVelocity, b.getCircle().getCenter(), ballMass, b.getVelocity());
                }
            }
        }

        return ball_ != null ? new CollisionDetails(ball, shortestTime, newVelo_, ball_) : new CollisionDetails(ball, shortestTime, newVelo, gizmo);
    }

    private Ball moveBallForTime(Ball ball, double time) {
        double xVel = ball.getVelocity().x();
        double yVel = ball.getVelocity().y();
        double newX = ball.getX() + (xVel * time);
        double newY = ball.getY() + (yVel * time);
        ball.setX(newX);
        ball.setY(newY);
        return ball;
    }

    private Ball friction(Ball ball, double delta_t) {
        double xVel = ball.getVelocity().x();
        double yVel = ball.getVelocity().y();
        xVel *= (1 - mu * delta_t - mu2 * Math.abs(xVel) * delta_t);
        yVel *= (1 - mu * delta_t - mu2 * Math.abs(yVel) * delta_t);
        ball.setVelocity(xVel, yVel);
        return ball;
    }

    private Ball gravity(Ball ball, double delta_t) {
        double xVel = ball.getVelocity().x();
        double yVel = ball.getVelocity().y();
        yVel += gravity * delta_t;
        ball.setVelocity(xVel, yVel);
        return ball;
    }

    private void moveFlippersForTime(double delta_t) {
        for (FlipperGizmo f : this.getFlippers())
            f.moveFlipperForTime(delta_t);
    }

    public void setGravity(int newGravity) {
        gravity = newGravity;
    }

    public void setFriction(double newFriction) {
        mu = newFriction;
        mu2 = newFriction;
    }

    public List<IGizmo> getGizmos() {
        return iGizmos;
    }

    public IGizmo getGizmoByName(String name) {
        for (IGizmo gizmo : iGizmos) {
            if (gizmo.getId().equals(name)) {
                return gizmo;
            }
        }
        return null;
    }

    public List<CircleGizmo> getCircles() {
        List<CircleGizmo> l = new ArrayList<>();
        for (IGizmo g : iGizmos)
            if (g instanceof CircleGizmo)
                l.add((CircleGizmo) g);
        return l;
    }

    public List<SquareGizmo> getSquares() {
        List<SquareGizmo> l = new ArrayList<>();
        for (IGizmo g : iGizmos)
            if (g instanceof SquareGizmo)
                l.add((SquareGizmo) g);
        return l;
    }

    public List<TriangleGizmo> getTriangles() {
        List<TriangleGizmo> l = new ArrayList<>();
        for (IGizmo g : iGizmos)
            if (g instanceof TriangleGizmo)
                l.add((TriangleGizmo) g);
        return l;
    }

    public List<AbsorberGizmo> getAbsorbers() {
        List<AbsorberGizmo> l = new ArrayList<>();
        for (IGizmo g : iGizmos)
            if (g instanceof AbsorberGizmo)
                l.add((AbsorberGizmo) g);
        return l;
    }

    public List<FlipperGizmo> getFlippers() {
        List<FlipperGizmo> l = new ArrayList<>();
        for (IGizmo g : iGizmos)
            if (g instanceof FlipperGizmo)
                l.add((FlipperGizmo) g);
        return l;
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public TriangleGizmo getTriangleByName(String name) {
        for (TriangleGizmo t : getTriangles())
            if (name.equals(t.getId()))
                return t;
        return null;
    }

    public FlipperGizmo getFlipperByName(String name) {
        for (FlipperGizmo f : getFlippers())
            if (name.equals(f.getId()))
                return f;
        return null;
    }

    public HashMap<Integer, KeyConnection> getKeyConnections() {
        return keyConnections;
    }

    public void addGizmo(IGizmo gizmo) {
        iGizmos.add(gizmo);
        this.setChanged();
        this.notifyObservers();
    }

    public void addBall(Ball b) {
        balls.add(b);
        this.setChanged();
        this.notifyObservers();
    }

    public void addConnection(Connection c) {
        connections.put(c.getTrigger(), c);
    }

    public HashMap<IGizmo, Connection> getConnections() {
        return connections;
    }

    public void removeConnection(Connection remove) {
        connections.remove(remove.getTrigger(), remove);
    }

    public void addKeyConnection(KeyConnection kc) {
        keyConnections.put(kc.getKey(), kc);
    }

    public void removeGizmo(IGizmo gizmo) {
        iGizmos.remove(gizmo);
    }

    public void clear() {
        iGizmos = new ArrayList<>();
        balls = new ArrayList<>();
    }

    @Override
    public Model clone() {
        try {
            return (Model) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}