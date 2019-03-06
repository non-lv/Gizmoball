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
    private int xpos;
    private int ypos;
    private Color colour;
    private Rotation rotation;
    private String name;

    public TriangleGizmo(String id, int x, int y, Rotation r) {
        this.xpos = x;
        this.ypos = y;
        colour = Color.blue;

        if (r == null){
            r = Rotation.TOP_LEFT;
        }

        rotation = r;

        this.id = id;
    }

    @Override
    public List<Circle> getCircles() {
        List<Circle> l = new ArrayList<>();
        if (rotation != Rotation.BOTTOM_RIGHT)
            l.add(new Circle(xpos, ypos, 0));

        if (rotation != Rotation.BOTTOM_LEFT)
            l.add(new Circle(xpos + 1, ypos, 0));

        if (rotation != Rotation.TOP_RIGHT)
            l.add(new Circle(xpos, ypos + 1, 0));

        if (rotation != Rotation.TOP_LEFT)
            l.add(new Circle(xpos + 1, ypos + 1, 0));

        return l;
    }

    @Override
    public List<LineSegment> getLines() {
        List<LineSegment> l = new ArrayList<>();
        if (rotation == Rotation.TOP_LEFT || rotation == Rotation.TOP_RIGHT)
            l.add(new LineSegment(xpos, ypos, xpos + 1, ypos));
        else
            l.add(new LineSegment(xpos, ypos + 1, xpos + 1, ypos + 1));

        if (rotation == Rotation.TOP_LEFT || rotation == Rotation.BOTTOM_LEFT)
            l.add(new LineSegment(xpos, ypos, xpos, ypos + 1));
        else
            l.add(new LineSegment(xpos + 1, ypos, xpos + 1, ypos + 1));

        if (rotation == Rotation.TOP_LEFT || rotation == Rotation.BOTTOM_RIGHT)
            l.add(new LineSegment(xpos + 1, ypos, xpos, ypos + 1));
        else
            l.add(new LineSegment(xpos, ypos, xpos + 1, ypos + 1));
        return l;
    }

    @Override
    public void setPos(int x, int y) {
        this.xpos = x;
        this.ypos = y;
    }

    @Override
    public void trigger() {

    }

    @Override
    public String getId() {
        return id;
    }

    public int getXpos() {
        switch (rotation) {
            case TOP_LEFT:
            case BOTTOM_LEFT:
                return xpos;
            default:
                return xpos + 1;
        }
    }

    public int getX(){
        return xpos;
    }

    public int getY(){
        return ypos;
    }

    public int getYpos() {
        switch (rotation) {
            case TOP_LEFT:
            case TOP_RIGHT:
                return ypos;
            default:
                return ypos + 1;
        }
    }

    // Left dot
    public int getX2() {
        switch (rotation) {
            case TOP_LEFT:
            case TOP_RIGHT:
                return xpos;
            default:
                return xpos + 1;
        }
    }

    public int gety2() {
        switch (rotation) {
            case TOP_RIGHT:
            case BOTTOM_RIGHT:
                return ypos;
            default:
                return ypos + 1;
        }
    }


    // Right dot
    public int getX3() {
        switch (rotation) {
            case BOTTOM_LEFT:
            case BOTTOM_RIGHT:
                return xpos;
            default:
                return xpos + 1;
        }
    }

    public int gety3() {
        switch (rotation) {
            case TOP_LEFT:
            case BOTTOM_LEFT:
                return ypos;
            default:
                return ypos + 1;
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

