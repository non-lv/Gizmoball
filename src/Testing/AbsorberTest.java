package Testing;
import org.junit.Test;
import static org.junit.Assert.*;
import Model.AbsorberGizmo;
import physics.Circle;
import physics.LineSegment;
import Model.Ball;

import java.util.ArrayList;
import java.util.List;
public class AbsorberTest {
    AbsorberGizmo a = new AbsorberGizmo("Absorber 1",1,1,10,10);
    AbsorberGizmo a1 = new AbsorberGizmo("Absorber 2",5,5,10,10);
    Ball ball = new Ball("Ball", 3.0,3.0,3.0,3.0);
    Ball ball1 = new Ball("Ball1", 19.0,3.0,3.0,3.0);
    @Test
    public void testID() {
        assertTrue(a.getId().equals("Absorber 1"));
        assertFalse(a.getId().equals(a1.getId()));
    }

    @Test
    public void testXpos() {
        assertEquals(a.getX(),1);
        assertNotEquals(a.getX(),0);
    }

    @Test
    public void testYpos() {
        assertEquals(a.getY(),1);
        assertNotEquals(a.getY(),11);
    }

    @Test
    public void testX2pos() {
        assertEquals(a.getX2(),10);
        assertNotEquals(a.getX2(),1);
    }

    @Test
    public void testY2pos() {
        assertEquals(a.getY2(),10);
        assertNotEquals(a.getY2(),1);
    }

    @Test
    public void testCircleList(){
        List l = new ArrayList<>();
        l.add(new Circle(a.getX(), a.getY(), 0));
        l.add(new Circle(a.getX() + (a.getX2() - a.getX() + 1), a.getY(), 0));
        l.add(new Circle(a.getX(), a.getY() + (a.getY2() - a.getY() + 1), 0));
        l.add(new Circle(a.getX() + (a.getX2() - a.getX() + 1), a.getY() + (a.getY2() - a.getY() + 1), 0));

        assertEquals(a.getCircles(), l);

        assertNotEquals(a1.getCircles(),l);
    }

    @Test
    public void testAbsorberList(){
        List<LineSegment> l = new ArrayList<>();
        l.add(new LineSegment(a.getX(),
                a.getY(),
                a.getX2() + 1,
                a.getY()
        ));
        l.add(new LineSegment(a.getX(),
                a.getY(),
                a.getX(),
                a.getY2() + 1
        ));
        l.add(new LineSegment(a.getX2() + 1,
                a.getY(),
                a.getX2() + 1,
                a.getY2() + 1
        ));
        l.add(new LineSegment(a.getX(),
                a.getX2() + 1,
                a.getX2() + 1,
                a.getY2() + 1
        ));
        assertEquals(a.getLines(), l);

        assertNotEquals(a1.getLines(),l);

    }
    @Test
    public void testIsInside(){
        assertTrue(a.isInside(ball));
        assertFalse(a.isInside(ball1));
    }

    @Test
    public void testTrigger(){
        a.trigger();
        double x = a.getX() - 0.5;
        double xb = ball.getX();
        assertEquals(x,22d/7d, xb);
        assertNotEquals(xb,15.0);
        double y = a.getY() - 0.5;
        double yb = ball.getY();
        assertEquals(y,22d/7d, yb);
        assertNotEquals(yb,15.0);
    }

    @Test
    public void equalTest(){
        assertEquals(a,a);
        assertTrue(a.equals(a));
        assertFalse(a.equals(a1));

    }

}
