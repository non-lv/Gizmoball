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

    public CircleGizmo(int x, int y) {
        xpos = x;
        ypos = y;
        colour = Color.BLACK;
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

    public Color getColour() {
        return colour;
    }
}
