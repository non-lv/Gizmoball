package Controller;

import Model.Model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Model.AbsorberGizmo;

public class KeyPressedController implements KeyListener {
    String job;
    Model model;

    public KeyPressedController(Model m) {
        model = m;
    }

    public void keyTyped(KeyEvent e) {
        displayInfo(e, "KEY TYPED: ");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("got here");
        model.fireAbsorbers();
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {

            job = "fire";
        }

    }

    public String getJob() {
        return job;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private void displayInfo(KeyEvent e, String keyStatus) {

        //You should only rely on the key char if the event
        //is a key typed event.
        int id = e.getID();
        String keyString;
        if (id == KeyEvent.KEY_TYPED) {
            char c = e.getKeyChar();
            keyString = "key character = '" + c + "'";
        } else {
            int keyCode = e.getKeyCode();
            keyString = "key code = " + keyCode
                    + " ("
                    + KeyEvent.getKeyText(keyCode)
                    + ")";
        }
    }
}