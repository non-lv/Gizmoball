package View;

import javax.swing.*;
import java.awt.*;

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
        switchToRun = new JButton("Run Mode");
        save = new JButton("Save");
        open = new JButton("Open");
        quit = new JButton("Quit");
        left = new JPanel();
        right = new JPanel();

        top.setPreferredSize(new Dimension(500, 50));
        top.add(switchToBuild);
        top.add(save);
        top.add(open);
        top.add(quit);

        this.add(top);
    }
}
