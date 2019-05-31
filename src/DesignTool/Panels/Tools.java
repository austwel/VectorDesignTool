package DesignTool.Panels;

import DesignTool.Misc.DragHandler;
import DesignTool.Main;
import DesignTool.Misc.DrawTool;
import DesignTool.Misc.DrawMouse;
import DesignTool.Panels.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.security.Key;

public class Tools extends JPanel{

    private Dimension _dimension;
    private GridBagConstraints _constraints;
    public static JButton btnFill, btnLine, btnRect, btnPlot, btnEllipse, btnPoly;
    public static ActionListener action;
    private JPanel canvas;
    private BufferedImage buf;
    private Color penColor;
    private float scale;
    private MouseListener listener;
    private MouseAdapter adapter;
    private MouseEvent event;

    public Tools() {
        _dimension = new Dimension(110, 50);
        _constraints = new GridBagConstraints();
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createTitledBorder("Tools"));
        setLocation(700, 60);
        setSize(240, 130);
        newGrid();
        btnLine = createButton("Line", KeyEvent.VK_1);
        nextGrid();
        btnRect = createButton("Rectangle", KeyEvent.VK_2);
        newLine();
        btnEllipse = createButton("Ellipse", KeyEvent.VK_3);
        nextGrid();
        btnPoly = createButton("Polygon", KeyEvent.VK_4);

        new DragHandler(this);
    }

    private JButton createButton(String text, int keyEvent) {
        JButton src = new JButton();
        src.setText(text);
        src.setPreferredSize(_dimension);
        src.setMnemonic(keyEvent);
        src.addActionListener(action);
        add(src, _constraints);
        return src;
    }

    private void newGrid() {
        _constraints.gridx = 0;
        _constraints.gridy = 0;
    }

    private void newLine() {
        _constraints.gridx = 0;
        _constraints.gridy++;
    }

    private void nextGrid() {
        _constraints.gridx++;
    }

    //@Override
    /*public void actionPerformed(ActionEvent e) {
        DrawTool draw = new DrawTool(canvas, buf, penColor, scale);
        DrawMouse mouse = new DrawMouse(listener, event, adapter);
        listener = GUI._listener;
        Object src = e.getSource();
        int x1, y1, x2, y2 = 0;
        if (src == btnFill) {
            Main.startFill("#0000FF");
        } else if (src == btnLine) {
            mouse.mousePressed(event);
            x1 = event.getX();
            y1 = event.getY();
            mouse.mouseDragged(event);
            x2 = event.getX();
            y2 = event.getY();
            canvas.repaint();
            mouse.mouseReleased(event);
            x2 = event.getX();
            y2 = event.getY();
            canvas.repaint();
            draw.drawLine(x1 * 0.2f, y1 * 0.2f, x2 * 0.8f, y2 * 0.8f);
        } else if (src == btnRect) {
            Main.drawRectangle(0.2f, 0.2f, 0.8f, 0.8f);
        } else if (src == btnPlot) {

        } else if (src == btnEllipse) {
            Main.drawEllipse(0.3f, 0.3f, 0.7f, 0.7f);
        } else if (src == btnPoly) {
            Main.startFill("#0000FF");
        }
    }*/
}