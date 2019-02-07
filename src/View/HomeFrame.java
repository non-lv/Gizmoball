package View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class HomeFrame implements Observer {


    private JFrame window;
        private JPanel border;
            private JPanel menuPanelLeft;
            private JPanel leftAlignment;
                private JPanel optionsPanelTop;
            private JPanel boardAndNotificationBarContainer;
                private JPanel notificationPanel;
                private JPanel boardPanel;


    public HomeFrame(JPanel menuPanelLeft, JPanel optionsPanelTop, JPanel boardPanel, JPanel notificationPanel){

        this.menuPanelLeft = menuPanelLeft;
        this.optionsPanelTop = optionsPanelTop;
        this.boardPanel = boardPanel;
        this.notificationPanel = notificationPanel;

        init();
    }

    public void init(){

        window = new JFrame("Gizmoball");
            border = new JPanel(new BorderLayout());
                leftAlignment = new JPanel(new FlowLayout(FlowLayout.LEFT));
                boardAndNotificationBarContainer = new JPanel(new BorderLayout());

        border.add(menuPanelLeft, BorderLayout.LINE_START);

        leftAlignment.setPreferredSize(new Dimension(700,80));
        leftAlignment.add(optionsPanelTop);


        border.add(leftAlignment, BorderLayout.PAGE_START);

        boardAndNotificationBarContainer.add(boardPanel, BorderLayout.CENTER);
        boardAndNotificationBarContainer.add(notificationPanel, BorderLayout.PAGE_END);

        border.add(boardAndNotificationBarContainer, BorderLayout.CENTER);

        window.add(border);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }


    @Override
    public void update(Observable o, Object arg) {

    }
}
