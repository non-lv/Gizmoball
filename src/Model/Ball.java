package Model;

import physics.Circle;
import physics.Vect;

public class Ball {

    private String id;
    private Vect velocity;
    private double xpos;
    private double ypos;
    private boolean moving;

    public Ball(String id, double x, double y, double xv, double yv) {
        this.id = id;
        xpos = x;
        ypos = y;
        velocity = new Vect(xv, yv);
        moving = true;
    }

    public Vect getVelocity() {
        return velocity;
    }

    public Circle getCircle() {
        return new Circle(xpos, ypos, .25);
    }

    public void setX(double x) {
        xpos = x;
    }

    public void setY(double y) {
        ypos = y;
    }

    public void setVelocity(double xv, double yv) {
        velocity = new Vect(xv, yv);
    }

    public void setVelocity(Vect velocity) {
        this.velocity = velocity;
    }

    public double getX() {
        return xpos;
    }

    public double getY() {
        return ypos;
    }

    public double getRadius() {
        return .25;
    }

    public void stop() {
        moving = false;
    }

    public void move() {
        moving = true;
    }

    public boolean isMoving() {
        return moving;
    }

    public double getSpeed() {
        if (moving)
            return Math.sqrt(Math.pow(velocity.x(), 2) + Math.pow(velocity.y(), 2));
        else return 0.0D;
    }
}

