package Model;

import physics.Circle;

import java.util.List;

public interface Gizmo {
    public List<Circle> getCircles();
    public void setPos();
    public void trigger();
}
