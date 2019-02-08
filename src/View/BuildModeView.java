package View;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class BuildModeView implements Observer {


    private JFrame window;
        private JPanel border;
            private JPanel top;
                private JButton play;
                private JButton save;
                private JButton open;
                private JButton quit;
            private JPanel left;
            private JPanel right;



    public BuildModeView(){


    }

    public void init(){

        window = new JFrame("Gizmoball");
            border = new JPanel(new BorderLayout());
                top = new JPanel(new FlowLayout());
                    play = new JButton("Play");
                    save = new JButton("Save");
                    open = new JButton("Open");
                    quit = new JButton("Quit");
                left = new JPanel();
                right = new JPanel();

        top.add(play);
        top.add(save);
        top.add(open);
        top.add(quit);

        border.add(top, BorderLayout.PAGE_START);

        window.add(border);

        window.pack();
        window.setVisible(true);

    }


    @Override
    public void update(Observable o, Object arg) {

    }
}
