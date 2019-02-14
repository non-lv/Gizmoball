package Controller;

import Model.Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class RunModeController implements ActionListener {

    private Timer timer;
    private Model model;

    public RunModeController(Model m) {
        model = m;
        timer = new Timer(50, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == timer) {
            model.moveBalls();
        } else {
            switch (e.getActionCommand()) {
                case "Start/Stop":
                if(timer.isRunning())
                    timer.stop();
                else timer.start();
                    break;
                case "Tick":
                    model.moveBalls();
                    break;
                case "Reload":
                    break;
                case "Load":
                    break;
            }
        }
    }
}
