package Testing;
import Model.FlipperGizmo;
import org.junit.Test;
import static org.junit.Assert.*;
import Model.TriangleGizmo;
import physics.Circle;
import physics.LineSegment;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class FlipperTest {
    FlipperGizmo leftf = new FlipperGizmo("left", 1, 1, true);
    FlipperGizmo rightf = new FlipperGizmo("right", 10, 1, false);

    @Test
    public void testID() {
        assertTrue(leftf.getId().equals("left"));
        assertFalse(leftf.getId().equals("false"));
        assertTrue(rightf.getId().equals("right"));
        assertFalse(rightf.getId().equals("false"));
    }

    @Test
    public void testXpos() {
        assertEquals(leftf.getX(), 1);

    }

    @Test
    public void testCirclesLeft() {
        List<Circle> l = new ArrayList<>();
        double x = 0, y = 0, x2 = 0, y2 = 0;

        x = leftf.getX() + (.5 / 2);
        y = leftf.getY() + (.5 / 2);
        x2 = x + ((2 - 0.5) * Math.sin(Math.toRadians(leftf.getAngle())));
        y2 = y + ((2 - 0.5) * Math.sin(Math.toRadians(90 - leftf.getAngle())));
        l.add(new Circle(x, y, 0.5 / 2));
        l.add(new Circle(x2, y2, 0.5 / 2));
        assertEquals(leftf.getCircles(), l);


        leftf.rotate();
        x = (leftf.getX() + 2) - (.5 / 2);
        y = leftf.getY() + (.5 / 2);
        x2 = x - ((2 - .5) * Math.sin(Math.toRadians(90 - leftf.getAngle())));
        y2 = y + ((2 - .5) * Math.sin(Math.toRadians(leftf.getAngle())));
        l.clear();
        l.add(new Circle(x, y, 0.5 / 2));
        l.add(new Circle(x2, y2, 0.5 / 2));
        assertEquals(leftf.getCircles(), l);

        leftf.rotate();
        x = (leftf.getX() + 2) - (.5 / 2);
        y = (leftf.getY() + 2) - (.5 / 2);
        x2 = x - ((2 - .5) * Math.sin(Math.toRadians(leftf.getAngle())));
        y2 = y - ((2 - .5) * Math.sin(Math.toRadians(90 - leftf.getAngle())));
        l.clear();
        l.add(new Circle(x, y, 0.5 / 2));
        l.add(new Circle(x2, y2, 0.5 / 2));
        assertEquals(leftf.getCircles(), l);

        leftf.rotate();
        x = leftf.getX() + .5 / 2;
        y = leftf.getY() + 2 - .5 / 2;
        x2 = x + (2 - .5) * Math.sin(Math.toRadians(90 - leftf.getAngle()));
        y2 = y - (2 - .5) * Math.sin(Math.toRadians(leftf.getAngle()));
        l.clear();
        l.add(new Circle(x, y, 0.5 / 2));
        l.add(new Circle(x2, y2, 0.5 / 2));
        assertEquals(leftf.getCircles(), l);

    }

    @Test
    public void testCirclesRight() {
        List<Circle> l = new ArrayList<>();
        double x = 0, y = 0, x2 = 0, y2 = 0;

        x = (rightf.getX() + 2) - (.5 / 2);
        y = rightf.getY() + (.5 / 2);
        x2 = x - ((2 - .5) * Math.sin(Math.toRadians(rightf.getAngle())));
        y2 = y + ((2 - .5) * Math.sin(Math.toRadians(90 - rightf.getAngle())));
        l.clear();
        l.add(new Circle(x, y, 0.5 / 2));
        l.add(new Circle(x2, y2, 0.5 / 2));
        assertEquals(rightf.getCircles(), l);


        rightf.rotate();
        x = (rightf.getX() + 2) - (.5 / 2);
        y = (rightf.getY() + 2) - (.5 / 2);
        x2 = x - ((2 - .5) * Math.sin(Math.toRadians(90 - rightf.getAngle())));
        y2 = y - ((2 - .5) * Math.sin(Math.toRadians(rightf.getAngle())));
        l.clear();
        l.add(new Circle(x, y, 0.5 / 2));
        l.add(new Circle(x2, y2, 0.5 / 2));
        assertEquals(rightf.getCircles(), l);

        rightf.rotate();
        x = rightf.getX() + .5 / 2;
        y = rightf.getY() + 2 - .5 / 2;
        x2 = x + (2 - .5) * Math.sin(Math.toRadians(rightf.getAngle()));
        y2 = y - (2 - .5) * Math.sin(Math.toRadians(90 - rightf.getAngle()));
        l.clear();
        l.add(new Circle(x, y, 0.5 / 2));
        l.add(new Circle(x2, y2, 0.5 / 2));
        assertEquals(rightf.getCircles(), l);

        rightf.rotate();
        x = rightf.getX() + (.5 / 2);
        y = rightf.getY() + (.5 / 2);
        x2 = x + ((2 - 0.5) * Math.sin(Math.toRadians(90 - rightf.getAngle())));
        y2 = y + ((2 - 0.5) * Math.sin(Math.toRadians(rightf.getAngle())));
        l.clear();
        l.add(new Circle(x, y, 0.5 / 2));
        l.add(new Circle(x2, y2, 0.5 / 2));
        assertEquals(rightf.getCircles(), l);


    }

    @Test
    public void testLinesLeft() {
        List<LineSegment> l = new ArrayList<>();
        double x = 0, y = 0, x2 = 0, y2 = 0;
        double x_line_, y_line_, x_line_2, y_line_2;
        double x_change = 0, y_change = 0;

        x = leftf.getX() + .5 / 2;
        y = leftf.getY() + .5 / 2;
        x2 = x + (2 - .5) * Math.sin(Math.toRadians(leftf.getAngle()));
        y2 = y + (2 - .5) * Math.sin(Math.toRadians(90 - leftf.getAngle()));
        x_change = .5 / 2 * Math.sin(Math.toRadians(90 - leftf.getAngle()));
        y_change = .5 / 2 * Math.sin(Math.toRadians(leftf.getAngle()));
        x_line_ = x + x_change;
        y_line_ = y - y_change;
        x_line_2 = x2 + x_change;
        y_line_2 = y2 - y_change;
        l.add(new LineSegment(x_line_, y_line_, x_line_2, y_line_2));
        x_line_ = x - x_change;
        y_line_ = y + y_change;
        x_line_2 = x2 - x_change;
        y_line_2 = y2 + y_change;
        l.add(new LineSegment(x_line_, y_line_, x_line_2, y_line_2));
        assertEquals(l, leftf.getLines());

        leftf.rotate();
        l.clear();
        x = leftf.getX() + 2 - .5 / 2;
        y = leftf.getY() + 2 - .5 / 2;
        x2 = x - (2 - .5) * Math.sin(Math.toRadians(90 - leftf.getAngle()));
        y2 = y - (2 - .5) * Math.sin(Math.toRadians(leftf.getAngle()));
        x_change = .5 / 2 * Math.sin(Math.toRadians(leftf.getAngle()));
        y_change = .5 / 2 * Math.sin(Math.toRadians(90 - leftf.getAngle()));
        x_line_ = x + x_change;
        y_line_ = y - y_change-1.5;
        x_line_2 = x2 + x_change;
        y_line_2 = y2 - y_change-1.5;
        l.add(new LineSegment(x_line_, y_line_, x_line_2, y_line_2));
        x_line_ = x - x_change;
        y_line_ = y + y_change-1.5;
        x_line_2 = x2 - x_change;
        y_line_2 = y2 + y_change-1.5;
        l.add(new LineSegment(x_line_, y_line_, x_line_2, y_line_2));
        assertEquals(l, leftf.getLines());

        leftf.rotate();
        l.clear();
        x = leftf.getX() + 2 - .5 / 2;
        y = leftf.getY() + 2 - .5 / 2;
        x2 = x - (2 - .5) * Math.sin(Math.toRadians(leftf.getAngle()));
        y2 = y - (2 - .5) * Math.sin(Math.toRadians(90 - leftf.getAngle()));
        x_change = .5 / 2 * Math.sin(Math.toRadians(90 - leftf.getAngle()));
        y_change = .5 / 2 * Math.sin(Math.toRadians(leftf.getAngle()));
        x_line_ = x + x_change;
        y_line_ = y - y_change;
        x_line_2 = x2 + x_change;
        y_line_2 = y2 - y_change;
        l.add(new LineSegment(x_line_, y_line_, x_line_2, y_line_2));
        x_line_ = x - x_change;
        y_line_ = y + y_change;
        x_line_2 = x2 - x_change;
        y_line_2 = y2 + y_change;
        l.add(new LineSegment(x_line_, y_line_, x_line_2, y_line_2));
        assertEquals(l, leftf.getLines());
        
        leftf.rotate();
        l.clear();
        x = leftf.getX() + .5 / 2;
        y = leftf.getY() + 2 - .5 / 2;
        x2 = x + (2 - .5) * Math.sin(Math.toRadians(90 - leftf.getAngle()));
        y2 = y - (2 - .5) * Math.sin(Math.toRadians(leftf.getAngle()));
        x_change = .5 / 2 * Math.sin(Math.toRadians(leftf.getAngle()));
        y_change = .5 / 2 * Math.sin(Math.toRadians(90 - leftf.getAngle()));
        x_line_ = x + x_change;
        y_line_ = y - y_change;
        x_line_2 = x2 + x_change;
        y_line_2 = y2 - y_change;
        l.add(new LineSegment(x_line_, y_line_, x_line_2, y_line_2));
        x_line_ = x - x_change;
        y_line_ = y + y_change;
        x_line_2 = x2 - x_change;
        y_line_2 = y2 + y_change;
        l.add(new LineSegment(x_line_, y_line_, x_line_2, y_line_2));
        assertEquals(l, leftf.getLines());


    }

    @Test
    public void testLinesRight() {
        List<LineSegment> l = new ArrayList<>();
        double x = 0, y = 0, x2 = 0, y2 = 0;
        double x_line_, y_line_, x_line_2, y_line_2;
        double x_change = 0, y_change = 0;

        x = rightf.getX() + 2 - .5 / 2;
        y = rightf.getY() + .5 / 2;
        x2 = x - (2 - .5) * Math.sin(Math.toRadians(rightf.getAngle()));
        y2 = y + (2 - .5) * Math.sin(Math.toRadians(90 - rightf.getAngle()));
        x_change = .5 / 2 * Math.sin(Math.toRadians(90 - rightf.getAngle()));
        y_change = .5 / 2 * Math.sin(Math.toRadians(rightf.getAngle()));
        x_line_ = x + x_change;
        y_line_ = y - y_change;
        x_line_2 = x2 + x_change;
        y_line_2 = y2 - y_change;
        l.add(new LineSegment(x_line_, y_line_, x_line_2, y_line_2));
        x_line_ = x - x_change;
        y_line_ = y + y_change;
        x_line_2 = x2 - x_change;
        y_line_2 = y2 + y_change;
        l.add(new LineSegment(x_line_, y_line_, x_line_2, y_line_2));
        assertEquals(l, rightf.getLines());
        
        rightf.rotate();
        l.clear();
        x = rightf.getX() + 2 - .5 / 2;
        y = rightf.getY() + 2 - .5 / 2;
        x2 = x - (2 - .5) * Math.sin(Math.toRadians(90 - rightf.getAngle()));
        y2 = y - (2 - .5) * Math.sin(Math.toRadians(rightf.getAngle()));
        x_change = .5 / 2 * Math.sin(Math.toRadians(rightf.getAngle()));
        y_change = .5 / 2 * Math.sin(Math.toRadians(90 - rightf.getAngle()));
        x_line_ = x + x_change;
        y_line_ = y - y_change;
        x_line_2 = x2 + x_change;
        y_line_2 = y2 - y_change;
        l.add(new LineSegment(x_line_, y_line_, x_line_2, y_line_2));
        x_line_ = x - x_change;
        y_line_ = y + y_change;
        x_line_2 = x2 - x_change;
        y_line_2 = y2 + y_change;
        l.add(new LineSegment(x_line_, y_line_, x_line_2, y_line_2));
        assertEquals(l, rightf.getLines());

        rightf.rotate();
        l.clear();
        x = rightf.getX() + .5 / 2;
        y = rightf.getY() + 2 - .5 / 2;
        x2 = x + (2 - .5) * Math.sin(Math.toRadians(rightf.getAngle()));
        y2 = y - (2 - .5) * Math.sin(Math.toRadians(90 - rightf.getAngle()));
        x_change = .5 / 2 * Math.sin(Math.toRadians(90 - rightf.getAngle()));
        y_change = .5 / 2 * Math.sin(Math.toRadians(rightf.getAngle()));
        x_line_ = x + x_change;
        y_line_ = y - y_change;
        x_line_2 = x2 + x_change;
        y_line_2 = y2 - y_change;
        l.add(new LineSegment(x_line_, y_line_, x_line_2, y_line_2));
        x_line_ = x - x_change;
        y_line_ = y + y_change;
        x_line_2 = x2 - x_change;
        y_line_2 = y2 + y_change;
        l.add(new LineSegment(x_line_, y_line_, x_line_2, y_line_2));
        assertEquals(l, rightf.getLines());

        rightf.rotate();
        l.clear();
        x = rightf.getX() + .5 / 2;
        y = rightf.getY() + .5 / 2;
        x2 = x + (2 - .5) * Math.sin(Math.toRadians(90 - rightf.getAngle()));
        y2 = y + (2 - .5) * Math.sin(Math.toRadians(rightf.getAngle()));
        x_change = .5 / 2 * Math.sin(Math.toRadians(rightf.getAngle()));
        y_change = .5 / 2 * Math.sin(Math.toRadians(90 - rightf.getAngle()));
        x_line_ = x + x_change;
        y_line_ = y - y_change;
        x_line_2 = x2 + x_change;
        y_line_2 = y2 - y_change;
        l.add(new LineSegment(x_line_, y_line_, x_line_2, y_line_2));
        x_line_ = x - x_change;
        y_line_ = y + y_change;
        x_line_2 = x2 - x_change;
        y_line_2 = y2 + y_change;
        l.add(new LineSegment(x_line_, y_line_, x_line_2, y_line_2));
        assertEquals(l, rightf.getLines());
    }

    @Test
    public void channgingPos(){
        leftf.setPos(5,5);
        rightf.setPos(12,6);
        assertEquals(leftf.getX(),5);
        assertEquals(leftf.getY(),5);
        assertEquals(rightf.getX(),12);
        assertEquals(rightf.getY(),6);
    }

    @Test
    public void testAngle(){
        assertTrue(leftf.getAngle()==0);
        leftf.setAngle(33.3);
        assertTrue(leftf.getAngle()==33.3);
        assertFalse(leftf.getAngle() == 0);
    }

    @Test
    public void flipperSide(){
        assertEquals(leftf.isLeft(),true);
        assertNotEquals(leftf.isLeft(),false);
        assertEquals(rightf.isLeft(),false);
        assertNotEquals(rightf.isLeft(),true);
    }

    @Test
    public void rotating(){
        assertEquals(leftf.getState(), FlipperGizmo.Rotation.TOP_LEFT);
        leftf.rotate();
        assertEquals(leftf.getState(), FlipperGizmo.Rotation.TOP_RIGHT);
        leftf.rotate();
        assertEquals(leftf.getState(), FlipperGizmo.Rotation.BOTTOM_RIGHT);
        leftf.rotate();
        assertEquals(leftf.getState(), FlipperGizmo.Rotation.BOTTOM_LEFT);

        assertEquals(rightf.getState(), FlipperGizmo.Rotation.TOP_RIGHT);
        rightf.rotate();
        assertEquals(rightf.getState(), FlipperGizmo.Rotation.BOTTOM_RIGHT);
        rightf.rotate();
        assertEquals(rightf.getState(), FlipperGizmo.Rotation.BOTTOM_LEFT);
        rightf.rotate();
        assertEquals(rightf.getState(), FlipperGizmo.Rotation.TOP_LEFT);

    }
}
