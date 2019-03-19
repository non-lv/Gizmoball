package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class OptionsPanel extends JMenuBar implements IView {

    private JMenu menu;
    private JMenuItem switchToBuild;
    private JMenuItem switchToRun;
    private JMenuItem save;
    private JMenuItem open;
    private JMenuItem quit;

    public OptionsPanel() {
        init();
    }

    private void init(){
        menu = new JMenu("File");

        switchToBuild = new JMenuItem("Build Mode");
        switchToBuild.setActionCommand("switchToBuild");

        switchToRun = new JMenuItem("Run Mode");
        switchToRun.setActionCommand("switchToRun");

        save = new JMenuItem("Save");
        save.setActionCommand("Save");

        open = new JMenuItem("Open");
        open.setActionCommand("Open");

        quit = new JMenuItem("Quit");
        quit.setActionCommand("Quit");

        switchToBuild.setFocusable(false);
        switchToRun.setFocusable(false);
        save.setFocusable(false);
        open.setFocusable(false);
        quit.setFocusable(false);

        menu.add(switchToBuild);
        menu.add(switchToRun);
        menu.add(save);
        menu.add(open);
        menu.add(quit);

        this.add(menu);
    }

    @Override
    public void addActionListeners(ActionListener listener){
        switchToBuild.addActionListener(listener);
        switchToRun.addActionListener(listener);
        save.addActionListener(listener);
        open.addActionListener(listener);
        quit.addActionListener(listener);
    }

    void buildMode(){
        menu.remove(0);
        menu.add(switchToRun, 0);
        menu.revalidate();
    }

    void runMode(){
        menu.remove(0);
        menu.add(switchToBuild, 0);
        menu.revalidate();
    }

}
