import Controller.HomeController;
import Controller.OptionPanelController;
import View.*;
import Model.Model;


public class Driver {

    public static void main(String[] args) {
        Model m = new Model();

        HomeController homeController = new HomeController(m);
    }
}
