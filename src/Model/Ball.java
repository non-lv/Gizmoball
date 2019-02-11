package Model;

import physics.Circle;
import physics.Vect;

public class Ball {

    private Vect velocity;
    private double xpos;
    private double ypos;

    public Ball(double x, double y, double xv, double yv) {
        xpos = x;
        ypos = y;
        velocity = new Vect(xv, yv);
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

    public void setVelocity(double xv, double yv){ velocity = new Vect(xv, yv); }

    public double getX() {
        return xpos;
    }

    public double getY() {
        return ypos;
    }
}
