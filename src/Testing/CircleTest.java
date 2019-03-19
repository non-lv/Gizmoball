package Testing;
import org.junit.Test;
import static org.junit.Assert.*;
import Model.CircleGizmo;
import physics.Circle;
import physics.LineSegment;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CircleTest {
    CircleGizmo c = new CircleGizmo("Circle 1",10,10);
    CircleGizmo c1 = new CircleGizmo("Circle 2",0,0);


    @Test
    public void testID() {
        assertTrue(c.getId().equals("Circle 1"));
        assertFalse(c.getId().equals(c1.getId()));
    }
    @Test
    public void testXpos() {
        assertEquals(c.getX(),10);
        assertNotEquals(c.getX(),1);
    }

    @Test
    public void testYpos() {
        assertEquals(c.getY(),10);
        assertNotEquals(c.getY(),1);
    }

    @Test
    public void testCircles(){
        List<Circle> l = new ArrayList<>();
        l.add(new Circle(c.getX() + .5, c.getY() + .5, .5));
        assertEquals(c.getCircles(),l);
        assertNotEquals(c1.getCircles(),l);

    }



    @Test
    public void equalTest(){
        assertEquals(c,c);
        assertTrue(c.equals(c));
        assertFalse(c.equals(c1));

    }

    @Test
    public void channgingPos(){
        c.setPos(5,3);

        assertEquals(c.getX(),5);
        assertEquals(c.getY(),3);
        assertNotEquals(c.getX(), 10);
        assertNotEquals(c.getY(), 10);
    }

}
