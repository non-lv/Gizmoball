package Controller;

import View.BuildModePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuildModeController implements ActionListener {

    private final BuildModePanel buildModePanel;

    public BuildModeController(BuildModePanel panel){
        this.buildModePanel = panel;
        panel.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Square":
                break;
            case "Triangle":
                break;
            case "Circle":
                break;
            case "lFlipper":
                break;
            case "rFlipper":
                break;
            case "Absorber":
                break;
            case "Move":
                break;
            case "Rotate":
                break;
            case "Delete":
                break;
            case "Clear":
                break;
            case "Connect":
                break;
            case "Disconnect":
                break;
            case "keyConnect":
                break;
            case "keyDisconnect":
                break;
        }
    }
}
