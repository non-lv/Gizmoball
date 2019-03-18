package Model;

import physics.Geometry.VectPair;
import physics.Vect;


public class CollisionDetails {
    private Ball b;
    private double tuc;
    private Vect velocity;
    private IGizmo g;

    private VectPair velocityPair;
    private Ball b_;

    public CollisionDetails(Ball ball, double t, VectPair v, Ball ball_) {
        b = ball;
        tuc = t;
        velocityPair = v;
        b_ = ball_;
    }

    public CollisionDetails(Ball ball, double t, Vect v, IGizmo gizmo) {
        b = ball;
        tuc = t;
        velocity = v;
        g = gizmo;
    }

    public double getTuc() {
        return tuc;
    }

    public Vect getVelocity() {
        return velocity;
    }

    public IGizmo getGizmo() {
        return g;
    }

    public boolean isBallToBallCollision() {
        return b_ != null;
    }

    public VectPair getVelocityPair() {
        return velocityPair;
    }

    public Ball getBall() {
        return b;
    }

    public Ball getBall_() {
        return b_;
    }

    public boolean hasCollision(Ball ball) {
        return b == ball || (b_ != null && b_ ==ball);
    }
}