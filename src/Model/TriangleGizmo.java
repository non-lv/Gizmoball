package Model;

import physics.Circle;
import physics.LineSegment;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TriangleGizmo implements Gizmo {

    private int xpos;
    private int ypos;
    private Color colour;
    public TriangleGizmo(int x, int y){
        this.xpos = x;
        this.ypos = y;
        colour = Color.blue;
    }

    @Override
    public List<Circle> getCircles() {
        List l = new ArrayList<>();
        l.add(new Circle(xpos, ypos, 0));
        l.add(new Circle(xpos + 1, ypos, 0));
        l.add(new Circle(xpos, ypos + 1, 0));
        return l;
    }

    @Override
    public List<LineSegment> getLines() {
        return null;
    }

    @Override
    public void setPos() {

    }

    @Override
    public void trigger() {

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

