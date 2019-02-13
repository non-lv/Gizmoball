package Model;

import physics.Circle;
import physics.LineSegment;

import java.util.List;

public class FlipperGizmo implements IGizmo {

    private String id;
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

    @Override
    public String getId() {
        return id;
    }

    public int getXpos(){
        if(left == 1) {
            return xpos *25;
        }else{
            return ((xpos*25)+37);
        }

    }

    public int getYpos(){
        return ypos;
    }
}
