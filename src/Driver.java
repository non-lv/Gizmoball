import Controller.OptionPanelController;
import Model.FlipperGizmo;
import View.*;
import Model.Model;


public class Driver {

    public static void main(String[] args) {
        Model m = new Model();

        m.addGizmo(new FlipperGizmo("F1", 9,9, true));
        m.addGizmo(new FlipperGizmo("F1", 11,9, false));



        OptionsPanel optionsPanel = new OptionsPanel();
        RunModePanel playModePanel = new RunModePanel(m);
        BoardPanel boardPanel = new BoardPanel(m);
        NotificationPanel notificationPanel = new NotificationPanel();

        HomeFrame homeFrame = new HomeFrame(playModePanel, optionsPanel, boardPanel, notificationPanel,m);

        OptionPanelController o = new OptionPanelController(optionsPanel, homeFrame);


    }
}
