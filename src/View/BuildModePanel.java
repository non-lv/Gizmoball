package View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class BuildModePanel extends JPanel implements IView{

    private JPanel build;
    private JPanel gizmoAndBall;
    private JPanel editGizmo;
    private JPanel addGizmo;
    private JPanel ballPanel;
    private JPanel velocities;

    private JButton square;
    private JButton triangle;
    private JButton circle;
    private JButton rFlipper;
    private JButton lFlipper;
    private JButton absorber;
    private JButton ball;
    private JButton move;
    private JButton rotate;
    private JButton delete;
    private JButton clear;
    private JButton connect;
    private JButton disconnect;
    private JButton keyConnect;
    private JButton keyDisconnect;
    private JButton friction;
    private JButton gravity;
    private JPanel FrictionAndGravity;
    private JTextArea frictionText;
    private JTextArea gravityText;


    public BuildModePanel(){
        init();
    }

    private void init(){
        //IGizmo adding panel
        addGizmo = new JPanel(new GridLayout(2, 3));

        //IGizmo adding button dimensions
        Dimension addGizmoDim = new Dimension(100, 70);

        //Add gizmo button declarations
        square = new JButton();
        square.setText("Square");
        square.setActionCommand("Square");
        square.setPreferredSize(addGizmoDim);

        triangle = new JButton();
        triangle.setText("Triangle");
        triangle.setActionCommand("Triangle");
        triangle.setPreferredSize(addGizmoDim);

        circle = new JButton();
        circle.setText("Circle");
        circle.setActionCommand("Circle");
        circle.setPreferredSize(addGizmoDim);

        lFlipper = new JButton();
        lFlipper.setText("<html>Left<br/>Flipper</html>");
        lFlipper.setActionCommand("lFlipper");
        lFlipper.setPreferredSize(addGizmoDim);

        rFlipper = new JButton();
        rFlipper.setText("<html>Right<br/>Flipper</html>");
        rFlipper.setPreferredSize(addGizmoDim);
        rFlipper.setActionCommand("rFlipper");

        absorber = new JButton();
        absorber.setText("Absorber");
        absorber.setActionCommand("Absorber");
        absorber.setPreferredSize(addGizmoDim);

        addGizmo.add(square);
        addGizmo.add(triangle);
        addGizmo.add(circle);
        addGizmo.add(lFlipper);
        addGizmo.add(rFlipper);
        addGizmo.add(absorber);

        JTextArea x = new JTextArea();
        JTextArea y = new JTextArea();

        //Border for text input
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        x.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        y.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        //Velocity input
        velocities = new JPanel(new GridLayout(0, 1));
        velocities.add(x);
        velocities.add(y);

        //Ball text windows and button
        ball = new JButton();
        ball.setActionCommand("ball");
        Dimension ballButtonSize = new Dimension(80, 80);
        ball.setPreferredSize(ballButtonSize);
        ball.setText("<html>Add<br/>Ball</html>");
        ballPanel = new JPanel(new BorderLayout());
        ballPanel.add(ball, BorderLayout.LINE_START);
        ballPanel.add(velocities, BorderLayout.CENTER);

        //Friction and Gravity
        friction = new JButton("Set Fiction");
        friction.setActionCommand("friction");
        gravity = new JButton("Set Gravity");
        gravity.setActionCommand("gravity");
        frictionText = new JTextArea();
        frictionText.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        gravityText = new JTextArea();
        gravityText.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        FrictionAndGravity = new JPanel(new GridLayout(2, 2));
        FrictionAndGravity.add(friction);
        FrictionAndGravity.add(frictionText);
        FrictionAndGravity.add(gravity);
        FrictionAndGravity.add(gravityText);

        //Gizmo and Ball panels together
        gizmoAndBall = new JPanel(new BorderLayout());
        gizmoAndBall.add(addGizmo, BorderLayout.PAGE_START);
        gizmoAndBall.add(ballPanel, BorderLayout.CENTER);
        gizmoAndBall.add(FrictionAndGravity, BorderLayout.PAGE_END);

        //Edit gizmo panel
        editGizmo = new JPanel(new GridLayout(4, 2));
        Dimension editGizmoButton = new Dimension(20, 70);

        //Edit gizmo button declarations
        move = new JButton();
        move.setText("Move");
        move.setActionCommand("Move");
        move.setPreferredSize(editGizmoButton);

        rotate = new JButton();
        rotate.setText("Rotate");
        rotate.setActionCommand("Rotate");
        rotate.setPreferredSize(editGizmoButton);

        delete = new JButton();
        delete.setText("Delete");
        delete.setActionCommand("Delete");
        delete.setPreferredSize(editGizmoButton);

        clear = new JButton();
        clear.setText("Clear");
        clear.setActionCommand("Clear");
        clear.setPreferredSize(editGizmoButton);

        connect = new JButton();
        connect.setText("Connect");
        connect.setActionCommand("Connect");
        connect.setPreferredSize(editGizmoButton);

        disconnect = new JButton();
        disconnect.setText("Disconnect");
        disconnect.setActionCommand("Disconnect");
        disconnect.setPreferredSize(editGizmoButton);

        keyConnect = new JButton();
        keyConnect.setText("<html>Keyboard<br/>Connect</html>");
        keyConnect.setActionCommand("keyConnect");
        keyConnect.setPreferredSize(editGizmoButton);

        keyDisconnect = new JButton();
        keyDisconnect.setText("<html>Keyboard<br/>Disconnect</html>");
        keyDisconnect.setActionCommand("keyDisconnect");
        keyDisconnect.setPreferredSize(editGizmoButton);

        //Adding edit gizmo buttons
        editGizmo.add(move);
        editGizmo.add(rotate);
        editGizmo.add(delete);
        editGizmo.add(clear);
        editGizmo.add(connect);
        editGizmo.add(disconnect);
        editGizmo.add(keyConnect);
        editGizmo.add(keyDisconnect);

        //Whole panel with all sub-panels
        build = new JPanel(new BorderLayout());
        build.add(gizmoAndBall, BorderLayout.PAGE_START);
        build.add(editGizmo, BorderLayout.CENTER);

        this.add(build);

    }

    public JTextArea getGravityText(){
        return gravityText;
    }

    public JTextArea getFrictionText(){
        return frictionText;
    }

    @Override
    public void addActionListeners(ActionListener actionListener){
        //Gizmo Buttons
        square.addActionListener(actionListener);
        triangle.addActionListener(actionListener);
        circle.addActionListener(actionListener);
        lFlipper.addActionListener(actionListener);
        rFlipper.addActionListener(actionListener);
        absorber.addActionListener(actionListener);
        ball.addActionListener(actionListener);

        //Edit Gizmos buttons
        move.addActionListener(actionListener);
        rotate.addActionListener(actionListener);
        delete.addActionListener(actionListener);
        clear.addActionListener(actionListener);
        connect.addActionListener(actionListener);
        disconnect.addActionListener(actionListener);
        keyConnect.addActionListener(actionListener);
        keyDisconnect.addActionListener(actionListener);

        friction.addActionListener(actionListener);
        gravity.addActionListener(actionListener);
    }


}
