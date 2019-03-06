package View;

import Controller.BuildModeController;
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

public class HomeFrame {

    private JFrame window;
    private JPanel border;
    private JPanel menuPanelLeft;
    private JPanel leftAlignment;
    private OptionsPanel optionsPanelTop;
    private JPanel boardAndNotificationBarContainer;
    private NotificationPanel notificationPanel;
    private BoardPanel boardPanel;
    private JPanel boardContainer;
    private RunModePanel runModePanel;
    private BuildModePanel buildModePanel;
    private KeyPressedController k;
    private Model m;

    public HomeFrame(Model m, RunModePanel runModePanel, BuildModePanel buildModePanel, OptionsPanel optionsPanel, BoardPanel boardPanel, NotificationPanel notificationPanel) {
        this.runModePanel = runModePanel;
        this.buildModePanel = buildModePanel;
        this.m = m;
        this.menuPanelLeft = new JPanel();
        menuPanelLeft.add(runModePanel);
        this.optionsPanelTop = optionsPanel;
        this.boardPanel = boardPanel;
        this.notificationPanel = notificationPanel;
        k = new KeyPressedController(this.m);

        init();
    }


    private void init() {

        window = new JFrame("Gizmoball");
        border = new JPanel(new BorderLayout());
        leftAlignment = new JPanel(new FlowLayout(FlowLayout.LEFT));
        boardAndNotificationBarContainer = new JPanel(new BorderLayout());
        boardContainer = new JPanel();

        border.add(menuPanelLeft, BorderLayout.LINE_START);

        leftAlignment.setPreferredSize(new Dimension(700, 80));
        leftAlignment.add(optionsPanelTop);

        border.add(leftAlignment, BorderLayout.PAGE_START);

        boardContainer.add(boardPanel);
        boardAndNotificationBarContainer.add(boardContainer, BorderLayout.CENTER);
        boardAndNotificationBarContainer.add(notificationPanel, BorderLayout.PAGE_END);

        border.add(boardAndNotificationBarContainer, BorderLayout.CENTER);

        window.add(border);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        window.addKeyListener(k);
        window.setFocusable(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void showNotification(String notification){
        boardAndNotificationBarContainer.remove(notificationPanel);
        notificationPanel = new NotificationPanel();
        notificationPanel.setText(notification);
        boardAndNotificationBarContainer.add(notificationPanel, BorderLayout.PAGE_END);

        window.pack();
        window.revalidate();
    }

    public void swapToBuild() {
        menuPanelLeft.removeAll();
        boardPanel.addGrid();
        menuPanelLeft.add(buildModePanel);
        optionsPanelTop.buildMode();

        window.pack();
        window.revalidate();
    }

    public void swapToRun() {
        menuPanelLeft.removeAll();
        boardPanel.removeGrid();
        menuPanelLeft.add(runModePanel);

        optionsPanelTop.runMode();

        window.pack();
        window.revalidate();
    }

    public JFrame getWindow(){
        return window;
    }

    public JPanel getBoardPanel(){
        return boardPanel;
    }

    public BuildModePanel getBuildModePanel(){
        return buildModePanel;
    }

}
