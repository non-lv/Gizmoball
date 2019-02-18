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
    private Ball ball;

    public AbsorberGizmo(String id, int x, int y, int x2, int y2) {
        this.id = id;
        xpos = x;
        ypos = y;
        x2pos = x2;
        y2pos = y2;
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
    public void setPos() {

    }

    @Override
    public void trigger() {

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

    public int getXpos() {
        return xpos;
    }

    public int getYpos() {
        return ypos;
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
}
