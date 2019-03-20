package Model;

import physics.Circle;
import physics.Vect;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Ball {

    private static final double radius = .25;

    private String id;
    private Vect velocity;
    private double x;
    private double y;
    private boolean moving;
    private Color colour;
    private List<List<Double>> occupiedSpace;

    public Ball(String id, double x, double y, double xv, double yv) {
        this.id = id;
        this.x = x;
        this.y = y;
        colour = Color.black;
        velocity = new Vect(xv, yv);
        moving = true;
        setOccupiedSpace();
    }

    private void setOccupiedSpace() {
        occupiedSpace = new ArrayList<>();
        ArrayList<Double> top = new ArrayList<>();
        top.add(x);
        top.add(y + radius);

        ArrayList<Double> bottom = new ArrayList<>();
        bottom.add(x);
        bottom.add(y - radius);

        ArrayList<Double> left = new ArrayList<>();
        left.add(x - radius);
        left.add(y);

        ArrayList<Double> right = new ArrayList<>();
        right.add(x + radius);
        right.add(y);

        occupiedSpace.add(top);
        occupiedSpace.add(bottom);
        occupiedSpace.add(left);
        occupiedSpace.add(right);
    }

    public List<List<Double>> getOccupiedSpace() {
        setOccupiedSpace();
        return occupiedSpace;
    }

    public Vect getVelocity() {
        return velocity;
    }

    public Circle getCircle() {
        return new Circle(x, y, radius);
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setVelocity(double xv, double yv) {
        velocity = new Vect(xv, yv);
    }

    public void setVelocity(Vect velocity) {
        this.velocity = velocity;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
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
        return moving ? Math.sqrt(Math.pow(velocity.x(), 2) + Math.pow(velocity.y(), 2)) : 0.0D;
    }

    public String getId() {
        return id;
    }

    public Color getColour() {
        return colour;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Ball))
            return false;

        if (o == this)
            return true;

        Ball ball = (Ball) o;

        return ball.getX() == x && ball.getY() == y && ball.getVelocity().x() == velocity.x() && ball.getVelocity().y() == velocity.y();
    }
}

