import Controller.HomeController;
import Model.Model;


public class Driver {

    public static void main(String[] args) {
        Model m = new Model();

        new HomeController(m);
    }
}
