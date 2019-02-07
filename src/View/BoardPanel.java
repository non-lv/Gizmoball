package View;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {

    private JPanel board;


    public BoardPanel(){
        init();
    }

    public void init(){

        board = new JPanel();
        board.setPreferredSize(new Dimension(500,500));
        board.setBackground(new Color(255,255,255));
        board.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        this.add(board);
    }
}
