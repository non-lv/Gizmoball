package Model;

import java.io.*;


public class LoadBoardFromFile {


    public static void readFromFile(String fileName, Model m) throws IOException {

        File file = new File(fileName);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;

        while((line = br.readLine()) != null){

            String[] tokens = line.split(" ");
            String type = tokens[0].toLowerCase();

            try{
                switch (type) {
                    case "square":
                        if (checkCount(tokens, 4)) {
                            String id = tokens[1];
                            int x = Integer.parseInt(tokens[2]);
                            int y = Integer.parseInt(tokens[3]);
                            m.addGizmo(new SquareGizmo(id, x, y));

                        } else {
                            System.out.println("Incorrect format : " + line);
                        }
                        break;
                    case "circle":
                        if (checkCount(tokens, 4)) {
                            String id = tokens[1];
                            int x = Integer.parseInt(tokens[2]);
                            int y = Integer.parseInt(tokens[3]);
                            m.addGizmo(new CircleGizmo(id, x, y));
                        } else {
                            System.out.println("Incorrect Format : " + line);
                        }
                        break;
                    case "triangle":
                        if (checkCount(tokens, 4)) {
                            String id = tokens[1];
                            int x = Integer.parseInt(tokens[2]);
                            int y = Integer.parseInt(tokens[3]);
                            m.addGizmo(new TriangleGizmo(id, x, y, TriangleGizmo.Rotation.TOP_LEFT));
                        } else {
                            System.out.println("Incorrect Format : " + line);
                        }
                        break;
                    case "absorber":
                        if (checkCount(tokens, 6)) {
                            String id = tokens[1];
                            int x1 = Integer.parseInt(tokens[2]);
                            int y1 = Integer.parseInt(tokens[3]);
                            int x2 = Integer.parseInt(tokens[4]);
                            int y2 = Integer.parseInt(tokens[5]);
                            m.addGizmo(new AbsorberGizmo(id, x1, y1, x2, y2));
                        } else {
                            System.out.println("Incorrect Format : " + line);
                        }
                        break;
                    case "leftflipper":
                        if (checkCount(tokens, 4)) {
                            String id = tokens[1];
                            int x = Integer.parseInt(tokens[2]);
                            int y = Integer.parseInt(tokens[3]);
                            m.addGizmo(new FlipperGizmo(id, x, y, true));
                        } else {
                            System.out.println("Incorrect Format : " + line);
                        }
                        break;
                    case "rightflipper":
                        if (checkCount(tokens, 4)) {
                            String id = tokens[1];
                            int x = Integer.parseInt(tokens[2]);
                            int y = Integer.parseInt(tokens[3]);
                            m.addGizmo(new FlipperGizmo(id, x, y, false));
                        } else {
                            System.out.println("Incorrect Format : " + line);
                        }
                        break;
                    case "ball":
                        if (checkCount(tokens, 6)) {
                            String id = tokens[1];
                            double x = Double.parseDouble(tokens[2]);
                            double y = Double.parseDouble(tokens[3]);
                            double xv = Double.parseDouble(tokens[4]);
                            double yv = Double.parseDouble(tokens[5]);
                            m.addBall(new Ball(id, x, y, xv, yv));
                        } else {

                            System.out.println("Incorrect Format : " + line);
                        }
                        break;
                    case "rotate":
                        TriangleGizmo t = (TriangleGizmo)m.getTriangleByName(tokens[1]);
                        if(t == null){
                            FlipperGizmo f = (FlipperGizmo)m.getFlipperByName(tokens[1]);
                            if(f == null){
                                break;
                            }
                            f.rotate();
                            break;
                        }
                        t.rotate();
                        break;
                }



            } catch (NumberFormatException ex){
                System.out.println("Types Incorrect : " + line);
            }


        }

    }

    private static boolean checkCount(String[] line, int count){
        return line.length == count;
    }


}
