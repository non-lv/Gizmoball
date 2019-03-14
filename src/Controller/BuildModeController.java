package Controller;

import Model.*;
import View.BoardPanel;
import View.BuildModePanel;
import View.HomeFrame;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BuildModeController implements ActionListener {

    private final BuildModePanel panel;
    private boolean clicked;
    private final BoardPanel boardPanel;
    private HomeFrame home;
    private Model model;
    private IGizmo moving;

    private int x;
    private int y;
    public BuildModeController(Model model, BuildModePanel panel, BoardPanel boardPanel){
        this.clicked = false;
        this.model = model;
        this.panel = panel;
        this.boardPanel = boardPanel;
    }

    public void setHomeFrame(HomeFrame home){
        this.home = home;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Square":
                removeListeners();
                home.showNotification("Select a grid point to draw a square");
                boardPanel.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        x = e.getX() / boardPanel.getTileSize();
                        y = e.getY() / boardPanel.getTileSize();
                        for (int i = 0; i < model.getGizmos().size(); i++) {
                            if (x == model.getGizmos().get(i).getX() && y == model.getGizmos().get(i).getY()) {
                                home.showNotification("That space is occupied, please click another");
                                return;
                            }
                        }
                        Random random = new Random();
                        String id;
                        ArrayList<String> taken = new ArrayList<>();
                        for (int i = 0; i < model.getSquares().size(); i++) {
                            taken.add(model.getSquares().get(i).getId());
                        }
                        do {
                            id = "S" + random.nextInt(90);
                            System.out.println(id);
                        } while (taken.contains(id));
                        model.addGizmo(new SquareGizmo(id, x, y));
                        home.showNotification("Selected a grid point to draw a square");
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                });
                break;
            case "Triangle":
                home.showNotification("Select a grid point to draw a triangle");
                removeListeners();
                boardPanel.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        x = e.getX() / boardPanel.getTileSize();
                        y = e.getY() / boardPanel.getTileSize();
                        for (int i = 0; i < model.getGizmos().size(); i++) {
                            if (x == model.getGizmos().get(i).getX() && y == model.getGizmos().get(i).getY()) {
                                home.showNotification("That space is occupied, please click another");
                                return;
                            }
                        }
                        Random random = new Random();
                        String id = null;
                        ArrayList<String> taken = new ArrayList<>();
                        for (int i = 0; i < model.getTriangles().size(); i++) {
                            taken.add(model.getTriangles().get(i).getId());
                        }
                        do {
                            id = "T" + random.nextInt(90);
                            System.out.println(id);
                        } while (taken.contains(id));
                        model.addGizmo(new TriangleGizmo(id, x, y, null));
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                });
                break;
            case "Circle":
                home.showNotification("Select a grid point to draw a circle");
                removeListeners();
                boardPanel.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        x = e.getX() / boardPanel.getTileSize();
                        y = e.getY() / boardPanel.getTileSize();
                        for (int i = 0; i < model.getGizmos().size(); i++) {
                            if (x == model.getGizmos().get(i).getX() && y == model.getGizmos().get(i).getY()) {
                                home.showNotification("That space is occupied, please click another");
                                return;
                            }
                        }
                        Random random = new Random();
                        String id;
                        ArrayList<String> taken = new ArrayList<>();
                        for (int i = 0; i < model.getCircles().size(); i++) {
                            taken.add(model.getCircles().get(i).getId());
                        }
                        do {
                            id = "C" + random.nextInt(90);
                            System.out.println(id);
                        } while (taken.contains(id));


                        model.addGizmo(new CircleGizmo(id, x, y));
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                });
                break;
            case "lFlipper":
                home.showNotification("Select a grid point to draw a left flipper");
                removeListeners();
                boardPanel.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        x = e.getX() / boardPanel.getTileSize();
                        y = e.getY() / boardPanel.getTileSize();
                        for (int i = 0; i < model.getGizmos().size(); i++) {
                            if (x == model.getGizmos().get(i).getX() && y == model.getGizmos().get(i).getY()) {
                                home.showNotification("That space is occupied, please click another");
                                return;
                            }
                        }
                        Random random = new Random();
                        String id;
                        ArrayList<String> taken = new ArrayList<>();
                        for (int i = 0; i < model.getFlippers().size(); i++) {
                            taken.add(model.getFlippers().get(i).getId());
                        }
                        do {
                            id = "LF" + random.nextInt(90);
                            System.out.println(id);
                        } while (taken.contains(id));


                        model.addGizmo(new FlipperGizmo(id, x, y, true));
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                });
                break;
            case "rFlipper":
                home.showNotification("Select a grid point to draw a right flipper");
                removeListeners();
                boardPanel.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        x = e.getX() / boardPanel.getTileSize();
                        y = e.getY() / boardPanel.getTileSize();
                        System.out.println(x);
                        System.out.println(y);
                        for (int i = 0; i < model.getGizmos().size(); i++) {
                            if (x == model.getGizmos().get(i).getX() && y == model.getGizmos().get(i).getY()) {
                                home.showNotification("That space is occupied, please click another");
                                return;
                            }
                        }
                        Random random = new Random();
                        String id;
                        ArrayList<String> taken = new ArrayList<>();
                        for (int i = 0; i < model.getFlippers().size(); i++) {
                            taken.add(model.getFlippers().get(i).getId());
                        }
                        do {
                            id = "RF" + random.nextInt(90);
                            System.out.println(id);
                        } while (taken.contains(id));
                        model.addGizmo(new FlipperGizmo(id, x, y, false));
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                });
                break;
            case "Absorber":
                removeListeners();
                home.showNotification("Click and drag to draw the absorber");
                MouseAdapter ma = new MouseAdapter() {
                    String currentAbsorberID;
                    @Override
                    public void mousePressed(MouseEvent e) {
                        super.mousePressed(e);
                        x = e.getX() / boardPanel.getTileSize();
                        y = e.getY() / boardPanel.getTileSize();
                        Random random = new Random();
                        ArrayList<String> taken = new ArrayList<>();
                        for (int i = 0; i < model.getAbsorbers().size(); i++) {
                            taken.add(model.getAbsorbers().get(i).getId());
                        }
                        do {
                            currentAbsorberID = "AB" + random.nextInt(90);
                            System.out.println(currentAbsorberID);
                        } while (taken.contains(currentAbsorberID));
                        model.addGizmo(new AbsorberGizmo(currentAbsorberID, x, y, x, y));
                        System.out.println("pressed");
                    }
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        super.mouseReleased(e);
                        System.out.println("released");
                        for (AbsorberGizmo absorber:model.getAbsorbers()) {
                            if (absorber.getId().equals(currentAbsorberID) && (e.getX() != x) && (e.getY() != y)){
                                absorber.setPos2(e.getX()/boardPanel.getTileSize(), e.getY()/boardPanel.getTileSize());
                                boardPanel.repaint();
                            }
                        }
                    }
                    @Override
                    public void mouseDragged(MouseEvent e) {
                        System.out.println("Dragged");
                        super.mouseDragged(e);
                        for (AbsorberGizmo absorber:model.getAbsorbers()) {
                            if (absorber.getId().equals(currentAbsorberID)){
                                absorber.setPos2(e.getX()/boardPanel.getTileSize(), e.getY()/boardPanel.getTileSize());
                                boardPanel.repaint();
                            }
                        }
                    }
                };
                boardPanel.addMouseMotionListener(ma);
                boardPanel.addMouseListener(ma);
                break;
            case "Ball":
                removeListeners();
                int xV;
                int xY;
                String newXVelocity = home.getBuildModePanel().getxV().getText();
                String newYVelocity = home.getBuildModePanel().getyV().getText();
                if (newXVelocity.matches("-?[1-9]\\d*|0") && newYVelocity.matches("-?[1-9]\\d*|0")){
                    xV = (Integer.parseInt(newXVelocity));
                    xY = (Integer.parseInt(newYVelocity));
                    home.showNotification("Please click anywhere you wish to add a ball");
                } else {
                    home.showNotification("Please enter numbers values in the X and Y velocity boxes respectively");
                    return;
                }
                boardPanel.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        x = e.getX();
                        y = e.getY();
                        double xBall = (double)x/boardPanel.getTileSize();
                        double yBall = (double)y/boardPanel.getTileSize();
                        for (int i = 0; i < model.getGizmos().size(); i++){
                            if (Math.round(xBall) == model.getGizmos().get(i).getX() && Math.round(yBall) == model.getGizmos().get(i).getY()){
                                home.showNotification("That space is occupied, please click another");
                                return;
                            }
                        }
                        Random random = new Random();
                        String id;
                        ArrayList<String> taken = new ArrayList<>();
                        for (int i = 0; i < model.getCircles().size(); i++){
                            taken.add(model.getCircles().get(i).getId());
                        }
                        do {
                            id = "B" + random.nextInt(90);
                            System.out.println(id);
                        } while (taken.contains(id));
                        model.addBall(new Ball(id, xBall, yBall, xV, xY));
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                });
                break;
            case "Move":
                moving = null;
                removeListeners();
                home.showNotification("Click the gizmo you want to move");
                boardPanel.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        x = e.getX() / boardPanel.getTileSize();
                        y = e.getY() / boardPanel.getTileSize();
                        if (moving == null) {
                            for (int i = 0; i < model.getGizmos().size(); i++) {
                                if (model.getGizmos().get(i).getId().startsWith("AB")){
                                    for (AbsorberGizmo ab:model.getAbsorbers()) {
                                        for (List<Integer> xy:ab.getOccupiedSpace()) {
                                            if(x == xy.get(0) && y == xy.get(1)){
                                                home.showNotification("Please click where you want the selected gizmo to move to");
                                                moving = ab;
                                            }
                                        }
                                    }
                                } else if (x == model.getGizmos().get(i).getX() && y == model.getGizmos().get(i).getY()) {
                                    System.out.println("You clicked a gizmo");
                                    moving = model.getGizmos().get(i);
                                    home.showNotification("Please click where you want the selected gizmo to move to");
                                }
                            }
                        } else {
                            for (IGizmo gizmos : model.getGizmos()) {
                                if (gizmos.getX() == x && gizmos.getY() == y) {
                                    home.showNotification("That space is occupied, please choose another");
                                } else {
                                    if (moving.getId().startsWith("AB")){
                                        int XAway = Math.abs(moving.getX() - x);
                                        int YAway = Math.abs(moving.getY() - y);
                                    } else {
                                        moving.setPos(x, y);
                                        boardPanel.repaint();
                                    }
                                }
                            }
                        }
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                });
                break;
            case "Rotate":
                removeListeners();
                home.showNotification("Click the gizmo you want to rotate");
                boardPanel.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        x = e.getX() / 25;
                        y = e.getY() / 25;
                        for (int i = 0; i < model.getGizmos().size(); i++) {
                            if (x == model.getGizmos().get(i).getX() && y == model.getGizmos().get(i).getY()) {
                                IGizmo rotating = model.getGizmos().get(i);
                                rotating.rotate();
                                boardPanel.repaint();
                            }
                        }
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                });
                break;
            case "Delete":
                removeListeners();
                home.showNotification("Click the gizmo you want to delete");
                boardPanel.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        x = e.getX() / 25;
                        y = e.getY() / 25;
                        for (int i = 0; i < model.getGizmos().size(); i++) {
                            if (x == model.getGizmos().get(i).getX() && y == model.getGizmos().get(i).getY()) {
                                IGizmo deleting = model.getGizmos().get(i);
                                model.removeGizmo(deleting);
                                boardPanel.repaint();
                            }
                        }
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                });
                break;
            case "Clear":
                    model.clear();
                    boardPanel.repaint();
                break;
            case "Connect":
                break;
            case "Disconnect":
                break;
            case "keyConnect":
                break;
            case "keyDisconnect":
                break;
            case "friction":
                String newFriction = home.getBuildModePanel().getFrictionText().getText();
                if (newFriction.matches("[0-9]+")){
                    model.setFriction(Integer.parseInt(newFriction));
                    System.out.println("Gravity changed to " + newFriction);
                } else {
                    home.showNotification("Please enter a number value in the gravity box");
                }
                System.out.println("friction");
                break;
            case "gravity":
                String newGravity = home.getBuildModePanel().getGravityText().getText();
                if (newGravity.matches("-?[0-9]\\d*|0")){
                    model.setGravity(Integer.parseInt(newGravity));
                    System.out.println("Gravity changed to " + newGravity);
                } else {
                    home.showNotification("Please enter a number value in the gravity box");
                }
                System.out.println("gravity");
            break;
        }
    }

    public void removeListeners(){
        for( MouseListener ml : boardPanel.getMouseListeners()) {
            boardPanel.removeMouseListener(ml);
        }
    }
}
