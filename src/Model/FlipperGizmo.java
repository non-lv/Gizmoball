package Model;

import physics.Circle;
import physics.LineSegment;

import java.awt.*;
import java.util.List;

public class FlipperGizmo implements Gizmo {
    private int xpos;
    private int ypos;
    int left;

    public FlipperGizmo(int x, int y, int l) {
        xpos = x;
        ypos = y;
        left = l;

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
        if(left == 1) {
            return xpos;
        }else{
            return xpos = xpos + 2;
        }

    }

    public int getYpos(){
        return ypos;
    }
}
