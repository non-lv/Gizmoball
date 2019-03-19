package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Hashtable;

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
//    private JTextArea xV;
    JSlider fric;
    JSlider grav;
    JSlider xV;
    JSlider yV;


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
        square.setBackground(Color.WHITE);
        square.setIcon(new ImageIcon(getClass().getResource("/square.png")));
        square.setText("Square");
        square.setVerticalTextPosition(SwingConstants.BOTTOM);
        square.setHorizontalTextPosition(SwingConstants.CENTER);
        square.setActionCommand("Square");
        square.setPreferredSize(addGizmoDim);



        triangle = new JButton();
        triangle.setBackground(Color.WHITE);
        triangle.setIcon(new ImageIcon(getClass().getResource("/triangle.png")));
        triangle.setText("Triangle");
        triangle.setVerticalTextPosition(SwingConstants.BOTTOM);
        triangle.setHorizontalTextPosition(SwingConstants.CENTER);
        triangle.setActionCommand("Triangle");
        triangle.setPreferredSize(addGizmoDim);

        circle = new JButton();
        circle.setBackground(Color.WHITE);
        circle.setIcon(new ImageIcon(getClass().getResource("/circle.png")));
        circle.setText("Circle");
        circle.setVerticalTextPosition(SwingConstants.BOTTOM);
        circle.setHorizontalTextPosition(SwingConstants.CENTER);
        circle.setActionCommand("Circle");
        circle.setPreferredSize(addGizmoDim);

        lFlipper = new JButton();
        lFlipper.setBackground(Color.WHITE);
        lFlipper.setIcon(new ImageIcon(getClass().getResource("/leftFlipper.png")));
        lFlipper.setText("Left Flipper");
        lFlipper.setVerticalTextPosition(SwingConstants.BOTTOM);
        lFlipper.setHorizontalTextPosition(SwingConstants.CENTER);
        lFlipper.setActionCommand("lFlipper");
        lFlipper.setPreferredSize(addGizmoDim);

        rFlipper = new JButton();
        rFlipper.setBackground(Color.WHITE);
        rFlipper.setIcon(new ImageIcon(getClass().getResource("/rightFlipper.png")));
        rFlipper.setText("Right Flipper");
        rFlipper.setVerticalTextPosition(SwingConstants.BOTTOM);
        rFlipper.setHorizontalTextPosition(SwingConstants.CENTER);
        rFlipper.setPreferredSize(addGizmoDim);
        rFlipper.setActionCommand("rFlipper");

        absorber = new JButton();
        absorber.setBackground(Color.WHITE);
        absorber.setIcon(new ImageIcon(getClass().getResource("/absorber.png")));
        absorber.setText("Absorber");
        absorber.setVerticalTextPosition(SwingConstants.BOTTOM);
        absorber.setHorizontalTextPosition(SwingConstants.CENTER);
        absorber.setActionCommand("Absorber");
        absorber.setPreferredSize(addGizmoDim);

        addGizmo.add(square);
        addGizmo.add(triangle);
        addGizmo.add(circle);
        addGizmo.add(lFlipper);
        addGizmo.add(rFlipper);
        addGizmo.add(absorber);
        xV = new JSlider(0, 50,1 );
        xV.setMajorTickSpacing(10);
        xV.setMinorTickSpacing(1);
        xV.setPaintTicks(true);
        xV.setPaintLabels(true);

        yV = new JSlider(0, 50,1 );

        yV.setMajorTickSpacing(10);
        yV.setMinorTickSpacing(1);

        yV.setPaintTicks(true);
        yV.setPaintLabels(true);

        //Border for text input
