package Model;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private ArrayList<CircleGizmo> circles;
    private ArrayList<SquareGizmo> squares;
    private ArrayList<TriangleGizmo> triangles;
    private List<Gizmo> gizmos;

    public Model(){
        gizmos = new ArrayList<>();
        circles = new ArrayList<>();
        squares = new ArrayList<>();
        triangles = new ArrayList<>();
    }
    public ArrayList<CircleGizmo> getCircles() {
        return circles;
    }

    public ArrayList<SquareGizmo> getSquare(){
        return squares;
    }

    public ArrayList<TriangleGizmo> getTriangles(){
        return triangles;
    }

    public void addCircle(CircleGizmo c) {
        circles.add(c);
    }

    public void addSquare(SquareGizmo s){
        squares.add(s);
    }

    public void addTriangle(TriangleGizmo t) {
        triangles.add(t);
    }
}
