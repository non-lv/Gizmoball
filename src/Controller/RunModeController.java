package Controller;

import Model.Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import Model.LoadBoardFromFile;
import javax.swing.*;
import Model.LoadBoardFromFile;
import javax.swing.filechooser.FileSystemView;

public class RunModeController implements ActionListener {

    private Timer timer;
    private Model model;
    private static String path;
    private static Model initial;
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
                    model.clear();
                    try{
                        LoadBoardFromFile.readFromFile(path,model);
                    } catch (Exception ex){
                        System.out.println("cant read");
                    }

                    break;

            }
        }
    }

    public void stopTime(){
        timer.stop();
    }

    public void startTime(){
        timer.start();
    }

    public static void setPath(String p){
        path = p;
    }

}
