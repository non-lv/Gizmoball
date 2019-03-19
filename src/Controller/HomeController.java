package Controller;

import Model.Model;
import View.*;

public class HomeController {

    private RunModePanel runModePanel;
    private BuildModePanel buildModePanel;
    private OptionsPanel optionsPanel;
    private BoardPanel boardPanel;
    private NotificationPanel notificationPanel;

    public HomeController(Model m) {
        boardPanel = new BoardPanel(m, false);

        runModePanel = new RunModePanel(m);
        RunModeController runModeController = new RunModeController(m, runModePanel);
        runModePanel.addActionListeners(runModeController);

        buildModePanel = new BuildModePanel();
        BuildModeController buildModeController = new BuildModeController(m, buildModePanel, boardPanel);
        buildModePanel.addActionListeners(buildModeController);

        optionsPanel = new OptionsPanel();
        OptionPanelController optionPanelController = new OptionPanelController(optionsPanel, m);
        optionsPanel.addActionListeners(optionPanelController);

        notificationPanel = new NotificationPanel();

        HomeFrame home = new HomeFrame(m, runModePanel, buildModePanel, optionsPanel, boardPanel, notificationPanel);

        optionPanelController.setHomeFrame(home);
        buildModeController.setHomeFrame(home);
        runModeController.setHome(home);

        boardPanel = new BoardPanel(m, false);
        notificationPanel = new NotificationPanel();
    }
}
