import Model.LoadBoardFromFile;
import View.*;
import Model.Model;


public class Driver {

    public static void main(String[] args) {
        Model m = new Model();


        try{
            LoadBoardFromFile.readFromFile("src/Model/inputFile.txt",m);


        } catch (Exception ex){
            System.out.println("cant read");
        }

        OptionsPanel optionsPanel = new OptionsPanel();
        RunModePanel playModePanel = new RunModePanel();
        BoardPanel boardPanel = new BoardPanel(m);
        NotificationPanel notificationPanel = new NotificationPanel();

        HomeFrame homeFrame = new HomeFrame(playModePanel, optionsPanel, boardPanel, notificationPanel);

//        JFrame f = new JFrame();
//        f.add(boardPanel);
//        f.pack();
//        f.setVisible(true);


//        m.addCircle(new CircleGizmo(15,10));
//        m.addCircle(new CircleGizmo(18,18));
//        m.addCircle(new CircleGizmo(2, 2));
//        m.addSquare(new SquareGizmo(5,5));
//        m.addSquare(new SquareGizmo(6,18));
//        m.addTriangle(new TriangleGizmo(3,3));
//        m.addTriangle(new TriangleGizmo(20,20));
//        m.addAbsorber(new AbsorberGizmo(15,15,9,17));
//        m.addFlipper(new FlipperGizmo(8,8, 1));
//        m.addFlipper(new FlipperGizmo(8,8, 0));

    }
}