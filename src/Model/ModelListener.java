package Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ModelListener implements ActionListener {

    Model model;
    Timer timer;

    public ModelListener(Model m){
        model = m;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(Ball b : model.getBalls())
            b.move();
    }
}
