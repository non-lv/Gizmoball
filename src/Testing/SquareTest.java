package Testing;

import org.junit.Test;
import static org.junit.Assert.*;
/*import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;*/

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
        assertEquals(s.getX(),10);
        assertNotEquals(s.getX(),1);
    }

    @Test
    public void testYpos() {
        assertEquals(s.getY(),10);
        assertNotEquals(s.getY(),1);
    }

    @Test
    public void testCircleList(){
        List l = new ArrayList<>();
        l.add(new Circle(s.getX(), s.getY(), 0));
        l.add(new Circle(s.getX() + 1, s.getY(), 0));
        l.add(new Circle(s.getX(), s.getY() + 1, 0));
        l.add(new Circle(s.getX() + 1, s.getY() + 1, 0));

        assertEquals(s.getCircles(), l);

        assertNotEquals(s1.getCircles(),l);
    }

    @Test
    public void testLinesList(){
        List<LineSegment> l = new ArrayList<>();
        l.add(new LineSegment(s.getX(), s.getY(), s.getX() + 1, s.getY()));
        l.add(new LineSegment(s.getX(), s.getY(), s.getX(), s.getY() + 1));
        l.add(new LineSegment(s.getX() + 1, s.getY(), s.getX() + 1, s.getY() + 1));
        l.add(new LineSegment(s.getX(), s.getY() + 1, s.getX() + 1, s.getY() + 1));
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
