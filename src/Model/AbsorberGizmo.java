package Model;

import physics.Circle;
import physics.LineSegment;

import java.util.List;
import java.util.ArrayList;

public class AbsorberGizmo implements IGizmo {

    private String id;
    private int xpos;
    private int ypos;
    private int x2pos;
    private int y2pos;
    private List<List<Integer>> occupiedSpace = new ArrayList<>();
    private Ball ball;

    public AbsorberGizmo(String id, int x, int y, int x2, int y2) {
        this.id = id;
        xpos = x;
        ypos = y;
        x2pos = x2;
        y2pos = y2;
        setOccupiedSpace(xpos, ypos, x2pos, y2pos);
    }

    public List<Circle> getCircles() {
        List l = new ArrayList<>();
        l.add(new Circle(xpos, ypos, 0));
        l.add(new Circle(xpos + (x2pos - xpos + 1), ypos, 0));
        l.add(new Circle(xpos, ypos + (y2pos - ypos + 1), 0));
        l.add(new Circle(xpos + (x2pos - xpos + 1), ypos + (y2pos - ypos + 1), 0));
        return l;
    }

    public List<LineSegment> getLines() {
        List<LineSegment> l = new ArrayList<>();
        l.add(new LineSegment(xpos,
                ypos,
                x2pos + 1,
                ypos
        ));
        l.add(new LineSegment(xpos,
                ypos,
                xpos,
                y2pos + 1
        ));
        l.add(new LineSegment(x2pos + 1,
                ypos,
                x2pos + 1,
                y2pos + 1
        ));
        l.add(new LineSegment(xpos,
                y2pos + 1,
                x2pos + 1,
                y2pos + 1
        ));
        return l;
    }

    @Override
    public void setPos(int x, int y) {
        this.xpos = x;
        this.ypos = y;
        setOccupiedSpace(xpos, ypos, x2pos, y2pos);
    }

    public void setPos2(int x, int y){
        this.x2pos = x;
        this.y2pos = y;
        setOccupiedSpace(xpos, ypos, x2pos, y2pos);
    }

    @Override
    public void trigger() {
        fire();
    }

    public void trigger(Ball ball) {
        this.ball = ball;

        ball.setX(x2pos - .5);
        ball.setY(y2pos - .5);

        ball.stop();
    }

    public void fire() {
        if (ball != null) {
            ball.setVelocity(0, -50);
            ball.move();
            ball = null;
        }
    }

    @Override
    public String getId() {
        return id;
    }

    public int getX() {
        return xpos;
    }

    public int getY() {
        return ypos;
    }

    @Override
    public void rotate() {

    }

    public int getXpos2() {
        return x2pos;
    }


    public int getYpos2() {
        return y2pos;
    }

    public boolean isInside(Ball ball) {
        return (ball.getX() >= xpos && ball.getY() >= ypos && ball.getX() <= x2pos && ball.getY() <= y2pos);
    }

    public List<List<Integer>> getOccupiedSpace(){
        return occupiedSpace;
    }

    public void setOccupiedSpace(int x, int y, int x2, int y2){
        occupiedSpace = new ArrayList<>();
        for (int i = x; i < x2; i++){
            for (int j = y; j < y2; j++){
                List<Integer> contain = new ArrayList<>();
                contain.add(i);
                contain.add(j);
                occupiedSpace.add(contain);
            }
        }
    }

}
