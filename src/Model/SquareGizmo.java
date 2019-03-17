package Model;

import physics.Circle;
import physics.LineSegment;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class SquareGizmo implements IGizmo {

    private String id;
    private int x;
    private int y;
    private Color colour;

    public SquareGizmo(String id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
        colour = Color.BLUE;
    }

    public List<Circle> getCircles() {
        List l = new ArrayList<>();
        l.add(new Circle(x, y, 0));
        l.add(new Circle(x + 1, y, 0));
        l.add(new Circle(x, y + 1, 0));
        l.add(new Circle(x + 1, y + 1, 0));
        return l;
    }

    public List<LineSegment> getLines() {
        List<LineSegment> l = new ArrayList<>();
        l.add(new LineSegment(x, y, x + 1, y));
        l.add(new LineSegment(x, y, x, y + 1));
        l.add(new LineSegment(x + 1, y, x + 1, y + 1));
        l.add(new LineSegment(x, y + 1, x + 1, y + 1));
        return l;
    }

    @Override
    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
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
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void rotate() {

    }
}
