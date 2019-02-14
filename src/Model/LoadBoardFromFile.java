package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LoadBoardFromFile {

    public static void readFromFile(String fileName, Model m) throws IOException {

        File file = new File(fileName);
        List<IGizmo> iGizmos = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;

        while((line = br.readLine()) != null){

            String[] tokens = line.split(" ");

            String type = tokens[0].toLowerCase();

            switch (type){
                case "square":
                    m.addSquare(new SquareGizmo(tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3])));
                    break;
                case "circle":
                    m.addCircle(new CircleGizmo(tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3])));
                    break;
                case "triangle":
                    m.addTriangle(new TriangleGizmo(tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]), "topleft"));
                    break;
                case "absorber":
                    m.addAbsorber(new AbsorberGizmo(tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5])));
                    break;
                case "leftflipper":
                    m.addFlipper(new FlipperGizmo(tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]), 1));
                    break;
                case "rightflipper":
                    m.addFlipper(new FlipperGizmo(tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]), 0));
                    break;
                case "ball":
                    m.addBall(new Ball((int)Double.parseDouble(tokens[2]), (int)Double.parseDouble(tokens[3]), (int)Double.parseDouble(tokens[4]), (int)Double.parseDouble(tokens[5])));
                    break;

                case "rotate":
                    TriangleGizmo t = m.getTrianglebyName(tokens[1]);
                    t.rotate();

            }

        }
    }
}
