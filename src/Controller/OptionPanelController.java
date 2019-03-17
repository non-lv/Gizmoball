package Controller;

import Model.LoadBoardFromFile;
import Model.Model;
import Model.SaveBoardToFile;
import View.HomeFrame;
import View.OptionsPanel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class OptionPanelController implements ActionListener,Cloneable {
    
    private final OptionsPanel panel;
    private HomeFrame home;
    private Model model;


    public OptionPanelController(OptionsPanel panel, Model model){
        this.model = model;
        this.panel = panel;
    }

    public void setHomeFrame(HomeFrame home){
        this.home = home;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "switchToBuild":
                System.out.println("swap to build");
                home.swapToBuild();
                home.showNotification("Welcome to build mode");
                break;
            case "switchToRun":
                System.out.println("swap to run");
                home.swapToRun();
                home.showNotification("Gizmoball");
                break;
            case "Save":
                JFileChooser jfc1 = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                FileNameExtensionFilter filter1 = new FileNameExtensionFilter(".txt only!", "txt");
                jfc1.setFileFilter(filter1);
                int returnValue1 = jfc1.showDialog( this.panel, "save");
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
            case "Open":
                JFileChooser jfc2 = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                FileNameExtensionFilter filter2 = new FileNameExtensionFilter(".txt only!", "txt");
                jfc2.setFileFilter(filter2);
                int returnValue2 = jfc2.showDialog( this.panel, "Open");

                if(returnValue2 == JFileChooser.APPROVE_OPTION){
                    File selectedFile = jfc2.getSelectedFile();
                    String path = selectedFile.getAbsolutePath();
                    RunModeController.setPath(path);


                    try{
                        LoadBoardFromFile.readFromFile(path,model);



                    } catch (Exception ex){
                        System.out.println("cant read");
                    }

                }

                break;
            case "Quit":
                if(JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure you want to quit?",
                        "Gizmoball",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
                final JOptionPane quitPane = new JOptionPane("Do you want to quit?\nBe sure you have saved!", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
                break;
        }
    }





}
