package View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class BuildModePanel extends JPanel {

    private JPanel build;
    private JPanel gizmoAndBall;
    private JPanel editGizmo;
    private JPanel addGizmo;
    private JPanel ball;
    private JPanel velocities;

    public BuildModePanel(){
        init();
    }

    public void init(){
        //IGizmo adding panel
        addGizmo = new JPanel(new GridLayout(2, 3));

        //IGizmo adding button dimensions
        Dimension addGizmoDim = new Dimension(100, 70);

        //Add gizmo button declarations
        JButton square = new JButton();
        square.setText("Square");
        square.setPreferredSize(addGizmoDim);
        JButton triangle = new JButton();
        triangle.setText("Triangle");
        triangle.setPreferredSize(addGizmoDim);
        JButton circle = new JButton();
        circle.setText("Circle");
        circle.setPreferredSize(addGizmoDim);
        JButton lFlipper = new JButton();
        lFlipper.setText("<html>Left<br/>Flipper</html>");
        lFlipper.setPreferredSize(addGizmoDim);
        JButton rFlipper = new JButton();
        rFlipper.setText("<html>Right<br/>Flipper</html>");
        rFlipper.setPreferredSize(addGizmoDim);
        JButton absorber = new JButton();
        absorber.setText("Absorber");
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
        JButton test = new JButton();
        Dimension ballButtonSize = new Dimension(80, 80);
        test.setPreferredSize(ballButtonSize);
        test.setText("<html>Add<br/>Ball</html>");
        ball = new JPanel(new BorderLayout());
        ball.add(test, BorderLayout.LINE_START);
        ball.add(velocities, BorderLayout.CENTER);

        //IGizmo and Ball panels together
        gizmoAndBall = new JPanel(new BorderLayout());
        gizmoAndBall.add(addGizmo, BorderLayout.PAGE_START);
        gizmoAndBall.add(ball, BorderLayout.CENTER);

        //Edit gizmo panel
        editGizmo = new JPanel(new GridLayout(4, 2));
        Dimension editGizmoButton = new Dimension(20, 70);

        //Edit gizmo button declarations
        JButton move = new JButton();
        move.setText("Move");
        move.setPreferredSize(editGizmoButton);
        JButton rotate = new JButton();
        rotate.setText("Rotate");
        rotate.setPreferredSize(editGizmoButton);
        JButton delete = new JButton();
        delete.setText("Delete");
        delete.setPreferredSize(editGizmoButton);
        JButton clear = new JButton();
        clear.setText("Clear");
        clear.setPreferredSize(editGizmoButton);
        JButton connect = new JButton();
        connect.setText("Connect");
        connect.setPreferredSize(editGizmoButton);
        JButton disconnect = new JButton();
        disconnect.setText("Disconnect");
        disconnect.setPreferredSize(editGizmoButton);
        JButton keyConnect = new JButton();
        keyConnect.setText("<html>Keyboard<br/>Connect</html>");
        keyConnect.setPreferredSize(editGizmoButton);
        JButton keyDisconnect = new JButton();
        keyDisconnect.setText("<html>Keyboard<br/>Disconnect</html>");
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
}
