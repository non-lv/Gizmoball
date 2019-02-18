package Model;

import physics.Circle;
import physics.Vect;

public class Ball {

    private String id;
    private Vect velocity;
    private double xpos;
    private double ypos;
    private boolean moving;

    public Ball(double x, double y, double xv, double yv) {
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

    public double getRadius(){
        return .25;
    }

    public void stop(){
        moving = false;
    }

    public void move(){
        moving = true;
    }

    public boolean isMoving(){
        return moving;
    }
}

