package Model;

import physics.Circle;

import java.util.List;
import java.util.ArrayList;

public class CircleGizmo implements Gizmo {

    private int xpos;
    private int ypos;

    public CircleGizmo(int x, int y) {
        xpos = x;
        ypos = y;
    }

    public List<Circle> getCircles() {
        List<Circle> l = new ArrayList<>();
        l.add(new Circle(xpos + .5, ypos + .5, .5));
        return l;
    }

    @Override
    public void setPos() {

    }

    @Override
    public void trigger() {

    }
}
