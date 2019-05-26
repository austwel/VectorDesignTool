package DesignTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Tools extends JPanel implements ActionListener {

    private JButton btnFill, btnLine, btnRect, btnPlot, btnEllipse, btnPoly;

    public Tools() {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createTitledBorder("Tools"));
        GridBagConstraints constraints = new GridBagConstraints();
        Dimension dimension = new Dimension(110, 50);
        setLocation(700, 60);
        setSize(240, 180);
        constraints.gridx = 0;
        constraints.gridy = 0;
        btnFill = new JButton();
        btnFill.setText("Fill");
        btnFill.setPreferredSize(dimension);
        btnFill.addActionListener(this);
        add(btnFill, constraints);
        constraints.gridx++;
        btnLine = new JButton();
        btnLine.setText("Line");
        btnLine.setPreferredSize(dimension);
        btnLine.addActionListener(this);
        add(btnLine, constraints);
        constraints.gridx = 0;
        constraints.gridy++;
        btnRect = new JButton();
        btnRect.setText("Rectangle");
        btnRect.setPreferredSize(dimension);
        btnRect.addActionListener(this);
        add(btnRect, constraints);
        constraints.gridx++;
        btnPlot = new JButton();
        btnPlot.setText("Plot");
        btnPlot.setPreferredSize(dimension);
        btnPlot.addActionListener(this);
        add(btnPlot, constraints);
        constraints.gridx = 0;
        constraints.gridy++;
        btnEllipse = new JButton();
        btnEllipse.setText("Ellipse");
        btnEllipse.setPreferredSize(dimension);
        btnEllipse.addActionListener(this);
        add(btnEllipse, constraints);
        constraints.gridx++;
        btnPoly = new JButton();
        btnPoly.setText("Polygon");
        btnPoly.setPreferredSize(dimension);
        btnPoly.addActionListener(this);
        add(btnPoly, constraints);
        new DragHandler(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == btnFill) {

        } else if (src == btnLine) {
            try {
                Main.drawLine(0.2f, 0.2f, 0.8f, 0.8f);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (src == btnRect) {

        } else if (src == btnPlot) {

        } else if (src == btnEllipse) {

        } else if (src == btnPoly) {

        }
    }
}
