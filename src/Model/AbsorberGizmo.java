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

    public AbsorberGizmo(int x, int y, int x2, int y2) {
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
        l.add(new LineSegment(      xpos,
                                    ypos,
                                xpos + (x2pos - xpos + 1),
                                ypos + 1
        ));
        l.add(new LineSegment(      xpos,
                                    ypos,
                                    xpos,
                                ypos + (y2pos - ypos + 1)
        ));
        l.add(new LineSegment(      xpos,
                                ypos + (y2pos - ypos + 1),
                                xpos + (x2pos - xpos + 1),
                                ypos + (y2pos - ypos + 1)
        ));
        l.add(new LineSegment(  xpos + (x2pos - xpos + 1),
                                    ypos,
                                xpos + (x2pos - xpos + 1),
                                ypos + (y2pos - ypos + 1)
        ));
        return l;
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

    public int getXpos2(){
        return x2pos;
    }

    public int getYpos2(){
        return y2pos;
    }

}
