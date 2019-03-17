package Model;

import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;

public class Model extends Observable implements Cloneable {

    private static final double moveTime = 0.05;
    private static final int gridSizeX = 20;
    private static final int gridSizeY = 20;
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

        for (Ball ball : balls) {
            if (ball.isMoving()) {
                CollisionDetails cd = timeUntilCollision(ball);
                double tuc = cd.getTuc();

                if (tuc > moveTime) {
                    moveBallForTime(ball, moveTime);

                    friction(ball, moveTime);
                    gravity(ball, moveTime);
                } else {
                    moveBallForTime(ball, tuc);

                    ball.setVelocity(cd.getVelo());

                    friction(ball, tuc);
                    gravity(ball, tuc);

                    moveTime = tuc;

                    if(cd.getGizmo() != null) {
                        cd.getGizmo().trigger(ball);
                        if (connections.containsKey(cd.getGizmo()))
                            connections.get(cd.getGizmo()).triggered(ball);
                    }
                }
            }
        }

        moveFlippersForTime(moveTime);

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

                Vect center = iIGizmo.getCircles().get(0).getCenter();
                for (Circle circle : iIGizmo.getCircles()) {
                    time = Geometry.timeUntilRotatingCircleCollision(circle, center, angularVelocity, ballCircle, ballVelocity);
                    if (time < shortestTime) {
                        gizmo = iIGizmo;
                        shortestTime = time;
                        newVelo = Geometry.reflectRotatingCircle(circle, center, angularVelocity, ballCircle, ballVelocity, .95D);
                    }
                }

                for (LineSegment line : iIGizmo.getLines()) {
                    time = Geometry.timeUntilRotatingWallCollision(line, center, angularVelocity, ballCircle, ballVelocity);
                    if (time < shortestTime) {
                        gizmo = iIGizmo;
                        shortestTime = time;
                        newVelo = Geometry.reflectRotatingWall(line, center, angularVelocity, ballCircle, ballVelocity, .95D);
                    }
                }
            } else {
                // Static Physics
                for (Circle circle : iIGizmo.getCircles()) {
                    time = Geometry.timeUntilCircleCollision(circle, ballCircle, ballVelocity);
                    if (time < shortestTime) {
                        gizmo = iIGizmo;
                        shortestTime = time;
                        newVelo = Geometry.reflectCircle(circle.getCenter(), ballCircle.getCenter(), ballVelocity);
                    }
                }

                for (LineSegment line : iIGizmo.getLines()) {
                    time = Geometry.timeUntilWallCollision(line, ballCircle, ballVelocity);
                    if (time < shortestTime) {
                        gizmo = iIGizmo;
                        shortestTime = time;
                        newVelo = Geometry.reflectWall(line, ballVelocity, 1.0D);
                    }
                }
            }
        }

        for (LineSegment line : walls) {
            time = Geometry.timeUntilWallCollision(line, ballCircle, ballVelocity);
            if (time < shortestTime) {
                shortestTime = time;
                newVelo = Geometry.reflectWall(line, ballVelocity, 1.0D);
            }
        }

        return new CollisionDetails(shortestTime, newVelo, gizmo);
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

    public void setFriction(int newFriction) {
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

    public HashMap<IGizmo, Connection> getConnections(){
        return connections;
    }

    public void removeConnection(Connection remove){
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
