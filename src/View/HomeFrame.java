package View;

import Controller.KeyPressedController;
import Controller.OptionPanelController;
import Controller.RunModeController;

import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

import Model.Model;
import Model.Ball;
import Model.AbsorberGizmo;

public class HomeFrame implements Observer {


    public JPanel runMode;
    private JFrame window;
    private JPanel border;
    private JPanel menuPanelLeft;
    private JPanel leftAlignment;
    public JPanel optionsPanelTop;
    private JPanel boardAndNotificationBarContainer;
    private JPanel notificationPanel;
    private JPanel boardPanel;
    public JPanel buildMode;
    private JPanel boardContainer;
    private KeyPressedController k;
    private Model m;

    public HomeFrame(JPanel menuPanelLeft, JPanel optionsPanelTop, JPanel boardPanel, JPanel notificationPanel, Model m) {
        this.menuPanelLeft = menuPanelLeft;
        this.optionsPanelTop = optionsPanelTop;
        this.boardPanel = boardPanel;
        this.notificationPanel = notificationPanel;
        this.m = m;
        this.k = new KeyPressedController(this.m);
        init();
    }


    public void init() {
        window = new JFrame("Gizmoball");
        border = new JPanel(new BorderLayout());
        leftAlignment = new JPanel(new FlowLayout(FlowLayout.LEFT));
        boardAndNotificationBarContainer = new JPanel(new BorderLayout());
        boardContainer = new JPanel();

        border.add(menuPanelLeft, BorderLayout.LINE_START);

        //leftAlignment.setPreferredSize(new Dimension(700, 80));
        //leftAlignment.add(optionsPanelTop);

        //border.add(leftAlignment, BorderLayout.PAGE_START);

        boardContainer.add(boardPanel);
        boardAndNotificationBarContainer.add(boardContainer, BorderLayout.CENTER);
        //boardAndNotificationBarContainer.add(notificationPanel, BorderLayout.PAGE_END);

        border.add(boardAndNotificationBarContainer, BorderLayout.CENTER);

        window.add(border);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        window.addKeyListener(k);
        window.setFocusable(true);
    }

    public void swapToBuild() {
        border.remove(menuPanelLeft);
        menuPanelLeft.add(new BuildModePanel());
        border.add(menuPanelLeft, BorderLayout.LINE_START);
    }

    public void swapToRun() {
        border.remove(buildMode);
        border.add(runMode, BorderLayout.LINE_START);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
