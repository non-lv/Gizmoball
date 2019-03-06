package Testing;
import org.junit.Test;
import static org.junit.Assert.*;
import Model.AbsorberGizmo;
import physics.Circle;
import physics.LineSegment;
import Model.Ball;

import java.awt.*;
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
        assertEquals(a.getXpos(),1);
        assertNotEquals(a.getXpos(),0);
    }

    @Test
    public void testYpos() {
        assertEquals(a.getYpos(),1);
        assertNotEquals(a.getYpos(),11);
    }

    @Test
    public void testX2pos() {
        assertEquals(a.getXpos2(),10);
        assertNotEquals(a.getXpos2(),1);
    }

    @Test
    public void testY2pos() {
        assertEquals(a.getYpos2(),10);
        assertNotEquals(a.getYpos2(),1);
    }

    @Test
    public void testCircleList(){
        List l = new ArrayList<>();
        l.add(new Circle(a.getXpos(), a.getYpos(), 0));
        l.add(new Circle(a.getXpos() + (a.getXpos2() - a.getXpos() + 1), a.getYpos(), 0));
        l.add(new Circle(a.getXpos(), a.getYpos() + (a.getYpos2() - a.getYpos() + 1), 0));
        l.add(new Circle(a.getXpos() + (a.getXpos2() - a.getXpos() + 1), a.getYpos() + (a.getYpos2() - a.getYpos() + 1), 0));

        assertEquals(a.getCircles(), l);

        assertNotEquals(a1.getCircles(),l);
    }

    @Test
    public void testAbsorberList(){
        List<LineSegment> l = new ArrayList<>();
        l.add(new LineSegment(a.getXpos(),
                a.getYpos(),
                a.getXpos2() + 1,
                a.getYpos()
        ));
        l.add(new LineSegment(a.getXpos(),
                a.getYpos(),
                a.getXpos(),
                a.getYpos2() + 1
        ));
        l.add(new LineSegment(a.getXpos2() + 1,
                a.getYpos(),
                a.getXpos2() + 1,
                a.getYpos2() + 1
        ));
        l.add(new LineSegment(a.getXpos(),
                a.getXpos2() + 1,
                a.getXpos2() + 1,
                a.getYpos2() + 1
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
        a.trigger(ball);
        double x = a.getXpos() - 0.5;
        double xb = ball.getX();
        assertEquals(x,22d/7d, xb);
        assertNotEquals(xb,15.0);
        double y = a.getYpos() - 0.5;
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