//        Border border = BorderFactory.createLineBorder(Color.BLACK);
//        xV.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
//        yV.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        //Velocity input
        velocities = new JPanel(new GridLayout(2, 2));
        JPanel xvel = new JPanel(new FlowLayout(FlowLayout.CENTER,5,5));
        JPanel yvel = new JPanel(new FlowLayout(FlowLayout.CENTER,5,5));
        JLabel xv = new JLabel("X-Velocity");
        JLabel yv = new JLabel("Y-Velocity");
        xvel.add(xv,BorderLayout.WEST);
        xvel.add(xV,BorderLayout.CENTER);
        yvel.add(yv,BorderLayout.WEST);
        yvel.add(yV,BorderLayout.CENTER);

        velocities.add(xvel,BorderLayout.NORTH);
        velocities.add(yvel,BorderLayout.SOUTH);



        //Ball text windows and button
        ball = new JButton();
        ball.setBackground(Color.WHITE);
        ball.setActionCommand("Ball");
        Dimension ballButtonSize = new Dimension(80, 80);
        ball.setPreferredSize(ballButtonSize);
        ball.setText("<html>Add<br/>Ball</html>");
        ballPanel = new JPanel(new BorderLayout());
        ballPanel.add(ball, BorderLayout.LINE_START);
        ballPanel.add(velocities, BorderLayout.CENTER);

        //Friction and Gravity
        friction = new JButton("Set Fiction");
        friction.setBackground(Color.WHITE);
        friction.setActionCommand("friction");
        fric = new JSlider(0, 10,1 );
        fric.setMajorTickSpacing(1);
        fric.setMinorTickSpacing(1);
        fric.setPaintTicks(true);
        fric.setPaintLabels(true);

        gravity = new JButton("Set Gravity");
        gravity.setBackground(Color.WHITE);
        gravity.setActionCommand("gravity");
        grav = new JSlider(-30, 30,0 );
        grav.setMajorTickSpacing(10);
        grav.setMinorTickSpacing(1);
        grav.setPaintTicks(true);
        grav.setPaintLabels(true);
//        frictionText = new JTextArea();

//        frictionText.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
//        gravityText = new JTextArea();
//        gravityText.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        FrictionAndGravity = new JPanel(new GridLayout(2, 2));
        FrictionAndGravity.add(friction);
        FrictionAndGravity.add(fric);

//        FrictionAndGravity.add(frictionText);
        FrictionAndGravity.add(gravity);
        FrictionAndGravity.add(grav);
//        FrictionAndGravity.add(gravityText);

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
        move.setBackground(Color.WHITE);
        move.setText("Move");
        move.setActionCommand("Move");
        move.setPreferredSize(editGizmoButton);

        rotate = new JButton();
        rotate.setBackground(Color.WHITE);
        rotate.setText("Rotate");
        rotate.setActionCommand("Rotate");
        rotate.setPreferredSize(editGizmoButton);

        delete = new JButton();
        delete.setBackground(Color.WHITE);
        delete.setText("Delete");
        delete.setActionCommand("Delete");
        delete.setPreferredSize(editGizmoButton);

        clear = new JButton();
        clear.setBackground(Color.WHITE);
        clear.setText("Clear");
        clear.setActionCommand("Clear");
        clear.setPreferredSize(editGizmoButton);

        connect = new JButton();
        connect.setBackground(Color.WHITE);
        connect.setText("Connect");
        connect.setActionCommand("Connect");
        connect.setPreferredSize(editGizmoButton);

        disconnect = new JButton();
        disconnect.setBackground(Color.WHITE);
        disconnect.setText("Disconnect");
        disconnect.setActionCommand("Disconnect");
        disconnect.setPreferredSize(editGizmoButton);

        keyConnect = new JButton();
        keyConnect.setBackground(Color.WHITE);
        keyConnect.setText("<html>Keyboard<br/>Connect</html>");
        keyConnect.setActionCommand("keyConnect");
        keyConnect.setPreferredSize(editGizmoButton);

        keyDisconnect = new JButton();
        keyDisconnect.setBackground(Color.WHITE);
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

    public int getGravity(){
        return grav.getValue();
    }

    public int getFriction(){ return fric.getValue(); }

    public int getxV(){ return xV.getValue();}

    public int getyV(){ return yV.getValue();}

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
