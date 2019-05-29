package DesignTool.Misc;

import DesignTool.Misc.DrawTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.event.MouseMotionAdapter;

public class DrawMouse extends JPanel{
    private int x1, y1, x2, y2 = 0;
    private MouseListener listener;
    private MouseEvent e;
    private MouseAdapter adapter;

    public DrawMouse(MouseListener listener, MouseEvent e, MouseAdapter adapter){
        this.listener = listener;
        this.e = e;
        this.adapter = adapter;
    }

    public void setStartPoint(int x1, int y1){
        this.x1 = x1;
        this.y1 = y1;
    }

    public void setEndPoint(int x2, int y2){
        this.x2 = x2;
        this.y2 = y2;
    }

    public void mousePressed (MouseEvent e){
        setStartPoint(e.getX(), e.getY());
    }

    public void mouseDragged (MouseEvent e){
        setEndPoint(e.getX(), e.getY());
    }

    public void mouseReleased (MouseEvent e){
        setEndPoint(e.getX(), e.getY());
    }

}
