package DesignTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tool extends JFrame implements ActionListener{

    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    public JFrame frame;

    private JPanel pnlMain;
    private JPanel pnlMenu;

    private JButton btnLoad;
    private JButton btnSave;
    private JButton btnLine;

    public Tool(String title){
        frame = new JFrame(title);
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
    }

    private JButton createButton(String str) {
        JButton button = new JButton();
        button.setText(str);
        button.addActionListener(this);
        return button;
    }

    public void setupPanels() {
        pnlMain = new JPanel(frame.getLayout());
        pnlMain.setBackground(Color.WHITE);
        pnlMenu = new JPanel(new GridLayout(10, 1, 3, 3));
        pnlMenu.setBackground(Color.RED);
        pnlMenu.setBounds(10, 150, 100, 150);
        frame.add(pnlMain, BorderLayout.CENTER);
        frame.add(pnlMenu, BorderLayout.WEST);
        frame.repaint();
        frame.setVisible(true);
    }

    public void setupGUI() {
        setupPanels();
        btnLoad = createButton("Load");
        btnLoad.setBounds(5, 1, 20, 1);
        btnSave = createButton("Save");
        btnSave.setBounds(5, 2, 20, 1);
        btnLine = createButton("Line");
        btnLine.setBounds(5, 3, 20 ,1);
        pnlMenu.add(btnLoad);
        pnlMenu.add(btnSave);
        pnlMenu.add(btnLine);
        frame.repaint();
        pnlMenu.repaint();
        pnlMain.repaint();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == btnLoad) {
            //To do
        } else if (src == btnSave) {
            //To do
        } else if (src == btnLine) {
            //To do
        }
    }

    public static void main(String[] args) {
        Tool tool = new Tool("Test");
        tool.setupGUI();
    }
}
