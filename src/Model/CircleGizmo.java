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
    private List<List<Integer>> occupiedSpace;

    public CircleGizmo(String id, int x, int y) {
        xpos = x;
        ypos = y;
        colour = Color.BLACK;
        this.id = id;
        setOccupiedSpace();
    }

    public List<Circle> getCircles() {
        List<Circle> l = new ArrayList<>();
        l.add(new Circle(xpos + .5, ypos + .5, .5));
        return l;
    }

    public void setOccupiedSpace(){
        occupiedSpace = new ArrayList<>();
        ArrayList<Integer> circle = new ArrayList<>();
        circle.add(xpos);
        circle.add(ypos);
        occupiedSpace.add(circle);
    }

    public List<LineSegment> getLines() {
        return new ArrayList<>();
    }

    @Override
    public void setPos(int x, int y) {
        this.xpos = x;
        this.ypos = y;
        setOccupiedSpace();
    }

    @Override
    public void trigger() {

    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public List<List<Integer>> getOccupiedSpace() {
        return occupiedSpace;
    }

    public int getX(){
        return xpos;
    }

    public int getY(){
        return ypos;
    }

    @Override
    public void rotate() {

    }

    public Color getColour() {
        return colour;
    }
}
