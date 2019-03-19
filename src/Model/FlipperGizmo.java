package Model;

import physics.Circle;
import physics.LineSegment;
import physics.Vect;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class FlipperGizmo implements IGizmo {

    private List<List<Integer>> occupiedSpace;

    public enum Rotation {
        TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT
    }

    private static final double angularVelocity = 1080;
    private static final double flipperWidth = .5;

    private String id;
    private int x;
    private int y;
    private boolean left;
    private double angle;
    private Rotation rotation;
    private boolean flipped;
    private Color colour;

    public FlipperGizmo(String id, int x, int y, boolean isLeft) {
        this.id = id;
        this.x = x;
        this.y = y;
        left = isLeft;
        flipped = false;
        colour = Color.green;
        rotation = left ? Rotation.TOP_LEFT : Rotation.TOP_RIGHT;
        setOccupiedSpace();
    }

    public void setOccupiedSpace() {
        occupiedSpace = new ArrayList<>();
        ArrayList<Integer> origin = new ArrayList<>();
        origin.add(x);
        origin.add(y);

        ArrayList<Integer> second = new ArrayList<>();
        second.add(x);
        second.add(y + 1);

        ArrayList<Integer> third = new ArrayList<>();
        third.add(x + 1);
        third.add(y);

        ArrayList<Integer> fourth = new ArrayList<>();
        fourth.add(x + 1);
        fourth.add(y + 1);

        occupiedSpace.add(origin);
        occupiedSpace.add(second);
        occupiedSpace.add(third);
        occupiedSpace.add(fourth);
    }

    @Override
    public List<Circle> getCircles() {
        List<Circle> l = new ArrayList<>();
        double x = 0, y = 0, x2 = 0, y2 = 0;
        if (left) {
            switch (rotation) {
                case TOP_LEFT:
                    x = this.x + flipperWidth / 2;
                    y = this.y + flipperWidth / 2;
                    x2 = x + (2 - flipperWidth) * Math.sin(Math.toRadians(angle));
                    y2 = y + (2 - flipperWidth) * Math.sin(Math.toRadians(90 - angle));
                    break;
                case TOP_RIGHT:
                    x = this.x + 2 - flipperWidth / 2;
                    y = this.y + flipperWidth / 2;
                    x2 = x - (2 - flipperWidth) * Math.sin(Math.toRadians(90 - angle));
                    y2 = y + (2 - flipperWidth) * Math.sin(Math.toRadians(angle));
                    break;
                case BOTTOM_RIGHT:
                    x = this.x + 2 - flipperWidth / 2;
                    y = this.y + 2 - flipperWidth / 2;
                    x2 = x - (2 - flipperWidth) * Math.sin(Math.toRadians(angle));
                    y2 = y - (2 - flipperWidth) * Math.sin(Math.toRadians(90 - angle));
                    break;
                case BOTTOM_LEFT:
                    x = this.x + flipperWidth / 2;
                    y = this.y + 2 - flipperWidth / 2;
                    x2 = x + (2 - flipperWidth) * Math.sin(Math.toRadians(90 - angle));
                    y2 = y - (2 - flipperWidth) * Math.sin(Math.toRadians(angle));
                    break;
            }
        } else {
            switch (rotation) {
                case TOP_RIGHT:
                    x = this.x + 2 - flipperWidth / 2;
                    y = this.y + flipperWidth / 2;
                    x2 = x - (2 - flipperWidth) * Math.sin(Math.toRadians(angle));
                    y2 = y + (2 - flipperWidth) * Math.sin(Math.toRadians(90 - angle));
                    break;
                case BOTTOM_RIGHT:
                    x = this.x + 2 - flipperWidth / 2;
                    y = this.y + 2 - flipperWidth / 2;
                    x2 = x - (2 - flipperWidth) * Math.sin(Math.toRadians(90 - angle));
                    y2 = y - (2 - flipperWidth) * Math.sin(Math.toRadians(angle));
                    break;
                case BOTTOM_LEFT:
                    x = this.x + flipperWidth / 2;
                    y = this.y + 2 - flipperWidth / 2;
                    x2 = x + (2 - flipperWidth) * Math.sin(Math.toRadians(angle));
                    y2 = y - (2 - flipperWidth) * Math.sin(Math.toRadians(90 - angle));
                    break;
                case TOP_LEFT:
                    x = this.x + flipperWidth / 2;
                    y = this.y + flipperWidth / 2;
                    x2 = x + (2 - flipperWidth) * Math.sin(Math.toRadians(90 - angle));
                    y2 = y + (2 - flipperWidth) * Math.sin(Math.toRadians(angle));
                    break;
            }
        }
        l.add(new Circle(x, y, flipperWidth / 2));
        l.add(new Circle(x2, y2, flipperWidth / 2));
        return l;
    }

    @Override
    public List<LineSegment> getLines() {
        List<LineSegment> l = new ArrayList<>();
        double x = 0, y = 0, x2 = 0, y2 = 0;
        double x_line_, y_line_, x_line_2, y_line_2;
        double x_change = 0, y_change = 0;

        if (left) {
            switch (rotation) {
                case TOP_LEFT:
                    x = this.x + flipperWidth / 2;
                    y = this.y + flipperWidth / 2;
                    x2 = x + (2 - flipperWidth) * Math.sin(Math.toRadians(angle));
                    y2 = y + (2 - flipperWidth) * Math.sin(Math.toRadians(90 - angle));
                    x_change = flipperWidth / 2 * Math.sin(Math.toRadians(90 - angle));
                    y_change = flipperWidth / 2 * Math.sin(Math.toRadians(angle));
                    break;
                case TOP_RIGHT:
                    x = this.x + 2 - flipperWidth / 2;
                    y = this.y + flipperWidth / 2;
                    x2 = x - (2 - flipperWidth) * Math.sin(Math.toRadians(90 - angle));
                    y2 = y + (2 - flipperWidth) * Math.sin(Math.toRadians(angle));
                    x_change = flipperWidth / 2 * Math.sin(Math.toRadians(angle));
                    y_change = flipperWidth / 2 * Math.sin(Math.toRadians(90 - angle));
                    break;
                case BOTTOM_RIGHT:
                    x = this.x + 2 - flipperWidth / 2;
                    y = this.y + 2 - flipperWidth / 2;
                    x2 = x - (2 - flipperWidth) * Math.sin(Math.toRadians(angle));
                    y2 = y - (2 - flipperWidth) * Math.sin(Math.toRadians(90 - angle));
                    x_change = flipperWidth / 2 * Math.sin(Math.toRadians(90 - angle));
                    y_change = flipperWidth / 2 * Math.sin(Math.toRadians(angle));
                    break;
                case BOTTOM_LEFT:
                    x = this.x + flipperWidth / 2;
                    y = this.y + 2 - flipperWidth / 2;
                    x2 = x + (2 - flipperWidth) * Math.sin(Math.toRadians(90 - angle));
                    y2 = y - (2 - flipperWidth) * Math.sin(Math.toRadians(angle));
                    x_change = flipperWidth / 2 * Math.sin(Math.toRadians(angle));
                    y_change = flipperWidth / 2 * Math.sin(Math.toRadians(90 - angle));
                    break;
            }
        } else {
            switch (rotation) {
                case TOP_RIGHT:
                    x = this.x + 2 - flipperWidth / 2;
                    y = this.y + flipperWidth / 2;
                    x2 = x - (2 - flipperWidth) * Math.sin(Math.toRadians(angle));
                    y2 = y + (2 - flipperWidth) * Math.sin(Math.toRadians(90 - angle));
                    x_change = flipperWidth / 2 * Math.sin(Math.toRadians(90 - angle));
                    y_change = flipperWidth / 2 * Math.sin(Math.toRadians(angle));
                    break;
                case BOTTOM_RIGHT:
                    x = this.x + 2 - flipperWidth / 2;
                    y = this.y + 2 - flipperWidth / 2;
                    x2 = x - (2 - flipperWidth) * Math.sin(Math.toRadians(90 - angle));
                    y2 = y - (2 - flipperWidth) * Math.sin(Math.toRadians(angle));
                    x_change = flipperWidth / 2 * Math.sin(Math.toRadians(angle));
                    y_change = flipperWidth / 2 * Math.sin(Math.toRadians(90 - angle));
                    break;
                case BOTTOM_LEFT:
                    x = this.x + flipperWidth / 2;
                    y = this.y + 2 - flipperWidth / 2;
                    x2 = x + (2 - flipperWidth) * Math.sin(Math.toRadians(angle));
                    y2 = y - (2 - flipperWidth) * Math.sin(Math.toRadians(90 - angle));
                    x_change = flipperWidth / 2 * Math.sin(Math.toRadians(90 - angle));
                    y_change = flipperWidth / 2 * Math.sin(Math.toRadians(angle));
                    break;
                case TOP_LEFT:
                    x = this.x + flipperWidth / 2;
                    y = this.y + flipperWidth / 2;
                    x2 = x + (2 - flipperWidth) * Math.sin(Math.toRadians(90 - angle));
                    y2 = y + (2 - flipperWidth) * Math.sin(Math.toRadians(angle));
                    x_change = flipperWidth / 2 * Math.sin(Math.toRadians(angle));
                    y_change = flipperWidth / 2 * Math.sin(Math.toRadians(90 - angle));
                    break;
            }
        }
        x_line_ = x + x_change;
        y_line_ = y - y_change;
        x_line_2 = x2 + x_change;
        y_line_2 = y2 - y_change;
        l.add(new LineSegment(x_line_, y_line_, x_line_2, y_line_2));

        x_line_ = x - x_change;
        y_line_ = y + y_change;
        x_line_2 = x2 - x_change;
        y_line_2 = y2 + y_change;
        l.add(new LineSegment(x_line_, y_line_, x_line_2, y_line_2));
        return l;
    }

    public Vect getRotationCenter() {
        switch (rotation) {
            case TOP_LEFT:
                return new Vect(x + flipperWidth / 2, y + flipperWidth / 2);
            case TOP_RIGHT:
                return new Vect(x + 2 - flipperWidth / 2, y + flipperWidth / 2);
            case BOTTOM_RIGHT:
                return new Vect(x + 2 - flipperWidth / 2, y + 2 - flipperWidth / 2);
            case BOTTOM_LEFT:
            default:
                return new Vect(x + flipperWidth / 2, y + 2 - flipperWidth / 2);
        }
    }

    @Override
    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
        setOccupiedSpace();
    }

    @Override
    public void trigger(Ball ball) {
        flipped = !flipped;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public List<List<Integer>> getOccupiedSpace() {
        return occupiedSpace;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getAngle() {
        return angle;
    }

    public double getAngularVelocity() {
        return (!flipped && left || flipped && !left) ? angularVelocity : -angularVelocity;
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

    public void moveFlipperForTime(double delta_t) {
        double newAngle;
        newAngle = flipped ? angle + angularVelocity * delta_t : angle - angularVelocity * delta_t;

        angle = newAngle > 90 ? 90 : newAngle < 0 ? 0 : newAngle;
    }

    public Color getColour() {
        return colour;
    }

    public boolean isMoving() {
        return flipped ? angle < 90 : angle > 0;
    }

    public Rotation getState() {
        return rotation;
    }
}
