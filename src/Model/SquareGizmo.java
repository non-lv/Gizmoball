package Model;

import physics.Circle;
import physics.LineSegment;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class SquareGizmo implements IGizmo {

    private String id;
    private int xpos;
    private int ypos;
    private Color colour;

    public SquareGizmo(String id, int x, int y) {
        this.id = id;
        xpos = x;
        ypos = y;
        colour = Color.BLUE;
    }

    public List<Circle> getCircles() {
        List l = new ArrayList<>();
        l.add(new Circle(xpos, ypos, 0));
        l.add(new Circle(xpos + 1, ypos, 0));
        l.add(new Circle(xpos, ypos + 1, 0));
        l.add(new Circle(xpos + 1, ypos + 1, 0));
        return l;
    }

    public List<LineSegment> getLines() {
        List<LineSegment> l = new ArrayList<>();
        l.add(new LineSegment(xpos, ypos, xpos + 1, ypos + 1));
        l.add(new LineSegment(xpos, ypos, xpos, ypos + 1));
        l.add(new LineSegment(xpos, ypos + 1, xpos + 1, ypos + 1));
        l.add(new LineSegment(xpos + 1, ypos, xpos + 1, ypos + 1));
        return l;
    }

    @Override
    public void setPos() {

    }

    @Override
    public void trigger() {

    }

    @Override
    public String getId() {
        return id;
    }

    public int getXpos(){
        return xpos;
    }

    public int getYpos(){
        return ypos;
    }
}
