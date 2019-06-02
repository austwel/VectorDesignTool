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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;
import java.security.Key;

public class Coords extends JPanel implements ActionListener{

    private Dimension _dimension;
    private GridBagConstraints _constraints;
    public static JButton btnSet;
    public static JSpinner spinX1, spinX2, spinY1, spinY2;
    private float scale;
    private int x1, y1, x2, y2 = 0;
    public ChangeEvent changex1, changex2, changey1, changey2;

    public Coords() {
        _dimension = new Dimension(240, 100);
        _constraints = new GridBagConstraints();
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createTitledBorder("Coordinates"));
        setLocation(300, 20);
        setSize(240, 100);
        newGrid();
        spinX1 = createSpinner();
        spinX1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                changex1 = e;
            }
        });
        newLine();
        spinX2 = createSpinner();
        spinX2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                changex2 = e;
            }
        });
        nextGrid();
        spinY1 = createSpinner();
        spinY1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                changey1 = e;
            }
        });
        newLine();
        spinY2 = createSpinner();
        spinY2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                changey2 = e;
            }
        });
        nextGrid();
        btnSet = createButton("Set", KeyEvent.VK_5);

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

    private JSpinner createSpinner(){
        SpinnerModel value = new SpinnerNumberModel(0, 0, 400, 1);
        JSpinner src = new JSpinner(value);
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
        int x1 = (Integer) spinX1.getValue();
        int x2 = (Integer) spinX2.getValue();
        int y1 = (Integer) spinY1.getValue();
        int y2 = (Integer) spinY2.getValue();
        if (src == btnSet) {
            setCoords(x1, x2, y1, y2);
        }
    }
}
