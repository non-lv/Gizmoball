package Controller;

import Model.*;
import View.BoardPanel;
import View.BuildModePanel;
import View.HomeFrame;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
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
                        home.showNotification("Select a grid point to draw a square");
                        x = e.getX() / boardPanel.getTileSize();
                        y = e.getY() / boardPanel.getTileSize();
                        Random random = new Random();
                        String id;
                        ArrayList<String> taken = new ArrayList<>();
                        for (int i = 0; i < model.getSquares().size(); i++) {
                            taken.add(model.getSquares().get(i).getId());
                        }
                        do {
                            id = "S" + random.nextInt(90);
                        } while (taken.contains(id));
                        try {
                            model.addGizmo(new SquareGizmo(id, x, y));
                        } catch (InvalidLocationException e1) {
                            home.showNotification("That space is occupied, please click another");
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
            case "Triangle":
                home.showNotification("Select a grid point to draw a triangle");
                removeListeners();
                boardPanel.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        home.showNotification("Select a grid point to draw a triangle");
                        x = e.getX() / boardPanel.getTileSize();
                        y = e.getY() / boardPanel.getTileSize();
                        Random random = new Random();
                        String id = null;
                        ArrayList<String> taken = new ArrayList<>();
                        for (int i = 0; i < model.getTriangles().size(); i++) {
                            taken.add(model.getTriangles().get(i).getId());
                        }
                        do {
                            id = "T" + random.nextInt(90);
                        } while (taken.contains(id));
                        try {
                            model.addGizmo(new TriangleGizmo(id, x, y, null));
                        } catch (InvalidLocationException e1) {
                            home.showNotification("That space is occupied, please click another");
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
            case "Circle":
                home.showNotification("Select a grid point to draw a circle");
                removeListeners();
                boardPanel.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        home.showNotification("Select a grid point to draw a circle");
                        x = e.getX() / boardPanel.getTileSize();
                        y = e.getY() / boardPanel.getTileSize();
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
                        try {
                            model.addGizmo(new CircleGizmo(id, x, y));
                        } catch (InvalidLocationException e1) {
                            home.showNotification("That space is occupied, please click another");
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
            case "lFlipper":
                home.showNotification("Select a grid point to draw a left flipper");
                removeListeners();
                boardPanel.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        home.showNotification("Select a grid point to draw a left flipper");
                        x = e.getX() / boardPanel.getTileSize();
                        y = e.getY() / boardPanel.getTileSize();
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
                        try {
                            model.addGizmo(new FlipperGizmo(id, x, y, true));
                        } catch (InvalidLocationException e1) {
                            home.showNotification("That space is occupied, please click another");
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
            case "rFlipper":
                home.showNotification("Select a grid point to draw a right flipper");
                removeListeners();
                boardPanel.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        x = e.getX() / boardPanel.getTileSize() - 1;
                        y = e.getY() / boardPanel.getTileSize();
                        System.out.println(x);
                        System.out.println(y);
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
                        FlipperGizmo flipperGizmo = new FlipperGizmo(id, x, y, false);
                        try {
                            model.addGizmo(flipperGizmo);
                            home.showNotification("Select a grid point to draw a right flipper");
                        } catch (InvalidLocationException e1) {
                            home.showNotification("That space is occupied, please click another");
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
            case "Absorber":
                removeListeners();
                home.showNotification("Click and drag to draw the absorber");
                MouseAdapter ma = new MouseAdapter() {
                    String currentAbsorberID;
                    @Override
                    public void mousePressed(MouseEvent e) {
                        home.showNotification("Click and drag to draw the absorber");
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
                        try {
                            model.addGizmo(new AbsorberGizmo(currentAbsorberID, x, y, x, y));
                        } catch (InvalidLocationException e1) {
                            home.showNotification("That space is occupied, please click another");
                        }
                        System.out.println("pressed");
                    }
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        super.mouseReleased(e);
                        System.out.println("released");
                        for (AbsorberGizmo absorber:model.getAbsorbers()) {
                            int abs_value = absorber.getX();
                            if (absorber.getId().equals(currentAbsorberID) && (abs_value == absorber.getX2()) && (abs_value == absorber.getY()) && (abs_value == absorber.getY2())){
                                model.removeGizmo(absorber);
                                home.showNotification("Absorber too small");
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
                int newXVelocity = home.getBuildModePanel().getxV();
                int newYVelocity = home.getBuildModePanel().getyV();
//                if (newYVelocity.matches("-?[1-9]\\d*|0")){
                    xV = newXVelocity;
                    xY = newYVelocity;
                System.out.println("new xv" + xV);
                    home.showNotification("Please click anywhere you wish to add a ball");
//                } else {
//                    home.showNotification("Please enter numbers values in the X and Y velocity boxes respectively");
//                    return;
//                }
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
                        for (int i = 0; i < model.getBalls().size(); i++){
                            taken.add(model.getBalls().get(i).getId());
                        }
                        do {
                            id = "B" + random.nextInt(90);
                            System.out.println(id);
                        } while (taken.contains(id));
                        try {
                            model.addBall(new Ball(id, xBall, yBall, xV, xY));
                        } catch (InvalidLocationException e1) {
                            home.showNotification("That space is occupied, please click another");
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
            case "Move":
                moving = null;
                AbsorberGizmo abMove = null;
                removeListeners();
                home.showNotification("Click the gizmo you want to move");

                boardPanel.addMouseListener(new MouseListener() {

                    AbsorberGizmo abMoving = abMove;
                    int ogX;
                    int ogy;

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        x = e.getX() / boardPanel.getTileSize();
                        y = e.getY() / boardPanel.getTileSize();
                        if (moving == null && abMoving == null) {
                            ogX = x;
                            ogy = y;
                            moving = getOccupyingGizmo(ogX, ogy);
                            if (moving == null) {
                                return;
                            }
                            if (moving.getId().startsWith("AB")) {
                                for (AbsorberGizmo ab : model.getAbsorbers()) {
                                    for (List<Integer> xy : ab.getOccupiedSpace()) {
                                        if (ogX == xy.get(0) && ogy == xy.get(1)) {
                                            home.showNotification("Please click where you want the selected gizmo to move to");
                                            abMoving = ab;
                                        }
                                    }
                                }
                            } else {
                                moving = getOccupyingGizmo(x, y);
                                if (moving == null) {
                                    return;
                                }
                                home.showNotification("Please click where you want the selected gizmo to move to");
                            }
                    } else {
                            if (isOccupied(x, y)){
                                home.showNotification("That space is occupied, please select another");
                                return;
                            } else {
                                if (abMoving != null){
                                    int XAway = Math.abs(abMoving.getX() - ogX);
                                    int YAway = Math.abs(abMoving.getY() - ogy);
                                    int X2Away = Math.abs(abMoving.getX2() - ogX);
                                    int Y2Away = Math.abs(abMoving.getY2() - ogy);
                                    abMoving.setPos(x+XAway, y+YAway);
                                    abMoving.setPos2(x+X2Away, y+Y2Away);
                                    boardPanel.repaint();
                                } else if (moving != null){
                                    moving.setPos(x, y);
                                    boardPanel.repaint();
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
                        x = e.getX() / boardPanel.getTileSize();
                        y = e.getY() / boardPanel.getTileSize();
                        IGizmo gizmo = getOccupyingGizmo(x, y);
                        if (gizmo != null){
                            gizmo.rotate();
                            boardPanel.repaint();
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
                        x = e.getX() / boardPanel.getTileSize();
                        y = e.getY() / boardPanel.getTileSize();
                        IGizmo gizmo = getOccupyingGizmo(x, y);
                        if (gizmo != null) {
                            model.removeGizmo(gizmo);
                            boardPanel.repaint();
                            home.showNotification("Gizmo " + gizmo.getId() + " removed");
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
                removeListeners();
                home.showNotification("Click the gizmo that you wish to become the trigger");
                boardPanel.addMouseListener(new MouseListener() {
                    IGizmo trigger = null;
                    IGizmo action = null;
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        x = e.getX()/boardPanel.getTileSize();
                        y = e.getY()/boardPanel.getTileSize();
                        if(trigger == null){
                            trigger = getOccupyingGizmo(x, y);
                            if (trigger == null){
                                return;
                            }
                            home.showNotification("Click the gizmo that you want to connect to");
                        } else {
                            action = getOccupyingGizmo(x, y);
                            if (action == null) {
                                return;
                            }
                                home.showNotification("Connection made between " + trigger.getId() + " and " + action.getId());
                                Connection connection = new Connection(trigger, action);
                                model.addConnection(connection);
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
            case "Disconnect":
                removeListeners();
                home.showNotification("Click the gizmo that you wish to remove the trigger");
                boardPanel.addMouseListener(new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        IGizmo selected;
                        boolean clicked = false;
                        x = e.getX() / boardPanel.getTileSize();
                        y = e.getY() / boardPanel.getTileSize();
                        selected = getOccupyingGizmo(x, y);
                        if (selected != null){
                            home.showNotification("Clicked");
                            clicked = true;
                        }
                        if (clicked) {
                            if(model.getSpecificConnections(selected).isEmpty()){
                                home.showNotification("There are no connections to this gizmo");
                                return;
                            }
                            home.showNotification("Select the connection you wish to delete");
                            JFrame frame = new JFrame();
                            frame.setTitle("Select a connection to remove");
                            DefaultListModel<String> triggers = new DefaultListModel<>();
                            for (Connection connection:model.getSpecificConnections(selected)) {
                                String statement = connection.getTrigger().getId() + " --> " + connection.getAction().getId();
                                triggers.addElement(statement);
                            }
                            JList<String> jList = new JList<>(triggers);
                            JScrollPane scrollPane = new JScrollPane(jList);
                            frame.add(scrollPane, BorderLayout.CENTER);
                            frame.add(jList);
                            JButton jb = new JButton("Select");
                            jb.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    int select = jList.getSelectedIndex();
                                    if (select < 0) {
                                        home.showNotification("You did not select a connection to remove");
                                        return;
                                    }
                                    Connection connection = model.getConnections().get(select);
                                    model.removeConnection(connection);
                                    frame.setVisible(false);
                                    home.showNotification("Connection " + connection.getTrigger().getId() + " --> " + connection.getAction().getId() + " removed");
                                }
                            });
                            frame.add(jb, BorderLayout.SOUTH);
                            frame.setMinimumSize(new Dimension(200, 200));
                            frame.setVisible(true);
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
            case "keyConnect":
                removeListeners();
                home.showNotification("Press the key you wish to become a trigger");
                boardPanel.requestFocus();
                boardPanel.addKeyListener(new KeyListener() {
                    KeyConnection.KeyStatus status = null;
                    @Override
                    public void keyTyped(KeyEvent e) {
                        JFrame frame = new JFrame();
                        Object stringArray[] = { "Pressed", "Released" };
                        int response = JOptionPane.showOptionDialog(frame, "Would you like the trigger to be when the key is pressed or released?", "Select an Option",
                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,   stringArray,
                                stringArray[0]);
                        if (response == JOptionPane.NO_OPTION) {
                            status = KeyConnection.KeyStatus.UP;
                        } else if (response == JOptionPane.YES_OPTION) {
                            System.out.println("Yes button clicked");
                            status = KeyConnection.KeyStatus.DOWN;
                        }
                        char pressedChar = e.getKeyChar();
                        int pressed = KeyEvent.getExtendedKeyCodeForChar(pressedChar);
                            home.showNotification("Click the gizmo you wish to connect to the key trigger");
                            boardPanel.addMouseListener(new MouseListener() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    IGizmo action;
                                    x = e.getX()/boardPanel.getTileSize();
                                    y = e.getY()/boardPanel.getTileSize();
                                    for (IGizmo gizmo:model.getGizmos()){
                                        for (List<Integer> list:gizmo.getOccupiedSpace()) {
                                            if (x == list.get(0) && y == list.get(1)){
                                                action = gizmo;
                                                home.showNotification("Click the gizmo that you want to connect to");
                                                model.addKeyConnection(new KeyConnection(action, pressed, status));
                                                home.showNotification("Connection made between '" + KeyEvent.getKeyText(pressed) + "' and " + action.getId());
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
                        }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                });
                break;
            case "keyDisconnect":
                removeListeners();
                home.showNotification("Click the gizmo that you wish to remove a trigger for");
                boardPanel.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        IGizmo selected;
                        boolean clicked = false;
                        x = e.getX() / boardPanel.getTileSize();
                        y = e.getY() / boardPanel.getTileSize();
                        selected = getOccupyingGizmo(x, y);
                        if (selected != null){
                            home.showNotification("Clicked");
                            clicked = true;
                        }
                        if (clicked) {
                            if(model.getSpecificKeyConnections(selected).isEmpty()){
                                home.showNotification("There are no connections to this gizmo");
                                return;
                            }
                            home.showNotification("Select the connection you wish to delete");
                            JFrame frame = new JFrame();
                            frame.setTitle("Select a connection to remove");
                            DefaultListModel<String> triggers = new DefaultListModel<>();
                            for (KeyConnection connection:model.getSpecificKeyConnections(selected)) {
                                String statement = KeyEvent.getKeyText(connection.getKey()) + " --> " + connection.getAction().getId();
                                triggers.addElement(statement);
                            }
                            JList<String> jList = new JList<>(triggers);
                            JScrollPane scrollPane = new JScrollPane(jList);
                            frame.add(scrollPane, BorderLayout.CENTER);
                            frame.add(jList);
                            JButton jb = new JButton("Select");
                            jb.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    int select = jList.getSelectedIndex();
                                    if (select < 0) {
                                        home.showNotification("You did not select a connection to remove");
                                        return;
                                    }
                                    KeyConnection connection = model.getKeyConnections().get(select);
                                    model.removeKeyConnection(connection);
                                    frame.setVisible(false);
                                    home.showNotification("Connection " + KeyEvent.getKeyText(connection.getKey()) + "->" + connection.getAction().getId() + " removed");
                                }
                            });
                            frame.add(jb, BorderLayout.SOUTH);
                            frame.setMinimumSize(new Dimension(200, 200));
                            frame.setVisible(true);
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
            case "friction":
                double newFriction = home.getBuildModePanel().getFriction();
                model.setFriction(newFriction/10);
                System.out.println("Gravity changed to " + newFriction/10);
                break;
            case "gravity":
                int newGravity = home.getBuildModePanel().getGravity();
                model.setGravity(newGravity);
                System.out.println("Gravity changed to " + newGravity/10);
                break;
        }
    }

    private boolean isOccupied(int xpos, int ypos) {
        for (IGizmo gizmo:model.getGizmos()){
            for (List<Integer> list:gizmo.getOccupiedSpace()) {
                if ((xpos == list.get(0) && ypos == list.get(1))){
                    home.showNotification("That space is occupied, please click another");
                    return true;
                }
            }
        }
        return false;
    }

    public IGizmo getOccupyingGizmo(int xpos, int ypos){
            for (IGizmo gizmo:model.getGizmos()){
                for (List<Integer> list:gizmo.getOccupiedSpace()) {
                    if (xpos == list.get(0) && ypos == list.get(1)){
                        return gizmo;
                    }
                }
            }
        return null;
    }

    public void removeListeners(){
        for( MouseListener ml : boardPanel.getMouseListeners()) {
            boardPanel.removeMouseListener(ml);
        }
        for(MouseMotionListener mm: boardPanel.getMouseMotionListeners()){
            boardPanel.removeMouseMotionListener(mm);
        }
        for(KeyListener kl:boardPanel.getKeyListeners()){
            boardPanel.removeKeyListener(kl);
        }
    }
}
