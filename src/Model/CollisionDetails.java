package Model;

import physics.Vect;


public class CollisionDetails {
    private double tuc;
    private Vect velo;
    private IGizmo g;
    public CollisionDetails(double t, Vect v, IGizmo gizmo) {
        tuc = t;
        velo = v;
        g = gizmo;
    }

    public double getTuc() {
        return tuc;
    }

    public Vect getVelo() {
        return velo;
    }

    public IGizmo getGizmo(){return g;}

}