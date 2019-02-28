package Controller;

import Model.Model;
import View.*;

public class HomeController{

    private RunModePanel runModePanel;
    private BuildModePanel buildModePanel;
    private OptionsPanel optionsPanel;
    private BoardPanel boardPanel;
    private NotificationPanel notificationPanel;


    public HomeController(Model m){

        runModePanel = new RunModePanel(m);
        runModePanel.addActionListeners(new RunModeController(m));

        buildModePanel = new BuildModePanel();
        buildModePanel.addActionListeners(new BuildModeController(buildModePanel));

        optionsPanel = new OptionsPanel();
        OptionPanelController optionPanelController = new OptionPanelController(optionsPanel, m);
        optionsPanel.addActionListeners(optionPanelController);

        boardPanel = new BoardPanel(m);

        notificationPanel = new NotificationPanel();

        HomeFrame home = new HomeFrame(m, runModePanel, optionsPanel, boardPanel, notificationPanel);

        optionPanelController.setHomeFrame(home);

        boardPanel = new BoardPanel(m);
        notificationPanel = new NotificationPanel();
    }

}
