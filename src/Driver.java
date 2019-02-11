import Model.LoadBoardFromFile;

public class Driver {

    public static void main(String[] args) {

        OptionsPanel optionsPanel = new OptionsPanel();
        RunModePanel playModePanel = new RunModePanel();
        BoardPanel boardPanel = new BoardPanel();
        BuildModePanel test = new BuildModePanel();
    //    test.init();
        NotificationPanel notificationPanel = new NotificationPanel();
//
        HomeFrame homeFrame = new HomeFrame(test, optionsPanel, boardPanel, notificationPanel);
        homeFrame.init();

        try{
            LoadBoardFromFile.readFromFile("inputFile.txt");


        } catch (Exception ex){

        }


    }
}
