package Model;

import physics.Circle;
import physics.LineSegment;

import java.util.List;

public interface IGizmo {
    List<Circle> getCircles();
    List<LineSegment> getLines();
    void setPos(int x, int y);
    void hit(Ball ball);
    void trigger();
    String getId();
    int getX();
    int getY();
    void rotate();
}
