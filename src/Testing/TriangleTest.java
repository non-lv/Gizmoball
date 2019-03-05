package Testing;
import Model.TriangleGizmo;
import org.junit.Test;
import static org.junit.Assert.*;
import Model.TriangleGizmo;
import physics.Circle;
import physics.LineSegment;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
public class TriangleTest {
    TriangleGizmo t = new TriangleGizmo("Triangle 1",10,10, TriangleGizmo.Rotation.TOP_LEFT);
    @Test
    public void testID() {
        assertTrue(t.getId().equals("Triangle 1"));
        assertFalse(t.getId().equals("false"));
    }
    @Test
    public void testXpos() {
        assertEquals(t.getXpos(),10);
        t.rotate();
        assertEquals(t.getXpos(),11);
        assertNotEquals(t.getXpos(),10);
    }
    @Test
    public void testX2(){
        assertEquals(t.getX2(),t.getXpos());
        t.rotate();
        assertEquals(t.getX2(),t.getXpos()-1);

    }
    @Test
    public void testX3(){
        assertEquals(t.getX3(),t.getXpos()+1);
        t.rotate();
        assertEquals(t.getX3(),t.getXpos());

    }

    @Test
    public void testYpos() {
        assertEquals(t.getYpos(),10);
        t.rotate();
        t.rotate();
        assertEquals(t.getXpos(), 11);
        assertNotEquals(t.getYpos(),10);
    }

    @Test
    public void testY2(){
        assertEquals(t.gety2(),t.getYpos()+1);
        t.rotate();
        assertEquals(t.gety2(),t.getYpos());

    }

    @Test
    public void testY3(){
        assertEquals(t.gety3(),t.getYpos());
        t.rotate();
        assertEquals(t.gety3(),t.getYpos()+1);

    }

    @Test
    public void testColour(){
        assertEquals(t.getColour(), Color.BLUE);
    }
    @Test
    public void testCircles(){
        //Tests a rotation as well
        List<Circle> l = new ArrayList<>();
        l.add(new Circle(t.getXpos(), t.getYpos(), 0));
        l.add(new Circle(t.getXpos() + 1, t.getYpos(), 0));
        l.add(new Circle(t.getXpos(), t.getYpos() + 1, 0));


        assertEquals(t.getCircles(),l);

        List<Circle> l1 = new ArrayList<>();
        t.rotate();
        l1.add(new Circle(t.getXpos()-1, t.getYpos(), 0));
        l1.add(new Circle(t.getXpos() , t.getYpos(), 0));
        l1.add(new Circle(t.getXpos() , t.getYpos() + 1, 0));
        assertEquals(t.getCircles(),l1);

    }
    @Test
    public void testLines(){
        List<LineSegment> l = new ArrayList<>();
        l.add(new LineSegment(t.getXpos(), t.getYpos(), t.getXpos() + 1, t.getYpos()));
        l.add(new LineSegment(t.getXpos(), t.getYpos(), t.getXpos(), t.getYpos() + 1));
        l.add(new LineSegment(t.getXpos() + 1, t.getYpos(), t.getXpos(), t.getYpos() + 1));
        assertEquals(t.getLines(),l);
        t.rotate();

        List<LineSegment> l1= new ArrayList<>();
        l1.add(new LineSegment(t.getXpos()-1, t.getYpos(), t.getXpos(), t.getYpos()));
        l1.add(new LineSegment(t.getXpos(), t.getYpos(), t.getXpos(), t.getYpos() + 1));
        l1.add(new LineSegment(t.getXpos()-1, t.getYpos(), t.getXpos(), t.getYpos() + 1));
        assertEquals(t.getLines(),l1);

    }

    @Test
    public void testStates(){
        assertEquals(t.getState(),TriangleGizmo.Rotation.TOP_LEFT);
        t.rotate();
        assertEquals(t.getState(),TriangleGizmo.Rotation.TOP_RIGHT);
        t.rotate();
        assertEquals(t.getState(),TriangleGizmo.Rotation.BOTTOM_RIGHT);
        t.rotate();
        assertEquals(t.getState(),TriangleGizmo.Rotation.BOTTOM_LEFT);
        t.rotate();
        assertEquals(t.getState(),TriangleGizmo.Rotation.TOP_LEFT);
    }


}
