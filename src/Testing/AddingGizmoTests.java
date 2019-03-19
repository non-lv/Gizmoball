package Testing;

import org.junit.Test;
import static org.junit.Assert.*;

import physics.Circle;
import physics.LineSegment;
import Model.Model;
import Model.CircleGizmo;
import Model.SquareGizmo;
import Model.TriangleGizmo;
import Model.FlipperGizmo;
import Model.AbsorberGizmo;
import Model.InvalidLocationException;
import Model.Ball;

import java.util.ArrayList;
import java.util.List;
public class AddingGizmoTests {
    Model m = new Model();

    @Test
    public void addingCircleTest() throws InvalidLocationException {
        CircleGizmo c = new CircleGizmo("Circle 1",10,10);
        m.addGizmo(c);
        assertTrue(m.getGizmos().contains(c));

    }

    @Test
    public void addingSquareTest() throws InvalidLocationException {
        SquareGizmo s = new SquareGizmo("Square 1",10,10);
        m.addGizmo(s);
        assertTrue(m.getGizmos().contains(s));
    }

    @Test
    public void addingTriangleTest() throws InvalidLocationException {
        TriangleGizmo t = new TriangleGizmo("Triangle 1",10,10, TriangleGizmo.Rotation.TOP_LEFT);
        m.addGizmo(t);
        assertTrue(m.getGizmos().contains(t));
    }

    @Test
    public void addingFlipperTest() throws InvalidLocationException {
        FlipperGizmo leftf = new FlipperGizmo("left", 1, 1, true);
        FlipperGizmo rightf = new FlipperGizmo("right", 10, 1, false);
        m.addGizmo(leftf);
        m.addGizmo(rightf);
        assertTrue(m.getGizmos().contains(leftf));
        assertTrue(m.getGizmos().contains(rightf));
    }

    @Test
    public void addingAbsorberTest() throws InvalidLocationException {
        AbsorberGizmo a = new AbsorberGizmo("Absorber 1",1,1,10,10);
        m.addGizmo(a);

        assertTrue(m.getGizmos().contains(a));
    }

    @Test
    public void addingBallTest() throws InvalidLocationException {
        Ball ball = new Ball("Ball", 3.0,3.0,3.0,3.0);
        m.addBall(ball);

        assertTrue(m.getBalls().contains(ball));
    }

}
