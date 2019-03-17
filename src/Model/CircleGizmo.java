package Model;

import physics.Circle;
import physics.LineSegment;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class CircleGizmo implements IGizmo {

    private String id;
    private int xpos;
    private int ypos;
    private Color colour;

    public CircleGizmo(String id, int x, int y) {
        xpos = x;
        ypos = y;
        colour = Color.BLACK;
        this.id = id;
    }

    public List<Circle> getCircles() {
        List<Circle> l = new ArrayList<>();
        l.add(new Circle(xpos + .5, ypos + .5, .5));
        return l;
    }

    public List<LineSegment> getLines() {
        return new ArrayList<>();
    }

    @Override
    public void setPos(int x, int y) {
        this.xpos = x;
        this.ypos = y;
    }

    @Override
    public void hit(Ball ball) {
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

    @Override
    public void rotate() {

    }

    public Color getColour() {
        return colour;
    }
}
