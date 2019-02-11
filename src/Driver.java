import Model.LoadBoardFromFile;
import View.*;
import Model.Model;
import Model.CircleGizmo;
import Model.SquareGizmo;
import Model.TriangleGizmo;

public class Driver {

    public static void main(String[] args) {
        Model m = new Model();

        OptionsPanel optionsPanel = new OptionsPanel();
        RunModePanel playModePanel = new RunModePanel();
        BoardPanel boardPanel = new BoardPanel(m);
        NotificationPanel notificationPanel = new NotificationPanel();

        HomeFrame homeFrame = new HomeFrame(playModePanel, optionsPanel, boardPanel, notificationPanel);

        try{
            LoadBoardFromFile.readFromFile("inputFile.txt");


        } catch (Exception ex){

        }

        m.addCircle(new CircleGizmo(15,10));
        m.addCircle(new CircleGizmo(18,18));
        m.addCircle(new CircleGizmo(2, 2));
        m.addSquare(new SquareGizmo(5,5));
        m.addTriangle(new TriangleGizmo(3,3));

    }
}