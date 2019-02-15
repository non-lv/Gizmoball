package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class OptionsPanel extends JPanel {

    private JPanel top;
    private JButton switchToBuild;
    private JButton switchToRun;
    private JButton save;
    private JButton open;
    private JButton quit;
    private JPanel left;
    private JPanel right;

    public OptionsPanel() {
        init();
    }

    public void init() {

        top = new JPanel(new GridLayout(1, 4));
        switchToBuild = new JButton("Build Mode");
        switchToBuild.setActionCommand("switchToBuild");

        switchToRun = new JButton("Run Mode");
        switchToRun.setActionCommand("switchToRun");

        save = new JButton("Save");
        save.setActionCommand("Save");

        open = new JButton("Open");
        open.setActionCommand("Open");

        quit = new JButton("Quit");
        quit.setActionCommand("Quit");

        left = new JPanel();
        right = new JPanel();
        top.setPreferredSize(new Dimension(500, 50));

        top.add(switchToBuild);
        top.add(save);
        top.add(open);
        top.add(quit);
        this.add(top);
    }

    public void addActionListener(ActionListener listener){
        switchToBuild.addActionListener(listener);
        switchToRun.addActionListener(listener);
        save.addActionListener(listener);
        open.addActionListener(listener);
        quit.addActionListener(listener);
    }
}
