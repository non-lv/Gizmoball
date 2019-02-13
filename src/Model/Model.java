package Model;

import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Model extends Observable {

    private static double mu = 0.025;
    private static double mu2 = 0.025;
    private static double gravity = 25;
    private static double moveTime = 0.05;

    private List<Gizmo> gizmos;
    private List<Ball> balls;

    public Model() {
        gizmos = new ArrayList<>();
    }

    public List<CircleGizmo> getCircles() {
        List<CircleGizmo> l = new ArrayList<>();
        for (Gizmo g : gizmos)
            if (g instanceof CircleGizmo)
                l.add((CircleGizmo) g);
        return l;
    }

    public List<SquareGizmo> getSquare() {
        List<SquareGizmo> l = new ArrayList<>();
        for (Gizmo g : gizmos)
            if (g instanceof SquareGizmo)
                l.add((SquareGizmo) g);
        return l;
    }

    public List<TriangleGizmo> getTriangles() {
        List<TriangleGizmo> l = new ArrayList<>();
        for (Gizmo g : gizmos)
            if (g instanceof TriangleGizmo)
                l.add((TriangleGizmo) g);
        return l;
    }

    public List<AbsorberGizmo> getAbsorber() {
        List<AbsorberGizmo> l = new ArrayList<>();
        for (Gizmo g : gizmos)
            if (g instanceof AbsorberGizmo)
                l.add((AbsorberGizmo) g);
        return l;
    }

    public List<FlipperGizmo> getFlippers() {
        List<FlipperGizmo> l = new ArrayList<>();
        for (Gizmo g : gizmos)
            if (g instanceof FlipperGizmo)
                l.add((FlipperGizmo) g);
        return l;
    }

    public void addCircle(CircleGizmo c) {
        gizmos.add(c);
    }

    public void addSquare(SquareGizmo s) {
        gizmos.add(s);
    }

    public void addTriangle(TriangleGizmo t) {
        gizmos.add(t);
    }

    public void addAbsorber(AbsorberGizmo a) {
        gizmos.add(a);
    }

    public void addFlipper(FlipperGizmo f) {
        gizmos.add(f);
    }

    public TriangleGizmo getTrianglebyName(String name) {
        for (TriangleGizmo t : getTriangles())
            if (name.equals(t.getName()))
                return t;
        return null;
    }

    private void moveBalls() {
        double moveTime = this.moveTime;

        for (Ball ball : balls) {
            CollisionDetails cd = timeUntilCollision(ball);
            double tuc = cd.getTuc();
            if (tuc > moveTime) {
                ball = moveBallForTime(ball, moveTime);

                ball = friction(ball, moveTime);
                ball = gravity(ball, moveTime);
            } else {
                ball = moveBallForTime(ball, moveTime);

                ball.setVelocity(cd.getVelo());

                ball = friction(ball, tuc);
                ball = gravity(ball, tuc);
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
        double time = 0.0D;

        for (Gizmo gizmo : gizmos) {
            for (Circle circle : gizmo.getCircles()) {
                time = Geometry.timeUntilCircleCollision(circle, ballCircle, ballVelocity);
                if (time < shortestTime) {
                    shortestTime = time;
                    newVelo = Geometry.reflectCircle(ballVelocity, new Vect(0, 0), ballVelocity);
                }
            }

            for (LineSegment line : gizmo.getLines()) {
                time = Geometry.timeUntilWallCollision(line, ballCircle, ballVelocity);
                if (time < shortestTime) {
                    shortestTime = time;
                    newVelo = Geometry.reflectWall(line, ballVelocity, 1.0D);
                }
            }
        }

        return new CollisionDetails(shortestTime, newVelo);
    }

    private Ball moveBallForTime(Ball ball, double time) {
        double xVel = ball.getVelocity().x();
        double yVel = ball.getVelocity().y();
        xVel = ball.getX() + (xVel * time);
        yVel = ball.getY() + (yVel * time);
        ball.setVelocity(xVel, yVel);
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
        xVel -= gravity * delta_t;
        ball.setVelocity(xVel, yVel);
        return ball;
    }
}
