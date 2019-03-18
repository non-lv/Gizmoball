package Controller;

import Model.Model;
import Model.KeyConnection;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Set;

public class KeyPressedController implements KeyListener {

    private Model model;

    public KeyPressedController(Model m) {
        model = m;
    }

    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println("pressed");
//        switch (e.getKeyCode()){
//            case KeyEvent.VK_LEFT:
//                model.leftFlipperMove();
//                break;
//            case KeyEvent.VK_RIGHT:
//                model.rightFlipperMove();
//                break;
//            default:
//        }
//
//        model.fireAbsorbers();


            List<KeyConnection> actions = model.getKeyConnections();

            for(KeyConnection connection : actions) {
                if (connection.getKey() == e.getKeyCode() && connection.getStatus() == KeyConnection.KeyStatus.DOWN) {
                    connection.doAction();
                }
            }

    }

    @Override
    public void keyReleased(KeyEvent e) {
//        switch (e.getKeyCode()){
//            case KeyEvent.VK_LEFT:
//                model.leftFlipperStop();
//                break;
//            case KeyEvent.VK_RIGHT:
//                model.rightFlipperStop();
//                break;
//            default:
//        }


            List<KeyConnection> actions = model.getKeyConnections();

            for(KeyConnection connection : actions) {
                if (connection.getKey() == e.getKeyCode() && connection.getStatus() == KeyConnection.KeyStatus.UP) {
                    connection.doAction();
                }
            }

    }

}