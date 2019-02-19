package Controller;

import Model.Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

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
                case "Save":
                    JFileChooser jfc1 = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                    int returnValue1 = jfc1.showOpenDialog(null);

                    if(returnValue1 == JFileChooser.APPROVE_OPTION){
                        File selectedFile = jfc1.getSelectedFile();
                        String path = selectedFile.getAbsolutePath();

                        try{
                            SaveBoardToFile.saveToFile(path,model);
                        } catch (Exception ex){
                            System.out.println("cant read");
                        }
                    }
                    break;
                case "Load":
                    JFileChooser jfc2 = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                    int returnValue2 = jfc2.showOpenDialog(null);

                    if(returnValue2 == JFileChooser.APPROVE_OPTION){
                        File selectedFile = jfc2.getSelectedFile();
                        String path = selectedFile.getAbsolutePath();

                        try{
                            LoadBoardFromFile.readFromFile(path,model);
                        } catch (Exception ex){
                            System.out.println("cant read");
                        }
                    }
                    break;
            }
        }
    }

}
