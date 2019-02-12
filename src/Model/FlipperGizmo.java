package Model;

import physics.Circle;
import physics.LineSegment;

import java.awt.*;
import java.util.List;

public class FlipperGizmo implements Gizmo {
    private int xpos;
    private int ypos;


    public FlipperGizmo(int x, int y) {
        xpos = x;
        ypos = y;

    }

    @Override
    public List<Circle> getCircles() {
        return null;
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
}
