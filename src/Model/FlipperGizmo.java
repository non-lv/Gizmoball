package Model;

import physics.Circle;
import physics.LineSegment;

import java.util.ArrayList;
import java.util.List;

public class FlipperGizmo implements IGizmo {

    public enum Rotation {
        TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT
    }

    private static final double angularVelocity = 90;

    private String id;
    private int xpos;
    private int ypos;
    private boolean left;
    private double angle;
    private Rotation rotation;

    public FlipperGizmo(String id, int x, int y, boolean isLeft) {
        this.id = id;
        xpos = x;
        ypos = y;
        left = isLeft;
        if (left)
            rotation = Rotation.TOP_LEFT;
        else
            rotation = Rotation.TOP_RIGHT;
    }

    @Override
    public List<Circle> getCircles() {
        List<Circle> l = new ArrayList<>();
        double x, y, x2, y2;
        if (left) {
            switch (rotation) {
                case TOP_LEFT:
                    x = xpos + .25;
                    y = ypos + .25;
                    x2 = x + 1.5 * Math.sin(Math.toRadians(90 - angle));
                    y2 = y + 1.5 * Math.sin(Math.toRadians(angle));

                    l.add(new Circle(x, y, .25));
                    l.add(new Circle(x2, y2, .25));
                    break;
                case TOP_RIGHT:
                    x = xpos + 1.75;
                    y = ypos + .25;
                    x2 = x - 1.5 * Math.sin(Math.toRadians(90 - angle));
                    y2 = y + 1.5 * Math.sin(Math.toRadians(angle));

                    l.add(new Circle(x, y, .25));
                    l.add(new Circle(x2, y2, .25));
                    break;
                case BOTTOM_RIGHT:
                    x = xpos + 1.75;
                    y = ypos + 1.75;
                    x2 = x - 1.5 * Math.sin(Math.toRadians(90 - angle));
                    y2 = y - 1.5 * Math.sin(Math.toRadians(angle));

                    l.add(new Circle(x, y, .25));
                    l.add(new Circle(x2, y2, .25));
                    break;
                case BOTTOM_LEFT:
                    x = xpos + .25;
                    y = ypos + 1.75;
                    x2 = x + 1.5 * Math.sin(Math.toRadians(90 - angle));
                    y2 = y - 1.5 * Math.sin(Math.toRadians(angle));

                    l.add(new Circle(x, y, .25));
                    l.add(new Circle(x2, y2, .25));
                    break;
            }
        } else {
            switch (rotation) {
                case TOP_RIGHT:
                    x = xpos + 1.75;
                    y = ypos + .25;
                    x2 = x - 1.5 * Math.sin(Math.toRadians(90 - angle));
                    y2 = y + 1.5 * Math.sin(Math.toRadians(angle));

                    l.add(new Circle(x, y, .25));
                    l.add(new Circle(x2, y2, .25));
                case BOTTOM_RIGHT:
                    x = xpos + 1.75;
                    y = ypos + 1.75;
                    x2 = x - 1.5 * Math.sin(Math.toRadians(90 - angle));
                    y2 = y - 1.5 * Math.sin(Math.toRadians(angle));

                    l.add(new Circle(x, y, .25));
                    l.add(new Circle(x2, y2, .25));
                case BOTTOM_LEFT:
                    x = xpos + .25;
                    y = ypos + 1.75;
                    x2 = x + 1.5 * Math.sin(Math.toRadians(90 - angle));
                    y2 = y - 1.5 * Math.sin(Math.toRadians(angle));

                    l.add(new Circle(x, y, .25));
                    l.add(new Circle(x2, y2, .25));
                case TOP_LEFT:
                    x = xpos + .25;
                    y = ypos + .25;
                    x2 = x + 1.5 * Math.sin(Math.toRadians(90 - angle));
                    y2 = y + 1.5 * Math.sin(Math.toRadians(angle));

                    l.add(new Circle(x, y, .25));
                    l.add(new Circle(x2, y2, .25));
            }
        }
        return l;
    }

    @Override
    public List<LineSegment> getLines() {
        return new ArrayList<>();
    }

    @Override
    public void setPos() {

    }

    @Override
    public void trigger() {

    }

    @Override
    public String getId() {
        return id;
    }

    public int getX() {
        return xpos;
    }

    public int getY() {
        return ypos;
    }

    public double getAngle() {
        return angle;
    }

    public double getAngularVelocity() {
        return angularVelocity;
    }

    public void setAngle(double newAngle) {
        angle = newAngle;
    }

    public boolean isLeft() {
        return left;
    }

    public void rotate() {
        switch (rotation) {
            case TOP_LEFT:
                rotation = Rotation.TOP_RIGHT;
                break;
            case TOP_RIGHT:
                rotation = Rotation.BOTTOM_RIGHT;
                break;
            case BOTTOM_RIGHT:
                rotation = Rotation.BOTTOM_LEFT;
                break;
            default:
                rotation = Rotation.TOP_LEFT;
        }
    }


    public Rotation getState() {
        return rotation;
    }
}
