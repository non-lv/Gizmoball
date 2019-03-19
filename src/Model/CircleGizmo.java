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
    private List<List<Integer>> occupiedSpace;

    public CircleGizmo(String id, int x, int y) {
        this.x = x;
        this.y = y;
        colour = Color.ORANGE;
        this.id = id;
        setOccupiedSpace();
    }

    public List<Circle> getCircles() {
        List<Circle> l = new ArrayList<>();
        l.add(new Circle(x + .5, y + .5, .5));
        return l;
    }

    public void setOccupiedSpace() {
        occupiedSpace = new ArrayList<>();
        ArrayList<Integer> circle = new ArrayList<>();
        circle.add(x);
        circle.add(y);
        occupiedSpace.add(circle);
    }

    public List<LineSegment> getLines() {
        return new ArrayList<>();
    }

    @Override
    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
        setOccupiedSpace();
    }

    @Override
    public void trigger(Ball ball) {

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

    @Override
    public void rotate() {
    }

    public Color getColour() {
        return colour;
    }
}
