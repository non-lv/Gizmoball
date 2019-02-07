import Model.LoadBoardFromFile;
import View.*;

public class Driver {

    public static void main(String[] args) {

//        OptionsPanel optionsPanel = new OptionsPanel();
//        RunModePanel playModePanel = new RunModePanel();
//        BoardPanel boardPanel = new BoardPanel();
//        NotificationPanel notificationPanel = new NotificationPanel();
//
//        HomeFrame homeFrame = new HomeFrame(playModePanel, optionsPanel, boardPanel, notificationPanel);

        try{
            LoadBoardFromFile.readFromFile("inputFile.txt");


        } catch (Exception ex){

        }


    }
}
