package DesignTool.Misc;

import DesignTool.Main;
import DesignTool.Misc.DrawTool;
import DesignTool.Panels.GUI;
import DesignTool.Panels.Tools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class DrawMouse extends JPanel{
    private int x1, y1, x2, y2 = 0;
    private MouseListener listener;
    private MouseEvent e;
    private MouseMotionListener motion;
    private DrawTool tool;
    private JPanel pnlTools;
    private JButton btnFill, btnLine, btnRect, btnPlot, btnEllipse, btnPoly;
    private JPanel _canvas;
    private GUI _draw;
    private DrawMouse mouse;


    public DrawMouse(MouseListener listener, MouseEvent e, MouseMotionListener motion){
        _draw = Main.tool;
        tool = GUI.draw;
        pnlTools = GUI._pnlTools;
        btnFill = Tools.btnFill;
        btnLine = Tools.btnLine;
        btnRect = Tools.btnRect;
        btnPlot = Tools.btnPlot;
        btnEllipse = Tools.btnEllipse;
        btnPoly = Tools.btnPoly;
        this.listener = listener;
        this.e = e;
        this.motion = motion;
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

    public void drawObject(MouseEvent mouseEvent){
        mouse = new DrawMouse(listener, mouseEvent, motion);
        listener = GUI._listener;
        mouseEvent = e;
        motion = GUI._motion;
        Object src = mouseEvent.getButton();
        int x1, y1, x2, y2 = 0;
        if (src == btnFill) {
            Main.startFill("#0000FF");
        } else if (src == btnLine) {
            mouse.mousePressed(mouseEvent);
            x1 = mouseEvent.getX();
            y1 = mouseEvent.getY();
            mouse.mouseDragged(mouseEvent);
            x2 = mouseEvent.getX();
            y2 = mouseEvent.getY();
            _canvas.repaint();
            mouse.mouseReleased(mouseEvent);
            x2 = mouseEvent.getX();
            y2 = mouseEvent.getY();
            _canvas.repaint();
            mouse.tool.drawLine(x1 * 0.2f, y1 * 0.2f, x2 * 0.8f, y2 * 0.8f);
        } else if (src == btnRect) {
            Main.drawRectangle(0.2f, 0.2f, 0.8f, 0.8f);
        } else if (src == btnPlot) {

        } else if (src == btnEllipse) {
            Main.drawEllipse(0.3f, 0.3f, 0.7f, 0.7f);
        } else if (src == btnPoly) {
            Main.startFill("#0000FF");
        }
    }

}
