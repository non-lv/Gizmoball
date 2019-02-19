package Model;

import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Model extends Observable {

    private static final double mu = 0.025;
    private static final double mu2 = 0.025;
    private static final double gravity = 25;
    private static final double moveTime = 0.05;
    private static final int gridSizeX = 20;
    private static final int gridSizeY = 20;

    private List<IGizmo> iGizmos;
    private List<LineSegment> walls;
    private List<Ball> balls;

    private int rightFlipperFlippin;
    private int leftFlipperFlippin;

    public Model() {
        iGizmos = new ArrayList<>();
        walls = new ArrayList<>();
        balls = new ArrayList<>();

        walls.add(new LineSegment(0, 0, gridSizeX, 0));
        walls.add(new LineSegment(0, 0, 0, gridSizeY));
        walls.add(new LineSegment(gridSizeX, 0, gridSizeX, gridSizeY));
        walls.add(new LineSegment(0, gridSizeY, gridSizeX, gridSizeY));

        rightFlipperFlippin = -1;
        leftFlipperFlippin = -1;
    }

    public List<CircleGizmo> getCircles() {
        List<CircleGizmo> l = new ArrayList<>();
        for (IGizmo g : iGizmos)
            if (g instanceof CircleGizmo)
                l.add((CircleGizmo) g);
        return l;
    }

    public List<SquareGizmo> getSquare() {
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

    public List<AbsorberGizmo> getAbsorber() {
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

    public void addGizmo(IGizmo gizmo){
        iGizmos.add(gizmo);
        this.setChanged();
        this.notifyObservers();
    }

    public void addBall(Ball b) {
        balls.add(b);
        this.setChanged();
        this.notifyObservers();
    }

    public TriangleGizmo getTrianglebyName(String name) {
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


    public void fireAbsorbers() {
        for (AbsorberGizmo ag : this.getAbsorber())
            ag.fire();
    }

    public void moveBalls() {
        double moveTime = Model.moveTime;

        for (Ball ball : balls) {
            System.out.println(ball.getSpeed());
            if (ball.isMoving()) {
                CollisionDetails cd = timeUntilCollision(ball);
                double tuc = cd.getTuc();

                if (tuc > moveTime) {
                    moveBallForTime(ball, moveTime);

                    friction(ball, moveTime);
                    gravity(ball, moveTime);
                } else {

                    if (cd.getGizmo() instanceof AbsorberGizmo) {
                        ((AbsorberGizmo) cd.getGizmo()).trigger(ball);
                        break;
                    }

                    moveBallForTime(ball, tuc);

                    ball.setVelocity(cd.getVelo());

                    friction(ball, tuc);
                    gravity(ball, tuc);

                    moveTime = tuc;
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
        double time = 0.0D;
        IGizmo gizmo = null;

        for (IGizmo iIGizmo : iGizmos) {
            // Ignore collisions if ball is inside Absorber
            if (iIGizmo instanceof AbsorberGizmo && ((AbsorberGizmo) iIGizmo).isInside(ball))
                continue;

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


        for (LineSegment line : walls) {
            time = Geometry.timeUntilWallCollision(line, ballCircle, ballVelocity);
            if (time < shortestTime) {
                shortestTime = time;
                newVelo = Geometry.reflectWall(line, ballVelocity, 1.0D);
            }
        }

        return new CollisionDetails(shortestTime, newVelo, gizmo);

    }

    private void moveFlippersForTime(double delta_t) {
        for (FlipperGizmo f : this.getFlippers())
            if (f.isLeft())
                moveFlipperForTime(f, delta_t, leftFlipperFlippin);
            else moveFlipperForTime(f, delta_t, rightFlipperFlippin);
    }

    private FlipperGizmo moveFlipperForTime(FlipperGizmo flipper, double delta_t, double modifier) {
        double newAngle = flipper.getAngle() + flipper.getAngularVelocity() * delta_t * modifier;

        if (newAngle > 90)
            newAngle = 90;
        else if (newAngle < 0)
            newAngle = 0;

        flipper.setAngle(newAngle);
        return flipper;
    }

    private Ball moveBallForTime(Ball ball, double time) {
        double newX = 0.D;
        double newY = 0.D;
        double xVel = ball.getVelocity().x();
        double yVel = ball.getVelocity().y();
        newX = ball.getX() + (xVel * time);
        newY = ball.getY() + (yVel * time);
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

    public void rightFlipperMove() {
        rightFlipperFlippin = 1;
    }

    public void rightFlipperStop() {
        rightFlipperFlippin = -1;
    }

    public void leftFlipperMove() {
        leftFlipperFlippin = 1;
    }

    public void leftFlipperStop() {
        leftFlipperFlippin = -1;
    }
}
