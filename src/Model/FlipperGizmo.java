package Model;

import physics.Circle;
import physics.LineSegment;

import java.util.ArrayList;
import java.util.List;

public class FlipperGizmo implements IGizmo {

    private String id;
    private int xpos;
    private int ypos;
    private boolean left;
    private double angle;
    private double angularVelocity;

    public FlipperGizmo(String id, int x, int y, boolean isLeft) {
        this.id = id;
        xpos = x;
        ypos = y;
        left = isLeft;
        angularVelocity = 90;
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

    public int getX(){
        return xpos;
    }

    public int getY(){
        return ypos;
    }

    public double getAngle() {
        return angle;
    }

    public double getAngularVelocity(){
        return angularVelocity;
    }

    public void setAngle(double newAngle){
        angle = newAngle;
    }

    public boolean isLeft() {
        return left;
    }
}
