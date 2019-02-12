package View;

import javax.swing.*;
import java.awt.*;
import Model.Model;
import Model.CircleGizmo;
import Model.SquareGizmo;
import Model.TriangleGizmo;
import Model.AbsorberGizmo;
import Model.FlipperGizmo;
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
            g2.setColor(Color.ORANGE);
            g2.fillOval(x,y, LstoPx(1),LstoPx(1));

        }

        for(SquareGizmo s: m.getSquare()){
            int x = (LstoPx(s.getXpos()));
            int y = (LstoPx(s.getXpos()));

            s.getCircles();
            s.getLines();
            g2.setColor(Color.RED);
            g2.fillRect(x,y,LstoPx(1),LstoPx(1));


        }

        for(TriangleGizmo s: m.getTriangles()){
            int x = (LstoPx(s.getXpos()));
            int y = (LstoPx(s.getXpos()));

            int xpoints[] = {x,x,x+25};
            int ypoints[] = {y,y-25,y};
            int npoints = 3;
            g2.setColor(Color.blue);
            g2.fillPolygon(xpoints, ypoints, npoints);


        }

        for(AbsorberGizmo a: m.getAbsorber()){
            int x = (LstoPx(a.getXpos()));
            int y = (LstoPx(a.getYpos()));
            int x2 = (LstoPx(a.getXpos2()));
            int y2 = (LstoPx(a.getYpos2()));
            g2.setColor(Color.CYAN);
            g2.fillRect(x,y, x2-x, y2-y);
        }

        for(FlipperGizmo f: m.getFlippers()){
            int x = (LstoPx(f.getXpos()));
            int y = (LstoPx(f.getYpos()));
            g2.setColor(Color.green);
            g2.fillRoundRect(x,y,12,LstoPx(2), 50,15);
        }



    }

    public int LstoPx(int a){
        return a*25;
    }

    public int PxtoLs(int a){
        return a/25;
    }



}















