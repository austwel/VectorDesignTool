package DesignTool.Panels;

import DesignTool.Misc.DragHandler;
import DesignTool.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
<<<<<<< HEAD
import java.awt.event.KeyEvent;
import java.security.Key;
=======
import java.io.IOException;
>>>>>>> 4722f843ad22d9eb7b54c7bb267320ca4d78b00c

public class Tools extends JPanel implements ActionListener {

    private Dimension _dimension;
    private GridBagConstraints _constraints;
    private JButton btnFill, btnLine, btnRect, btnPlot, btnEllipse, btnPoly;

    public Tools() {
        _dimension = new Dimension(110, 50);
        _constraints = new GridBagConstraints();
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createTitledBorder("Tools"));
        setLocation(700, 60);
<<<<<<< HEAD
        setSize(240, 130);
        newGrid();
        btnLine = createButton("Line", KeyEvent.VK_1);
        nextGrid();
        btnRect = createButton("Rectangle", KeyEvent.VK_2);
        newLine();
        btnEllipse = createButton("Ellipse", KeyEvent.VK_3);
        nextGrid();
        btnPoly = createButton("Polygon", KeyEvent.VK_4);
=======
        setSize(240, 180);
        newGrid();
        btnFill = createButton("Fill");
        nextGrid();
        btnLine = createButton("Line");
        newLine();
        btnRect = createButton("Rectangle");
        nextGrid();
        btnPlot = createButton("Plot");
        newLine();
        btnEllipse = createButton("Ellipse");
        nextGrid();
        btnPoly = createButton("Polygon");
>>>>>>> 4722f843ad22d9eb7b54c7bb267320ca4d78b00c

        new DragHandler(this);
    }

<<<<<<< HEAD
    private JButton createButton(String text, int keyEvent) {
        JButton src = new JButton();
        src.setText(text);
        src.setPreferredSize(_dimension);
        src.setMnemonic(keyEvent);
=======
    private JButton createButton(String text) {
        JButton src = new JButton();
        src.setText(text);
        src.setPreferredSize(_dimension);
>>>>>>> 4722f843ad22d9eb7b54c7bb267320ca4d78b00c
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

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == btnFill) {
<<<<<<< HEAD
            Main.startFill("#0000FF");
        } else if (src == btnLine) {
            Main.drawLine(0.2f, 0.2f, 0.8f, 0.8f);
        } else if (src == btnRect) {
            Main.drawRectangle(0.2f, 0.2f, 0.8f, 0.8f);
        } else if (src == btnPlot) {

        } else if (src == btnEllipse) {
            Main.drawEllipse(0.3f, 0.3f, 0.7f, 0.7f);
        } else if (src == btnPoly) {
            Main.startFill("#0000FF");
=======

        } else if (src == btnLine) {
            Main.drawLine(0.2f, 0.2f, 0.8f, 0.8f);
        } else if (src == btnRect) {

        } else if (src == btnPlot) {

        } else if (src == btnEllipse) {

        } else if (src == btnPoly) {

>>>>>>> 4722f843ad22d9eb7b54c7bb267320ca4d78b00c
        }
    }
}
