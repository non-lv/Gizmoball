import Controller.OptionPanelController;
import Model.LoadBoardFromFile;
import View.*;
import Model.Model;
import Model.SaveBoardToFile;
import Model.*;


public class Driver {

    public static void main(String[] args) {
        Model m = new Model();

        OptionsPanel optionsPanel = new OptionsPanel();
        RunModePanel playModePanel = new RunModePanel(m);
        BoardPanel boardPanel = new BoardPanel(m);
        NotificationPanel notificationPanel = new NotificationPanel();

        HomeFrame homeFrame = new HomeFrame(playModePanel, optionsPanel, boardPanel, notificationPanel,m);

        OptionPanelController o = new OptionPanelController(optionsPanel, homeFrame);

        m.addBall(new Ball("B",1.5,0.5,0,0));
        m.addGizmo(new TriangleGizmo("T1", 1,1, TriangleGizmo.Rotation.BOTTOM_LEFT));

        m.addGizmo(new SquareGizmo("S",0,2));
        m.addGizmo(new SquareGizmo("S",1,2));
        m.addGizmo(new SquareGizmo("S",2,2));
        m.addGizmo(new SquareGizmo("S",3,2));
        m.addGizmo(new SquareGizmo("S",4,2));
        m.addGizmo(new SquareGizmo("S",5,2));
        m.addGizmo(new SquareGizmo("S",6,2));
        m.addGizmo(new SquareGizmo("S",7,2));
        m.addGizmo(new SquareGizmo("S",8,2));
        m.addGizmo(new SquareGizmo("S",13,2));
        m.addGizmo(new SquareGizmo("S",14,2));
        m.addGizmo(new SquareGizmo("S",15,2));
        m.addGizmo(new SquareGizmo("S",16,2));
        m.addGizmo(new SquareGizmo("S",17,2));
        m.addGizmo(new SquareGizmo("S",18,2));

        m.addGizmo(new CircleGizmo("C", 4, 3));
        m.addGizmo(new CircleGizmo("C", 5, 4));
        m.addGizmo(new CircleGizmo("C", 6, 5));
        m.addGizmo(new CircleGizmo("C", 7, 6));
        m.addGizmo(new CircleGizmo("C", 9, 9));
        m.addGizmo(new CircleGizmo("C", 10, 9));
        m.addGizmo(new CircleGizmo("C", 11, 10));
        m.addGizmo(new CircleGizmo("C", 12, 9));
        m.addGizmo(new CircleGizmo("C", 13, 9));
        m.addGizmo(new CircleGizmo("C", 15, 6));
        m.addGizmo(new CircleGizmo("C", 16, 5));
        m.addGizmo(new CircleGizmo("C", 17, 4));
        m.addGizmo(new CircleGizmo("C", 18, 3));

        m.addGizmo(new TriangleGizmo("T", 2, 19, TriangleGizmo.Rotation.BOTTOM_LEFT));
        m.addGizmo(new TriangleGizmo("T", 4, 19, TriangleGizmo.Rotation.TOP_LEFT));
        m.addGizmo(new TriangleGizmo("T", 6, 19, TriangleGizmo.Rotation.BOTTOM_LEFT));
        m.addGizmo(new TriangleGizmo("T", 8, 19, TriangleGizmo.Rotation.TOP_LEFT));
        m.addGizmo(new TriangleGizmo("T", 12, 19, TriangleGizmo.Rotation.TOP_LEFT));

    }
}
