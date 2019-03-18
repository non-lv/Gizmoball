package Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MagicKeyListener implements KeyListener{


    public MagicKeyListener(KeyListener adaptee){
        this(adaptee, false);
    }

    public MagicKeyListener(KeyListener adaptee, boolean assumeAllReleased){
        if(adaptee == null) throw new IllegalArgumentException();
        this.adaptee = adaptee;
        this.assumeAllReleased = assumeAllReleased;

    }

    private final KeyListener adaptee;
    private final Set<Integer> real = new HashSet<Integer>();
    private final Set<Integer> announced = new HashSet<Integer>();
    private final boolean assumeAllReleased;

    private static Integer marker(KeyEvent e)
    {
        return new Integer(e.getKeyCode());
    }

    private static KeyEvent eventFromMarker(Integer marker, KeyEvent e){

        Component source = e.getComponent();
        int id = e.getID();
        long when = e.getWhen();
        int modifiers = e.getModifiers();
        int keyCode = marker.intValue();
        char keyChar = e.getKeyChar();

        return new KeyEvent(source, id, when, modifiers, keyCode, keyChar);
    }

    public void keyPressed(KeyEvent e){
        real.add(marker(e));
        SwingUtilities.invokeLater(new KeyPressedLater(e));
    }

    public void keyReleased(KeyEvent e){
        real.remove(marker(e));
        SwingUtilities.invokeLater(new KeyReleasedLater(e));

        if (assumeAllReleased) {
            while (!real.isEmpty()) {
                Integer marker;
                {
                    Iterator<Integer> chooser = real.iterator();
                    marker = chooser.next();
                    chooser.remove();
                }
                KeyEvent event = eventFromMarker(marker, e);
                SwingUtilities.invokeLater(new KeyReleasedLater(event));
            }
        }
    }

    public void keyTyped(KeyEvent e){
        SwingUtilities.invokeLater(new KeyTypedLater(e));
    }

    private class KeyTypedLater
            implements Runnable
    {
        private final KeyEvent event;
        private KeyTypedLater(KeyEvent event) {
            this.event = event;
        }
        public void run() {
            adaptee.keyTyped(event);
        }
    }

    private class KeyPressedLater
            implements Runnable
    {
        private final KeyEvent event;
        private KeyPressedLater(KeyEvent event) {
            this.event = event;
        }
        public void run() {
            Integer key = marker(event);
            if (real.contains(key) && !announced.contains(key)) {
                announced.add(key);
                adaptee.keyPressed(event);
            }
        }
    }

    private class KeyReleasedLater
            implements Runnable
    {
        private final KeyEvent event;
        private KeyReleasedLater(KeyEvent event) {
            this.event = event;
        }
        public void run() {
            Integer key = marker(event);
            if (!real.contains(key) && announced.contains(key)) {
                announced.remove(key);
                adaptee.keyReleased(event);
            }
        }
    }


}
