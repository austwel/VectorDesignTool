package DesignTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Tool extends JFrame implements ActionListener{

    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    public JFrame frame;

    private static Color penColor = Color.decode("#000000");

    private JPanel pnlMain;
    private JPanel pnlMenu;
    private JPanel pnlColour;

    private JButton btnLoad;
    private JButton btnSave;
    private JButton btnLine;
    private JButton btnRed;
    private JButton btnOrange;
    private JButton btnYellow;
    private JButton btnLime;
    private JButton btnGreen;
    private JButton btnAqua;
    private JButton btnCyan;
    private JButton btnTurquoise;
    private JButton btnBlue;
    private JButton btnPurple;
    private JButton btnMagenta;
    private JButton btnPink;
    private JButton btnBlack;
    private JButton btnGrey;
    private JButton btnLightGrey;
    private JButton btnWhite;

    public Tool(String title){
        frame = new JFrame(title);
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
    }

    public static void changePen(String color) {
        penColor = Color.decode(color);
    }

    public static void startFill(String color) {
        //
    }

    public static void drawLine(Float x1, Float y1, Float x2, Float y2) {
        //
    }

    public static void drawRectangle(Float x1, Float y1, Float x2, Float y2) {
        //
    }

    public static void drawPlot(Float x, Float y) {
        //
    }

    public static void drawEllipse(Float x1, Float y1, Float x2, Float y2) {
        //
    }

    public static void drawPolygon(ArrayList<Float> values) {
        //
    }

    private JButton createButton(String str){
        JButton button = new JButton();
        button.setText(str);
        button.addActionListener(this);
        return button;
    }

    public void setupPanels() {
        pnlMain = new JPanel(frame.getLayout());
        pnlMain.setBackground(Color.WHITE);
        pnlColour = new JPanel(new GridLayout(2, 8, 5, 5));
        pnlColour.setBackground(new Color(255, 255, 200));
        pnlColour.setBounds(0, HEIGHT - 100, WIDTH, 100);
        pnlMenu = new JPanel(new GridLayout(10, 1, 3, 3));
        pnlMenu.setBackground(Color.RED);
        pnlMenu.setBounds(0, 150, 100, 150);
        frame.add(pnlColour, BorderLayout.PAGE_END);
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

        btnRed = createButton("");
        btnRed.setBackground(new Color(255, 0 ,0));
        btnRed.setBounds(0, 0, 5, 5);

        btnYellow = createButton("");
        btnYellow.setBackground(new Color(255, 255, 0));
        btnYellow.setBounds(1, 0, 5, 5);

        btnGreen = createButton("");
        btnGreen.setBackground(new Color(0, 255, 0));
        btnGreen.setBounds(2, 0, 5, 5);

        btnCyan = createButton("");
        btnCyan.setBackground(new Color(0, 255, 255));
        btnCyan.setBounds(3, 0, 5, 5);

        btnBlue = createButton("");
        btnBlue.setBackground(new Color(0, 0, 255));
        btnBlue.setBounds(4, 0, 5, 5);

        btnMagenta = createButton("");
        btnMagenta.setBackground(new Color(255, 0, 255));
        btnMagenta.setBounds(5, 0, 5, 5);

        btnBlack = createButton("");
        btnBlack.setBackground(new Color(0, 0, 0));
        btnBlack.setBounds(6, 0, 5, 5);

        btnLightGrey = createButton("");
        btnLightGrey.setBackground(new Color(191, 191, 191));
        btnLightGrey.setBounds(7, 1, 5, 5);

        btnOrange = createButton("");
        btnOrange.setBackground(new Color(255, 127, 0));
        btnOrange.setBounds(0, 1, 5, 5);

        btnLime = createButton("");
        btnLime.setBackground(new Color(127, 255, 0));
        btnLime.setBounds(1, 1, 5, 5);

        btnAqua = createButton("");
        btnAqua.setBackground(new Color(0, 255, 127));
        btnAqua.setBounds(2, 1, 5, 5);

        btnTurquoise = createButton("");
        btnTurquoise.setBackground(new Color(0, 127, 255));
        btnTurquoise.setBounds(3, 1, 5, 5);

        btnPurple = createButton("");
        btnPurple.setBackground(new Color(127, 0, 255));
        btnPurple.setBounds(4, 1, 5, 5);

        btnPink = createButton("");
        btnPink.setBackground(new Color(255, 0, 127));
        btnPink.setBounds(5, 1, 5, 5);

        btnGrey = createButton("");
        btnGrey.setBackground(new Color(127, 127, 127));
        btnGrey.setBounds(6, 1, 5, 5);

        btnWhite = createButton("");
        btnWhite.setBackground(new Color(255, 255 ,255));
        btnWhite.setBounds(7, 1, 5, 5);

        pnlMenu.add(btnLoad);
        pnlMenu.add(btnSave);
        pnlMenu.add(btnLine);
        pnlColour.add(btnRed);
        pnlColour.add(btnYellow);
        pnlColour.add(btnGreen);
        pnlColour.add(btnCyan);
        pnlColour.add(btnBlue);
        pnlColour.add(btnMagenta);
        pnlColour.add(btnBlack);
        pnlColour.add(btnLightGrey);
        pnlColour.add(btnOrange);
        pnlColour.add(btnLime);
        pnlColour.add(btnAqua);
        pnlColour.add(btnTurquoise);
        pnlColour.add(btnPurple);
        pnlColour.add(btnPink);
        pnlColour.add(btnGrey);
        pnlColour.add(btnWhite);
        frame.repaint();
        pnlMenu.repaint();
        pnlMain.repaint();
    }

    private void addToPanel(JPanel jp, Component c, GridBagConstraints constraints, int x, int y, int w, int h) {
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = w;
        constraints.gridheight = h;
        jp.add(c, constraints);
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

    public static void main(String[] args){
        Tool tool = new Tool("Test");
        tool.setupGUI();
    }
}
