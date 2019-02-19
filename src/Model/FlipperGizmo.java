package Model;

import physics.Circle;
import physics.LineSegment;

import java.util.ArrayList;
import java.util.List;

public class FlipperGizmo implements IGizmo {

    public enum Rotation {
        TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT
    }

    private static final double angularVelocity = 90;

    private String id;
    private int xpos;
    private int ypos;
    private boolean left;
    private double angle;
    private Rotation rotation;

    public FlipperGizmo(String id, int x, int y, boolean isLeft) {
        this.id = id;
        xpos = x;
        ypos = y;
        left = isLeft;
        if(left)
            rotation = Rotation.TOP_LEFT;
        else
            rotation = Rotation.TOP_RIGHT;
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

    public void rotate() {
        switch (rotation) {
            case TOP_LEFT:
                rotation = Rotation.TOP_RIGHT;
                break;
            case TOP_RIGHT:
                rotation = Rotation.BOTTOM_RIGHT;
                break;
            case BOTTOM_RIGHT:
                rotation = Rotation.BOTTOM_LEFT;
                break;
            default:
                rotation = Rotation.TOP_LEFT;
        }
    }


    public Rotation getState() {
        return rotation;
    }
}
