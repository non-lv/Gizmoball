package Model;

import physics.Circle;
import physics.LineSegment;

import java.util.List;

public interface Gizmo {
    public List<Circle> getCircles();
    public List<LineSegment> getLines();
    public void setPos();
    public void trigger();
}
