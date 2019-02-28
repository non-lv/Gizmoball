package View;

import javax.swing.*;
import java.awt.*;

public class NotificationPanel extends JPanel {

    private JPanel container;
        private JLabel text;

    public NotificationPanel(){
        init();
    }

    private void init(){

        container = new JPanel();
        text = new JLabel("Gizmoball");

        container.setPreferredSize(new Dimension(500, 30));
        container.setBackground(Color.white);
        container.add(text);
        this.add(container);
    }

    public void setText(String str){
        text.setText(str);
    }
}
