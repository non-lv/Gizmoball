package Model;

import physics.Circle;
import physics.LineSegment;

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
        if (left){
            rotation = Rotation.TOP_LEFT;
        }else {
            rotation = Rotation.TOP_RIGHT;
        }
        setOccupiedSpace();
    }

    public void setOccupiedSpace() {
        occupiedSpace = new ArrayList<>();
        ArrayList<Integer> origin = new ArrayList<>();
        origin.add(xpos);
        origin.add(ypos);

        ArrayList<Integer> second = new ArrayList<>();
        second.add(xpos);
        second.add(ypos+1);

        ArrayList<Integer> third = new ArrayList<>();
        third.add(xpos+1);
        third.add(ypos);

        ArrayList<Integer> fourth = new ArrayList<>();
        fourth.add(xpos+1);
        fourth.add(ypos+1);

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
                    x = xpos + flipperWidth / 2;
                    y = ypos + flipperWidth / 2;
                    x2 = x + (2 - flipperWidth) * Math.sin(Math.toRadians(angle));
                    y2 = y + (2 - flipperWidth) * Math.sin(Math.toRadians(90 - angle));
                    break;
                case TOP_RIGHT:
                    x = xpos + 2 - flipperWidth / 2;
                    y = ypos + flipperWidth / 2;
                    x2 = x - (2 - flipperWidth) * Math.sin(Math.toRadians(90 - angle));
                    y2 = y + (2 - flipperWidth) * Math.sin(Math.toRadians(angle));
                    break;
                case BOTTOM_RIGHT:
                    x = xpos + 2 - flipperWidth / 2;
                    y = ypos + 2 - flipperWidth / 2;
                    x2 = x - (2 - flipperWidth) * Math.sin(Math.toRadians(angle));
                    y2 = y - (2 - flipperWidth) * Math.sin(Math.toRadians(90 - angle));
                    break;
                case BOTTOM_LEFT:
                    x = xpos + flipperWidth / 2;
                    y = ypos + 2 - flipperWidth / 2;
                    x2 = x + (2 - flipperWidth) * Math.sin(Math.toRadians(90 - angle));
                    y2 = y - (2 - flipperWidth) * Math.sin(Math.toRadians(angle));
                    break;
            }
        } else {
            switch (rotation) {
                case TOP_RIGHT:
                    x = xpos + 2 - flipperWidth / 2;
                    y = ypos + flipperWidth / 2;
                    x2 = x - (2 - flipperWidth) * Math.sin(Math.toRadians(angle));
                    y2 = y + (2 - flipperWidth) * Math.sin(Math.toRadians(90 - angle));
                    break;
                case BOTTOM_RIGHT:
                    x = xpos + 2 - flipperWidth / 2;
                    y = ypos + 2 - flipperWidth / 2;
                    x2 = x - (2 - flipperWidth) * Math.sin(Math.toRadians(90 - angle));
                    y2 = y - (2 - flipperWidth) * Math.sin(Math.toRadians(angle));
                    break;
                case BOTTOM_LEFT:
                    x = xpos + flipperWidth / 2;
                    y = ypos + 2 - flipperWidth / 2;
                    x2 = x + (2 - flipperWidth) * Math.sin(Math.toRadians(angle));
                    y2 = y - (2 - flipperWidth) * Math.sin(Math.toRadians(90 - angle));
                    break;
                case TOP_LEFT:
                    x = xpos + flipperWidth / 2;
                    y = ypos + flipperWidth / 2;
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
                    x = xpos + flipperWidth / 2;
                    y = ypos + flipperWidth / 2;
                    x2 = x + (2 - flipperWidth) * Math.sin(Math.toRadians(angle));
                    y2 = y + (2 - flipperWidth) * Math.sin(Math.toRadians(90 - angle));
                    x_change = flipperWidth / 2 * Math.sin(Math.toRadians(90 - angle));
                    y_change = flipperWidth / 2 * Math.sin(Math.toRadians(angle));
                    break;
                case TOP_RIGHT:
                    x = xpos + 2 - flipperWidth / 2;
                    y = ypos + flipperWidth / 2;
                    x2 = x - (2 - flipperWidth) * Math.sin(Math.toRadians(90 - angle));
                    y2 = y + (2 - flipperWidth) * Math.sin(Math.toRadians(angle));
                    x_change = flipperWidth / 2 * Math.sin(Math.toRadians(angle));
                    y_change = flipperWidth / 2 * Math.sin(Math.toRadians(90 - angle));
                    break;
                case BOTTOM_RIGHT:
                    x = xpos + 2 - flipperWidth / 2;
                    y = ypos + 2 - flipperWidth / 2;
                    x2 = x - (2 - flipperWidth) * Math.sin(Math.toRadians(angle));
                    y2 = y - (2 - flipperWidth) * Math.sin(Math.toRadians(90 - angle));
                    x_change = flipperWidth / 2 * Math.sin(Math.toRadians(90 - angle));
                    y_change = flipperWidth / 2 * Math.sin(Math.toRadians(angle));
                    break;
                case BOTTOM_LEFT:
                    x = xpos + flipperWidth / 2;
                    y = ypos + 2 - flipperWidth / 2;
                    x2 = x + (2 - flipperWidth) * Math.sin(Math.toRadians(90 - angle));
                    y2 = y - (2 - flipperWidth) * Math.sin(Math.toRadians(angle));
                    x_change = flipperWidth / 2 * Math.sin(Math.toRadians(angle));
                    y_change = flipperWidth / 2 * Math.sin(Math.toRadians(90 - angle));
                    break;
            }
        } else {
            switch (rotation) {
                case TOP_RIGHT:
                    x = xpos + 2 - flipperWidth / 2;
                    y = ypos + flipperWidth / 2;
                    x2 = x - (2 - flipperWidth) * Math.sin(Math.toRadians(angle));
                    y2 = y + (2 - flipperWidth) * Math.sin(Math.toRadians(90 - angle));
                    x_change = flipperWidth / 2 * Math.sin(Math.toRadians(90 - angle));
                    y_change = flipperWidth / 2 * Math.sin(Math.toRadians(angle));
                    break;
                case BOTTOM_RIGHT:
                    x = xpos + 2 - flipperWidth / 2;
                    y = ypos + 2 - flipperWidth / 2;
                    x2 = x - (2 - flipperWidth) * Math.sin(Math.toRadians(90 - angle));
                    y2 = y - (2 - flipperWidth) * Math.sin(Math.toRadians(angle));
                    x_change = flipperWidth / 2 * Math.sin(Math.toRadians(angle));
                    y_change = flipperWidth / 2 * Math.sin(Math.toRadians(90 - angle));
                    break;
                case BOTTOM_LEFT:
                    x = xpos + flipperWidth / 2;
                    y = ypos + 2 - flipperWidth / 2;
                    x2 = x + (2 - flipperWidth) * Math.sin(Math.toRadians(angle));
                    y2 = y - (2 - flipperWidth) * Math.sin(Math.toRadians(90 - angle));
                    x_change = flipperWidth / 2 * Math.sin(Math.toRadians(90 - angle));
                    y_change = flipperWidth / 2 * Math.sin(Math.toRadians(angle));
                    break;
                case TOP_LEFT:
                    x = xpos + flipperWidth / 2;
                    y = ypos + flipperWidth / 2;
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

    @Override
    public void setPos(int x, int y) {
        this.xpos = x;
        this.ypos = y;
        setOccupiedSpace();
    }

    @Override
    public void trigger() {
        this.moveFlipperForTime(20,1);
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

    public void moveFlipperForTime(double delta_t, double modifier) {
        double newAngle = angle + angularVelocity * delta_t * modifier;

        if (newAngle > 90)
            newAngle = 90;
        else if (newAngle < 0)
            newAngle = 0;

        angle = newAngle;
    }

    public boolean isMoving(int leftFlipperFlippin, int rightFlipperFlippin) {
        if (left)
            return angle < 90 && leftFlipperFlippin > 0 || angle > 0 && leftFlipperFlippin < 0;
        else
            return angle < 90 && rightFlipperFlippin > 0 || angle > 0 && rightFlipperFlippin < 0;
    }

    public Rotation getState() {
        return rotation;
    }
}
