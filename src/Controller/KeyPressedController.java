package Controller;

import Model.Model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyPressedController implements KeyListener {
    Model model;

    public KeyPressedController(Model m) {
        model = m;
    }

    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println("pressed");
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                model.leftFlipperMove();
                break;
            case KeyEvent.VK_RIGHT:
                model.rightFlipperMove();
                break;
            default:
        }

        model.fireAbsorbers();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                model.leftFlipperStop();
                break;
            case KeyEvent.VK_RIGHT:
                model.rightFlipperStop();
                break;
            default:
        }
    }

}