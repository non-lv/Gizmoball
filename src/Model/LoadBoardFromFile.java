package Model;

import java.awt.event.KeyEvent;
import javax.swing.*;
import java.io.*;
import java.util.List;


public class LoadBoardFromFile {


    public static void readFromFile(String fileName, Model m) throws IOException {

        File file = new File(fileName);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;

        m.clear();

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
                        if(checkCount(tokens, 2)){
                            IGizmo gizmo;

                            if((gizmo = m.getGizmoByName(tokens[1])) != null){
                                gizmo.rotate();
                            }
                        }
                        break;
                    case "connect":
                        if(checkCount(tokens, 3)){

                            IGizmo trigger = null;
                            IGizmo action = null;

                            if((trigger = m.getGizmoByName(tokens[1])) != null && (action = m.getGizmoByName(tokens[2])) != null){
                                Connection connection = new Connection(trigger, action);
                                m.addConnection(connection);

                            }
                        }
                        break;
                    case "keyconnect" :
                        if(checkCount(tokens, 5)){

                            IGizmo action = null;
                            int key = Integer.parseInt(tokens[2]);
                            String keyStatus = tokens[3];

                            if((action = m.getGizmoByName(tokens[4])) != null){
                                if(keyStatus.equals("down")){
                                    KeyConnection keyConnection = new KeyConnection(action, key, KeyConnection.KeyStatus.DOWN);
                                    m.addKeyConnection(keyConnection);
                                } else if(keyStatus.equals("up")){
                                    KeyConnection keyConnection = new KeyConnection(action, key, KeyConnection.KeyStatus.UP);
                                    m.addKeyConnection(keyConnection);
                                }
                            }
                        }
                    case "move" :
                        if(checkCount(tokens, 4)){
                            IGizmo gizmo = null;
                            if((gizmo = m.getGizmoByName(tokens[1])) != null){
                                int x = Integer.parseInt(tokens[2]);
                                int y = Integer.parseInt(tokens[3]);
                                if (gizmo.getId().startsWith("AB")){
                                    m.moveAbsorber((AbsorberGizmo)gizmo, x, y);
                                } else {
                                    m.moveGizmo(gizmo, x, y);
                                }
                            } else {
                                Ball ball = null;

                                if((ball = m.getBallByName(tokens[1])) != null){

                                    double x = Double.parseDouble(tokens[2]);
                                    double y = Double.parseDouble(tokens[3]);

                                    m.moveBall(ball, x, y);

                                }
                            }
                        }
                        break;
                    case "delete" :
                        if(checkCount(tokens, 2)){
                            IGizmo gizmo = null;
                            if((gizmo = m.getGizmoByName(tokens[1])) != null){
                                m.removeGizmo(gizmo);
                            } else {
                                Ball ball = null;
                                if((ball = m.getBallByName(tokens[1])) != null){
                                    m.removeBall(ball);
                                }
                            }
                        }
                        break;
                    case "gravity" :
                        if(checkCount(tokens, 2)){

                            double gravity = Double.parseDouble(tokens[1]);
                            m.setGravity(gravity);
                        }
                        break;
                    case "friction" :
                        if(checkCount(tokens, 3)){

                            double x = Double.parseDouble(tokens[1]);
                            double y = Double.parseDouble(tokens[2]);

                            m.setFrictionXY(x,y);
                        }
                        break;
                }

            } catch (NumberFormatException ex){
                System.out.println("Types Incorrect : " + line);
            } catch (InvalidLocationException ex){
                System.out.println("Taking occupied space : " + line);
            }
        }

    }

    private static boolean checkCount(String[] line, int count){
        return line.length == count;
    }


}
