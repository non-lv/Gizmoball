package Model;

import physics.Circle;
import physics.LineSegment;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TriangleGizmo implements IGizmo {

    // the right angle corner in triangle
    public enum Rotation {
        TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT
    }

    private String id;
    private int x;
    private int y;
    private Color colour;
    private Rotation rotation;
    public List<List<Integer>> occupiedSpace;

    public TriangleGizmo(String id, int x, int y, Rotation r) {
        this.x = x;
        this.y = y;
        colour = Color.blue;

        if (r == null) {
            r = Rotation.TOP_LEFT;
        }

        rotation = r;

        this.id = id;

        setOccupiedSpace();
    }

    @Override
    public List<Circle> getCircles() {
        List<Circle> l = new ArrayList<>();
        if (rotation != Rotation.BOTTOM_RIGHT)
            l.add(new Circle(x, y, 0));

        if (rotation != Rotation.BOTTOM_LEFT)
            l.add(new Circle(x + 1, y, 0));

        if (rotation != Rotation.TOP_RIGHT)
            l.add(new Circle(x, y + 1, 0));

        if (rotation != Rotation.TOP_LEFT)
            l.add(new Circle(x + 1, y + 1, 0));

        return l;
    }

    @Override
    public List<LineSegment> getLines() {
        List<LineSegment> l = new ArrayList<>();
        if (rotation == Rotation.TOP_LEFT || rotation == Rotation.TOP_RIGHT)
            l.add(new LineSegment(x, y, x + 1, y));
        else
            l.add(new LineSegment(x, y + 1, x + 1, y + 1));

        if (rotation == Rotation.TOP_LEFT || rotation == Rotation.BOTTOM_LEFT)
            l.add(new LineSegment(x, y, x, y + 1));
        else
            l.add(new LineSegment(x + 1, y, x + 1, y + 1));

        if (rotation == Rotation.TOP_LEFT || rotation == Rotation.BOTTOM_RIGHT)
            l.add(new LineSegment(x + 1, y, x, y + 1));
        else
            l.add(new LineSegment(x, y, x + 1, y + 1));
        return l;
    }

    @Override
    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
        setOccupiedSpace();
    }

    @Override
    public void trigger(Ball ball) {
        colour = colour == Color.BLUE ? Color.CYAN : Color.BLUE;
    }

    @Override
    public void action() {
        colour = colour == Color.BLUE ? Color.CYAN : Color.BLUE;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public List<List<Integer>> getOccupiedSpace() {
        return occupiedSpace;
    }

    private void setOccupiedSpace() {
        occupiedSpace = new ArrayList<>();
        ArrayList<Integer> triangle = new ArrayList<>();
        triangle.add(x);
        triangle.add(y);
        occupiedSpace.add(triangle);
    }

    public int getXpos() {
        switch (rotation) {
            case TOP_LEFT:
            case BOTTOM_LEFT:
                return x;
            default:
                return x + 1;
        }
    }

    public int getYpos() {
        switch (rotation) {
            case TOP_LEFT:
            case TOP_RIGHT:
                return y;
            default:
                return y + 1;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Left dot
    public int getX2() {
        switch (rotation) {
            case TOP_LEFT:
            case TOP_RIGHT:
                return x;
            default:
                return x + 1;
        }
    }

    public int getY2() {
        switch (rotation) {
            case TOP_RIGHT:
            case BOTTOM_RIGHT:
                return y;
            default:
                return y + 1;
        }
    }

    // Right dot
    public int getX3() {
        switch (rotation) {
            case BOTTOM_LEFT:
            case BOTTOM_RIGHT:
                return x;
            default:
                return x + 1;
        }
    }

    public int getY3() {
        switch (rotation) {
            case TOP_LEFT:
            case BOTTOM_LEFT:
                return y;
            default:
                return y + 1;
        }
    }

    public Color getColour() {
        return colour;
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

