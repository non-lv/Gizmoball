package Controller;

import View.HomeFrame;
import View.OptionsPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionPanelController implements ActionListener {
    
    private final OptionsPanel panel;
    private final HomeFrame home;

    public OptionPanelController(OptionsPanel panel, HomeFrame home){
        this.panel = panel;
        this.home = home;
        panel.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "switchToBuild":
                System.out.println("swap to build");
                home.swapToBuild();
                break;
            case "switchToRun":
                System.out.println("swap to run");
                home.swapToRun();
                break;
            case "Save":
                break;
            case "Open":
                break;
            case "Quit":
                if(JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure you want to quit?",
                        "Gizmoball",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
                final JOptionPane quitPane = new JOptionPane("Do you want to quit?\nBe sure you have saved!", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
                break;
        }
    }

}
