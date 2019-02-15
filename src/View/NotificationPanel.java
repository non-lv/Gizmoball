package View;

import javax.swing.*;
import java.awt.*;

public class NotificationPanel extends JPanel {

    private JPanel container;
        private JLabel text;

    public NotificationPanel(){
        init();
    }

    public void init(){

        container = new JPanel();
        text = new JLabel("Gizmoball");

        container.setPreferredSize(new Dimension(500, 30));
        container.setBackground(Color.white);
        container.add(text);
        this.add(container);
    }
}
