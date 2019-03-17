package Model;

import physics.Circle;
import physics.LineSegment;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class CircleGizmo implements IGizmo {

    private String id;
    private int x;
    private int y;
    private Color colour;

    public CircleGizmo(String id, int x, int y) {
        this.x = x;
        this.y = y;
        colour = Color.BLACK;
        this.id = id;
    }

    public List<Circle> getCircles() {
        List<Circle> l = new ArrayList<>();
        l.add(new Circle(x + .5, y + .5, .5));
        return l;
    }

    public List<LineSegment> getLines() {
        return new ArrayList<>();
    }

    @Override
    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void trigger(Ball ball) {

    }

    @Override
    public String getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void rotate() {

    }

    public Color getColour() {
        return colour;
    }
}
