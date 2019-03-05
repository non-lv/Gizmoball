package Testing;

import org.junit.Test;
import static org.junit.Assert.*;
import Model.SquareGizmo;
import physics.Circle;
import physics.LineSegment;

import java.util.ArrayList;
import java.util.List;

public class SquareTest {
    SquareGizmo s = new SquareGizmo("Square 1",10,10);
    SquareGizmo s1 = new SquareGizmo("Square 2",0,0);


    @Test
    public void testID() {
        assertTrue(s.getId().equals("Square 1"));
        assertFalse(s.getId().equals("false"));
    }
    @Test
    public void testXpos() {
        assertEquals(s.getXpos(),10);
        assertNotEquals(s.getXpos(),1);
    }

    @Test
    public void testYpos() {
        assertEquals(s.getYpos(),10);
        assertNotEquals(s.getYpos(),1);
    }

    @Test
    public void testCircleList(){
        List l = new ArrayList<>();
        l.add(new Circle(s.getXpos(), s.getYpos(), 0));
        l.add(new Circle(s.getXpos() + 1, s.getYpos(), 0));
        l.add(new Circle(s.getXpos(), s.getYpos() + 1, 0));
        l.add(new Circle(s.getXpos() + 1, s.getYpos() + 1, 0));

        assertEquals(s.getCircles(), l);

        assertNotEquals(s1.getCircles(),l);
    }

    @Test
    public void testLinesList(){
        List<LineSegment> l = new ArrayList<>();
        l.add(new LineSegment(s.getXpos(), s.getYpos(), s.getXpos() + 1, s.getYpos()));
        l.add(new LineSegment(s.getXpos(), s.getYpos(), s.getXpos(), s.getYpos() + 1));
        l.add(new LineSegment(s.getXpos() + 1, s.getYpos(), s.getXpos() + 1, s.getYpos() + 1));
        l.add(new LineSegment(s.getXpos(), s.getYpos() + 1, s.getXpos() + 1, s.getYpos() + 1));
        assertEquals(s.getLines(), l);

        assertNotEquals(s1.getLines(),l);
    }

    @Test
    public void equalTest(){
        assertEquals(s,s);
        assertTrue(s.equals(s));
        assertFalse(s.equals(s1));
    }

}
