package View;

import javax.swing.*;
import java.awt.*;

public class RunModePanel extends JPanel {

    private JPanel box;
        private JButton startStop;
        private JButton tick;
        private JButton reload;
        private JButton quit;


    public RunModePanel(){
        init();
    }

    public void init(){

        box = new JPanel(new GridLayout(4,1));
            startStop = new JButton("Start/Stop");
            tick = new JButton("Tick");
            reload = new JButton("Reload");
            quit = new JButton("Load");

        box.setPreferredSize(new Dimension(150,500));

        box.add(startStop);
        box.add(tick);
        box.add(reload);
        box.add(quit);

        this.add(box);

    }
}
