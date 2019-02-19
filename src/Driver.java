import Controller.OptionPanelController;
import Model.LoadBoardFromFile;
import View.*;
import Model.Model;
import Model.SaveBoardToFile;


public class Driver {

    public static void main(String[] args) {
        Model m = new Model();



        OptionsPanel optionsPanel = new OptionsPanel();
        RunModePanel playModePanel = new RunModePanel(m);
        BoardPanel boardPanel = new BoardPanel(m);
        NotificationPanel notificationPanel = new NotificationPanel();

        HomeFrame homeFrame = new HomeFrame(playModePanel, optionsPanel, boardPanel, notificationPanel,m);

 //       OptionPanelController o = new OptionPanelController(optionsPanel, homeFrame);


    }
}
