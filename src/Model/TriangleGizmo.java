package Model;

import physics.Circle;
import physics.LineSegment;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TriangleGizmo implements Gizmo {

    private int xpos;
    private int ypos;
    private Color colour;
    private String state;
    private String name;
    int x2;
    int x3;
    int y2;
    int y3;


    public TriangleGizmo(String n, int x, int y, String s){
        this.xpos = x;
        this.ypos = y;
        colour = Color.blue;
        state = s;
        name = n;
         x2 = x;
         x3 = x+1;
         y2 = y+1;
         y3 = y;

    }

    @Override
    public List<Circle> getCircles() {
        List l = new ArrayList<>();
        l.add(new Circle(xpos, ypos, 0));
        l.add(new Circle(xpos + 1, ypos, 0));
        l.add(new Circle(xpos, ypos + 1, 0));
        return l;
    }

    @Override
    public List<LineSegment> getLines() {
        return null;
    }

    @Override
    public void setPos() {

    }

    @Override
    public void trigger() {

    }

    public int getX2(){
        return x2;
    }
    public int getX3(){
        return x3;
    }
    public int gety2(){
        return y2;
    }
    public int gety3(){
        return y3;
    }
    public int getXpos(){
        return xpos;
    }

    public int getYpos(){
        return ypos;
    }

    public Color getColour() {
        return colour;
    }

    public void rotate(){
        if(state.equals("topleft")){
            System.out.println("doing this");

            xpos = xpos + 1;
            y2 = y2-1;
            y3 = y3+1;
            state = "topright";
        }else if(state.equals("topright")){
            ypos = ypos + 1;
            x2++;
            x3--;
            state = "bottomright";
        }else if(state.equals("bottomright")){
            xpos = xpos -1;
            y2++;
            y3--;
            state = "bottomleft";
        }else if(state.equals("bottomleft")){
            ypos = ypos -1;
            x2--;
            x3++;
            state = "topleft";
        }
    }

    public String getName(){
        return name;
    }

    public String getState(){
        return state;
    }



}

