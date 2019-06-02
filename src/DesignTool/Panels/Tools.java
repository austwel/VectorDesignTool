package DesignTool.Panels;

import DesignTool.Misc.DragHandler;
import DesignTool.Main;
import DesignTool.Misc.DrawTool;
import DesignTool.Panels.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.security.Key;

public class Tools extends JPanel implements ActionListener{

    private Dimension _dimension;
    private GridBagConstraints _constraints;
    public static JButton btnFill, btnLine, btnRect, btnPlot, btnEllipse, btnPoly;
    private Color penColor;
    private float scale;
    private int x1, y1, x2, y2 = 0;

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
        src.addActionListener(this);
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

    public void setCoords(int x1, int x2, int y1, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == btnFill) {
            Main.startFill("#0000FF");
        } else if (src == btnLine) {
            Main.drawLine(x1 * 0.2f, y1 * 0.2f, x2 * 0.8f, y2 * 0.8f);
        } else if (src == btnRect) {
            Main.drawRectangle(0.2f, 0.2f, 0.8f, 0.8f);
        } else if (src == btnPlot) {
            Main.drawPlot(x1 * 0.2f, y1 * 0.2f);
        } else if (src == btnEllipse) {
            Main.drawEllipse(0.3f, 0.3f, 0.7f, 0.7f);
        } else if (src == btnPoly) {
            Main.startFill("#0000FF");
        }
    }
}