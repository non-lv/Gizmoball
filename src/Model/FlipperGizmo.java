package Model;

import physics.Circle;
import physics.LineSegment;

import java.util.ArrayList;
import java.util.List;

public class FlipperGizmo implements IGizmo {

    private String id;
    private int xpos;
    private int ypos;
    boolean left;
    double angle;

    public FlipperGizmo(String id, int x, int y, boolean isLeft) {
        this.id = id;
        xpos = x;
        ypos = y;
        left = isLeft;

    }

    @Override
    public List<Circle> getCircles() {
        return new ArrayList<>();
    }

    @Override
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
        if(left) {
            return xpos *25;
        }else{
            return ((xpos*25)+37);
        }

    }

    public int getYpos(){
        return ypos;
    }
}
