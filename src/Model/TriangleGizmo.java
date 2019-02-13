package Model;

import physics.Circle;
import physics.LineSegment;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TriangleGizmo implements Gizmo {

    // the right angle corner in triangle
    private enum Rotation {
        UP_LEFT, UP_RIGHT, DOWN_LEFT, DOWN_RIGHT
    }

    private int xpos;
    private int ypos;
    private Rotation rotation;
    private Color colour;

    public TriangleGizmo(int x, int y) {
        this.xpos = x;
        this.ypos = y;
        rotation = Rotation.UP_LEFT;
        colour = Color.blue;
    }

    @Override
    public List<Circle> getCircles() {
        List l = new ArrayList<>();
        if (rotation != Rotation.DOWN_RIGHT)
            l.add(new Circle(xpos, ypos, 0));

        if (rotation != Rotation.DOWN_LEFT)
            l.add(new Circle(xpos + 1, ypos, 0));

        if (rotation != Rotation.UP_RIGHT)
            l.add(new Circle(xpos, ypos + 1, 0));

        if (rotation != Rotation.UP_LEFT)
            l.add(new Circle(xpos + 1, ypos + 1, 0));

        return l;
    }

    @Override
    public List<LineSegment> getLines() {
        List l = new ArrayList();
        if (rotation == Rotation.UP_LEFT || rotation == Rotation.UP_RIGHT)
            l.add(new LineSegment(xpos, ypos, xpos + 1, ypos));
        else
            l.add(new LineSegment(xpos, ypos + 1, xpos + 1, ypos + 1));

        if (rotation == Rotation.UP_LEFT || rotation == Rotation.DOWN_LEFT)
            l.add(new LineSegment(xpos, ypos, xpos, ypos + 1));
        else
            l.add(new LineSegment(xpos + 1, ypos, xpos + 1, ypos + 1));

        if(rotation == Rotation.UP_LEFT || rotation == Rotation.DOWN_RIGHT)
            l.add(new LineSegment(xpos + 1, ypos, xpos, ypos + 1));
        else
            l.add(new LineSegment(xpos, ypos, xpos + 1, ypos + 1));
        return l;
    }

    @Override
    public void setPos() {

    }

    @Override
    public void trigger() {

    }

    public void rotate() {
        if (rotation == Rotation.UP_LEFT)
            rotation = Rotation.UP_RIGHT;
        else if (rotation == Rotation.UP_RIGHT)
            rotation = Rotation.DOWN_RIGHT;
        else if (rotation == Rotation.DOWN_RIGHT)
            rotation = Rotation.DOWN_LEFT;
        else
            rotation = Rotation.UP_LEFT;
    }

    public int getXpos() {
        return xpos;
    }

    public int getYpos() {
        return ypos;
    }

    public Color getColour() {
        return colour;
    }


}

