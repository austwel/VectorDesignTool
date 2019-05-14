package DesignTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tool extends JFrame implements ActionListener, Runnable {

    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;

    private JPanel pnlMain;
    private JPanel pnlBtns;
    private JButton btnLoad;
    private JButton btnSave;
    private JButton btnLine;

    public Tool(String title) throws HeadlessException {
        super(title);
    }

    private JButton createButton(String str) {
        JButton button = new JButton();
        button.setText(str);
        button.addActionListener(this);
        return button;
    }

    private JPanel createPanel(Color c) {
        JPanel panel = new JPanel();
        panel.setBackground(c);
        return panel;
    }

    private void setupPanels() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        pnlMain = createPanel(Color.WHITE);
        pnlBtns = createPanel(Color.lightGray);
        getContentPane().add(pnlMain, BorderLayout.CENTER);
        getContentPane().add(pnlBtns, BorderLayout.PAGE_END);
        repaint();
        setVisible(true);
    }

    private void setupGUI() {
        setupPanels();
        btnLoad = createButton("Load");
        btnSave = createButton("Save");
        btnLine = createButton("Line");
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

    @Override
    public void run() {
        setupGUI();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Tool("Vector Design Tool"));
    }
}
