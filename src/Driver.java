import Controller.OptionPanelController;
import Model.LoadBoardFromFile;
import View.*;
import Model.Model;
import Model.SaveBoardToFile;


public class Driver {

    public static void main(String[] args) {
        Model m = new Model();

        try{
            LoadBoardFromFile.readFromFile("src/Model/inputFile.txt", m);
        }catch (Exception ex){
            System.out.println("cannot save file");
        }

        try{
            SaveBoardToFile.saveToFile("src/Model/outputFile.txt", m);
        }catch (Exception ex){
            System.out.println("cannot save file");
        }

        OptionsPanel optionsPanel = new OptionsPanel();
        RunModePanel playModePanel = new RunModePanel(m);
        BoardPanel boardPanel = new BoardPanel(m);
        NotificationPanel notificationPanel = new NotificationPanel();

        HomeFrame homeFrame = new HomeFrame(playModePanel, optionsPanel, boardPanel, notificationPanel,m);

        OptionPanelController o = new OptionPanelController(optionsPanel, homeFrame);


    }
}
