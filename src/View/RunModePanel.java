package View;

import Controller.RunModeController;
import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Map;

public class RunModePanel extends JPanel implements IView{

    private JPanel box;
    private JButton startStop;
    private JButton tick;
    private JButton reload;
    private ActionListener runModeController;
    private Model model;
    private JScrollPane triggers;
    private JTextArea textArea;


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
        for (Map.Entry<IGizmo, Connection> connectionEntry:model.getConnections().entrySet()){
            IGizmo key = connectionEntry.getKey();
            Connection value = connectionEntry.getValue();

            textArea.append("\n" + key.getId() + " -> " + value.getAction().getId());
        }
        box.add(triggers);
    }

    @Override
    public void addActionListeners(ActionListener actionListener) {
        startStop.addActionListener(actionListener);
        tick.addActionListener(actionListener);
        reload.addActionListener(actionListener);
    }
}
