package View;

import javax.swing.*;
import java.awt.*;
import Model.Model;
import Model.CircleGizmo;
import Model.SquareGizmo;
import Model.TriangleGizmo;
public class BoardPanel extends JPanel {

    //private JPanel board;
    protected Model m;

    public BoardPanel(Model m){

        this.m = m;
        init();
    }

    public void init(){

        this.setPreferredSize(new Dimension(LstoPx(20),LstoPx(20)));
        this.setBackground(new Color(255,255,255));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // Draw all the vertical lines
        for (CircleGizmo c : m.getCircles()) {
            int x = (LstoPx(c.getXpos()));
            int y = (LstoPx(c.getXpos()));

            g2.fillOval(x,y, LstoPx(1),LstoPx(1));

        }

        for(SquareGizmo s: m.getSquare()){
            int x = (LstoPx(s.getXpos()));
            int y = (LstoPx(s.getXpos()));

            s.getCircles();
            s.getLines();

            g2.fillRect(x,y,LstoPx(1),LstoPx(1));


        }

        for(TriangleGizmo s: m.getTriangles()){
            int x = (LstoPx(s.getXpos()));
            int y = (LstoPx(s.getXpos()));

            int xpoints[] = {x,x,x+25};
            int ypoints[] = {y,y-25,y};
            int npoints = 3;

            g2.fillPolygon(xpoints, ypoints, npoints);


        }



    }

    public int LstoPx(int a){
        return a*25;
    }

    public int PxtoLs(int a){
        return a/25;
    }



}















