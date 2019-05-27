package DesignTool.Panels;

import DesignTool.Misc.DragHandler;
import DesignTool.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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

        new DragHandler(this);
    }

    private JButton createButton(String text) {
        JButton src = new JButton();
        src.setText(text);
        src.setPreferredSize(_dimension);
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

        } else if (src == btnLine) {
            Main.drawLine(0.2f, 0.2f, 0.8f, 0.8f);
        } else if (src == btnRect) {

        } else if (src == btnPlot) {

        } else if (src == btnEllipse) {

        } else if (src == btnPoly) {

        }
    }
}
