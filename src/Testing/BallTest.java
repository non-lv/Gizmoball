package Testing;
import Model.AbsorberGizmo;
import Model.Ball;
import org.junit.Test;
import static org.junit.Assert.*;
import physics.Vect;

import physics.Circle;


public class BallTest {
    Ball ball = new Ball("Ball", 3.0,3.0,3.0,3.0);
    Ball ball1 = new Ball("Ball1", 19.0,3.0,5.0,5.0);

    @Test
    public void testID() {
        assertTrue(ball.getId().equals("Ball"));
        assertFalse(ball.getId().equals(ball1.getId()));
    }
    @Test
    public void testXpos() {
        assertTrue(ball.getX()==3.0);
        assertNotEquals(ball.getX(), 1);
    }
    @Test
    public void testSetX(){
        ball.setX(19.0);
        assertTrue(ball.getX()==19.0);
        assertFalse(ball.getX()==3.0);
    }
    @Test
    public void testSetY(){
        ball.setY(17.0);
        assertTrue(ball.getY()==17.0);
        assertFalse(ball.getY()==3.0);
    }

    @Test
    public void testYpos() {
        assertTrue(ball.getY()==3.0);
        assertNotEquals(ball.getY(),1);
    }
    @Test
    public void testVel(){
        Vect v = new Vect(3.0,3.0);
        assertEquals(ball.getVelocity(),v);
        assertNotEquals(ball1.getVelocity(),v);
    }
    @Test
    public void setVel1(){
        ball.setVelocity(10.0,10.0);
        Vect v = new Vect(10.0,10.0);
        assertEquals(ball.getVelocity(),v);
        assertNotEquals(ball1.getVelocity(),v);


    }
    @Test
    public void setVel2(){
        Vect v = new Vect(5.0,10.0);
        ball.setVelocity(v);

        assertEquals(ball.getVelocity(),v);
        assertNotEquals(ball1.getVelocity(),v);


    }
    @Test
    public void testCircle(){
        Circle c = new Circle(ball.getX(), ball.getY(), ball.getRadius());
        assertEquals(ball.getCircle(),c);
        assertNotEquals(ball1.getCircle(),c);
    }
    @Test
    public void testGetRadius(){
        assertTrue(ball.getRadius()==0.25);
        assertFalse(ball.getRadius()==0.26);
    }
    @Test
    public void TestStopMove(){
        assertTrue(ball.isMoving());
        ball.stop();
        assertFalse(ball.isMoving());

    }



    @Test
    public void testSpeed(){

        double a = Math.sqrt(Math.pow(ball.getVelocity().x(), 2) + Math.pow(ball.getVelocity().y(), 2));
        assertTrue(a==ball.getSpeed());
        assertNotEquals(a,ball1.getVelocity());

    }

    @Test
    public void testMove(){
        ball.move();
        assertEquals(ball.isMoving(),true);
    }

    @Test
    public void testEquals(){
        assertTrue(ball.equals(ball));
        assertFalse(ball.equals(ball1));
        AbsorberGizmo a = new AbsorberGizmo("a",1,2,3,4);
        assertFalse(ball.equals(a));
    }
}
