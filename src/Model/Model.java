package Model;

import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Model extends Observable {

    private ArrayList<CircleGizmo> circles;
    private ArrayList<SquareGizmo> squares;
    private ArrayList<TriangleGizmo> triangles;
    private ArrayList<AbsorberGizmo> absorber;
    private ArrayList<FlipperGizmo> flippers;
    private static double mu = 0.025;
    private static double mu2 = 0.025;
    private static double gravity = 25;
    private static double moveTime = 0.05;

    private List<Gizmo> gizmos;
    private List<Ball> balls;

    public Model() {
        gizmos = new ArrayList<>();
        circles = new ArrayList<>();
        squares = new ArrayList<>();
        triangles = new ArrayList<>();
        absorber = new ArrayList<>();
        flippers = new ArrayList<>();
    }

    public ArrayList<CircleGizmo> getCircles() {
        return circles;
    }

    public ArrayList<SquareGizmo> getSquare() {
        return squares;
    }

    public ArrayList<TriangleGizmo> getTriangles() {
        return triangles;
    }

    public ArrayList<AbsorberGizmo> getAbsorber() {
        return absorber;
    }

    public ArrayList<FlipperGizmo> getFlippers() {
        return flippers;
    }

    public void addCircle(CircleGizmo c) {
        circles.add(c);
    }

    public void addSquare(SquareGizmo s) {
        squares.add(s);
    }

    public void addTriangle(TriangleGizmo t) {
        triangles.add(t);
    }

    public void addAbsorber(AbsorberGizmo a) {
        absorber.add(a);
    }

    public TriangleGizmo getTrianglebyName(String name) {
        for (TriangleGizmo t : triangles) {
            if (name.equals(t.getName())) {

                return t;
            }

        }
        return null;
    }

        public void addFlipper (FlipperGizmo f){
            flippers.add(f);
        }
        private void moveBalls () {
            double moveTime = this.moveTime;

            for (Ball ball : balls) {
                CollisionDetails cd = timeUntilCollision(ball);
                double tuc = cd.getTuc();
                if (tuc > moveTime) {
                    //ball = moveBallForTime(ball, moveTime);

                    friction(ball, moveTime);
                    gravity(ball, moveTime);
                } else {
                    //ball = moveBallForTime(ball, moveTime);

                    //ball.setVelocity(cd.getVelo());

                    friction(ball, tuc);
                    gravity(ball, tuc);
                }
            }

            this.setChanged();
            this.notifyObservers();
        }

        private CollisionDetails timeUntilCollision (Ball ball){
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

        private void friction (Ball ball,double delta_t){
            double xVel = ball.getVelocity().x();
            double yVel = ball.getVelocity().y();
            xVel *= (1 - mu * delta_t - mu2 * Math.abs(xVel) * delta_t);
            yVel *= (1 - mu * delta_t - mu2 * Math.abs(yVel) * delta_t);
            ball.setVelocity(xVel, yVel);
        }

        private void gravity (Ball ball,double delta_t){
            double xVel = ball.getVelocity().x();
            double yVel = ball.getVelocity().y();
            xVel -= gravity * delta_t;
            ball.setVelocity(xVel, yVel);
        }
    }
