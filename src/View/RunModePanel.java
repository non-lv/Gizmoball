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

    private ActionListener runModeController;

    public RunModePanel(Model m) {
        model = m;
        init();
    }

    private void init() {
        box = new JPanel(new GridLayout(4, 1));
        startStop = new JButton();
        startStop.setBackground(Color.WHITE);
        setStart();

        tick = new JButton("Tick");
        tick.setBackground(Color.WHITE);
        tick.setIcon(new ImageIcon(getClass().getResource("/tick.png")));
        tick.setVerticalTextPosition(SwingConstants.BOTTOM);
        tick.setHorizontalTextPosition(SwingConstants.CENTER);


        reload = new JButton("Refresh");
        reload.setBackground(Color.WHITE);
        reload.setIcon(new ImageIcon(getClass().getResource("/reload.png")));
        reload.setVerticalTextPosition(SwingConstants.BOTTOM);
        reload.setHorizontalTextPosition(SwingConstants.CENTER);

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

    public void buildMode() {
        ((RunModeController) runModeController).stopTime();
        setStart();
    }

    public void setStart() {
        startStop.setIcon(new ImageIcon(getClass().getResource("/play.png")));
        startStop.setText("");
    }

    public void setStop() {
        startStop.setIcon(new ImageIcon(getClass().getResource("/pause.png")));
        startStop.setText("");


    }

    @Override
    public void addActionListeners(ActionListener actionListener) {
        runModeController = actionListener;
        startStop.addActionListener(actionListener);
        tick.addActionListener(actionListener);
        reload.addActionListener(actionListener);
    }
}
