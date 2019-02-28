package View;

import Controller.RunModeController;
import Model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RunModePanel extends JPanel implements IView{

    private JPanel box;
    private JButton startStop;
    private JButton tick;
    private JButton reload;
    private ActionListener runModeController;
    private Model model;


    public RunModePanel(Model m) {
        model = m;
        init();
    }

    private void init() {

        runModeController = new RunModeController(model);

        box = new JPanel(new GridLayout(4, 1));
        startStop = new JButton("Start/Stop");
        tick = new JButton("Tick");
        reload = new JButton("Reload");


        box.setPreferredSize(new Dimension(150, 500));

        box.add(startStop);
        box.add(tick);
        box.add(reload);

        this.add(box);

        startStop.setFocusable(false);
        tick.setFocusable(false);
        reload.setFocusable(false);
    }

    @Override
    public void addActionListeners(ActionListener actionListener) {
        startStop.addActionListener(actionListener);
        tick.addActionListener(actionListener);
        reload.addActionListener(actionListener);
    }
}
