package Model;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveBoardToFile {

    public static void saveToFile(String fileName, Model m) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));

        for(TriangleGizmo t : m.getTriangles()){

            bw.write("Triangle " + t.getId() + " " + t.getX() + " " + t.getY());
            bw.newLine();
            switch(t.getState()){
                case TOP_RIGHT:
                    bw.write("Rotate " + t.getId());
                    bw.newLine();
                    bw.newLine();
                    break;
                case BOTTOM_RIGHT:
                    bw.write("Rotate " + t.getId());
                    bw.newLine();
                    bw.write("Rotate " + t.getId());
                    bw.newLine();
                    bw.newLine();
                    break;
                case BOTTOM_LEFT:
                    bw.write("Rotate " + t.getId());
                    bw.newLine();
                    bw.write("Rotate " + t.getId());
                    bw.newLine();
                    bw.write("Rotate " + t.getId());
                    bw.newLine();
                    bw.newLine();
                    break;
            }
        }
        bw.newLine();

        for(SquareGizmo s : m.getSquare()){

            bw.write("Square " + s.getId() + " " + s.getXpos() + " " + s.getYpos());
            bw.newLine();
        }
        bw.newLine();

        for(CircleGizmo c : m.getCircles()){

            bw.write("Circle " + c.getId() + " " + c.getXpos() + " " + c.getYpos());
            bw.newLine();
        }
        bw.newLine();

        for(AbsorberGizmo a : m.getAbsorber()){

            bw.write("Absorber " + a.getId() + " " + a.getXpos() + " " + a.getYpos() + " " + a.getXpos2() + " " + a.getYpos2());
            bw.newLine();
        }
        bw.newLine();

        for(FlipperGizmo f : m.getFlippers()){

            if(f.isLeft()){
                bw.write("LeftFlipper " + f.getId() + " " + f.getX() + " " + f.getY());
                bw.newLine();
            }else{
                bw.write("RightFlipper " + f.getId() + " " + f.getX() + " " + f.getY());
                bw.newLine();
            }
        }
        bw.newLine();
        bw.close();
    }
}
