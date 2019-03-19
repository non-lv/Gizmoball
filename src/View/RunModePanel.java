package View;

import Controller.RunModeController;
import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Map;

public class RunModePanel extends JPanel implements IView {

    private JPanel box;
    private JButton startStop;
    private JButton tick;
    private JButton reload;
    private Model model;
    private JScrollPane triggers;
    private JTextArea textArea;


    public RunModePanel(Model m) {
        model = m;
        init();
    }

    private void init() {
        box = new JPanel(new GridLayout(4, 1));
        startStop = new JButton("Start");
        tick = new JButton("Tick");
        reload = new JButton("Reload");
        textArea = new JTextArea();
        textArea.setEditable(false);
        triggers = new JScrollPane(textArea);

        box.setPreferredSize(new Dimension(150, 500));

        box.add(startStop);
        box.add(tick);
        box.add(reload);
        refreshTriggers();

        this.add(box);

        startStop.setFocusable(false);
        tick.setFocusable(false);
        reload.setFocusable(false);
        triggers.setFocusable(false);
    }

    public void refreshTriggers() {
        System.out.println("i am refreshded");
        box.remove(triggers);
        textArea.setText(null);
        textArea.append("Triggers");
        for (Connection connectionEntry : model.getConnections()) {
            IGizmo key = connectionEntry.getTrigger();
            Connection value = connectionEntry;
            textArea.append("\n" + key.getId() + " -> " + value.getAction().getId());
        }
        box.add(triggers);
    }

    public void setStart() {
        startStop.setText("Start");
    }

    public void setStop() {
        startStop.setText("Stop");
    }

    @Override
    public void addActionListeners(ActionListener actionListener) {
        startStop.addActionListener(actionListener);
        tick.addActionListener(actionListener);
        reload.addActionListener(actionListener);
    }
}
