package View;

import Controller.RunModeController;
import Model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RunModePanel extends JPanel {

    private JPanel box;
    private JButton startStop;
    private JButton tick;
    private JButton reload;
    private JButton quit;
    private ActionListener runModeController;
    private Model model;


    public RunModePanel(Model m) {
        model = m;
        init();
    }

    public void init() {

        runModeController = new RunModeController(model);

        box = new JPanel(new GridLayout(4, 1));
        startStop = new JButton("Start/Stop");
        tick = new JButton("Tick");
        reload = new JButton("Save");
        quit = new JButton("Load");

        startStop.addActionListener(runModeController);
        tick.addActionListener(runModeController);
        reload.addActionListener(runModeController);
        quit.addActionListener(runModeController);

        box.setPreferredSize(new Dimension(150, 500));

        box.add(startStop);
        box.add(tick);
        box.add(reload);
        box.add(quit);

        this.add(box);

        startStop.setFocusable(false);
        tick.setFocusable(false);
        reload.setFocusable(false);
        quit.setFocusable(false);
    }
}
