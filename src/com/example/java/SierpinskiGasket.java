package com.example.java;

import javax.swing.*;
import java.awt.*;

/**
 * This class uses recursion to draw a Sierpinski gasket
 * Created by vagrant on 12/5/15.
 */
public class SierpinskiGasket extends JApplet{

    int level = 0;

    public void init(){
        //prompt the user to enter the desired recursion level for the Sierpinski gasket
        String levelStr = JOptionPane.showInputDialog("Enter the recursion depth: ");

        level = Integer.parseInt(levelStr);
    }

    public void paint(Graphics g){
        //draw the initial "level 0" triangle
        Point point1 = new Point(60,160);
        Point point2 = new Point(220,160);
        Point point3 = new Point(140,20);

        drawSierpinski(g, level, point1, point2, point3);
    }

    private Point midPoint(Point pOne, Point pTwo){
        Point mid = new Point((pOne.x + pTwo.x) / 2,
        (pOne.y + pTwo.y) /2 );

        return mid;
    }

    /**
     * This recursive method implements an algorithm to draw a Sierpinski gasket
     * @param g
     * @param lev
     * @param p1
     * @param p2
     * @param p3
     */
    private void drawSierpinski(Graphics g, int lev, Point p1, Point p2, Point p3){
        Point midP1P2;
        Point midP2P3;
        Point midP3P1;

        if (lev > 0 ){
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
            g.drawLine(p2.x, p2.y, p3.x, p3.y);
            g.drawLine(p3.x, p3.y, p1.x, p1.y);

            midP1P2 = midPoint(p1, p2);
            midP2P3 = midPoint(p2, p3);
            midP3P1 = midPoint(p3, p1);

            drawSierpinski(g, lev - 1, p1, midP1P2, midP3P1);
            drawSierpinski(g, lev - 1, p2, midP2P3, midP1P2);
            drawSierpinski(g, lev - 1, p3, midP3P1, midP2P3);
        }
    }
}
