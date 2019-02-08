package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LoadBoardFromFile {

    public static void readFromFile(String fileName) throws IOException {

        File file = new File(fileName);
        List<Gizmo> gizmos = new ArrayList<>();


        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;

        while((line = br.readLine()) != null){

            String[] tokens = line.split(" ");

            String type = tokens[0].toLowerCase();

            switch (type){
                case "square":
                    gizmos.add(new SquareGizmo(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3])));
                    break;
                case "circle":
                    break;
                case "triangle":
                    break;
                case "absorber":
                    break;
                case "leftflipper":
                    break;
                case "rightflipper":
                    break;
                case "ball":
                    break;

            }

        }
    }
}
