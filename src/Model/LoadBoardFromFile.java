package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LoadBoardFromFile {

    public static void readFromFile(String fileName, Model m) throws IOException {

        File file = new File(fileName);
        List<Gizmo> gizmos = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;

        while((line = br.readLine()) != null){

            String[] tokens = line.split(" ");

            String type = tokens[0].toLowerCase();

            switch (type){
                case "square":
                    m.addSquare(new SquareGizmo(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3])));
                    break;
                case "circle":
                    m.addCircle(new CircleGizmo(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3])));
                    break;
                case "triangle":
                    m.addTriangle(new TriangleGizmo(tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]), "topleft"));
                    break;
                case "absorber":
                    m.addAbsorber(new AbsorberGizmo(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5])));
                    break;
                case "leftflipper":
                    //gizmos.add(new FlipperGizmo());
                    break;
                case "rightflipper":
                    //gizmos.add(new FlipperGizmo());
                    break;
                case "ball":
                    //gizmos.add(new Ball(Integer.parseInt(tokens[3]), Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5])));
                    break;
                case "rotate":
                    TriangleGizmo t = m.getTrianglebyName(tokens[1]);
                    t.rotate();

            }

        }
    }
}
