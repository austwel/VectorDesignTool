package DesignTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class Tool extends JFrame implements ActionListener, Runnable {

    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;

    private PrintWriter outputFile;
    private ArrayList<ArrayList<String>> commands = new ArrayList<>();
    private String penColor = "#000000";

    private JPanel pnlMain;
    private JPanel pnlBtns;
    private JButton btnLoad;
    private JButton btnSave;
    private JButton btnLine;

    public Tool(String title) throws HeadlessException {
        super(title);
    }

    private void saveFile() throws IOException {
        outputFile.close();
    }

    private void setupOutput() throws IOException {
        outputFile = new PrintWriter(new FileWriter("output.vec", false));
    }

    private void openFile() {
        
    }

    private void runFile() throws IOException {
        for (ArrayList<String> command : commands) {
            executeCommand(command);
        }
    }

    private void executeCommand(ArrayList<String> command) throws IOException {
        switch (command.get(0)) {
            case "LINE":
                drawLine(Float.valueOf(command.get(1)),
                        Float.valueOf(command.get(2)),
                        Float.valueOf(command.get(3)),
                        Float.valueOf(command.get(4)));
                break;
            case "RECTANGLE":
                drawRectangle(Float.valueOf(command.get(1)),
                        Float.valueOf(command.get(2)),
                        Float.valueOf(command.get(3)),
                        Float.valueOf(command.get(4)));
                break;
            case "PLOT":
                drawPlot(Float.valueOf(command.get(1)),
                        Float.valueOf(command.get(2)));
                break;
            case "ELLIPSE":
                drawEllipse(Float.valueOf(command.get(1)),
                        Float.valueOf(command.get(2)),
                        Float.valueOf(command.get(3)),
                        Float.valueOf(command.get(4)));
                break;
            case "POLYGON":
                ArrayList<Float> values = new ArrayList<>();
                for (String value : command) {
                    if (value != "POLYGON") {
                        values.add(Float.valueOf(value));
                    }
                }
                drawPolygon(values);
                break;
            case "FILL":
                break;
            case "PEN":
                penColor = command.get(1);
                break;
        }
    }

    private void drawLine(Float x1, Float y1, Float x2, Float y2) throws IOException {
        outputFile.printf("LINE %.2f %.2f %.2f %.2f", x1, x2, y1, y2);
    }

    private void drawRectangle(Float x1, Float y1, Float x2, Float y2) throws IOException {
        outputFile.printf("LINE %.2f %.2f %.2f %.2f", x1, x2, y1, y2);
    }

    private void drawPlot(Float x, Float y) throws IOException {
        outputFile.printf("LINE %.2f %.2f", x, y);
    }

    private void drawEllipse(Float x1, Float y1, Float x2, Float y2) throws IOException {
        outputFile.printf("LINE %.2f %.2f %.2f %.2f", x1, x2, y1, y2);
    }

    private void drawPolygon(ArrayList<Float> values) throws IOException {

    }

    private JButton createButton(String str) throws IOException {
        JButton button = new JButton();
        button.setText(str);
        button.addActionListener(this);
        return button;
    }

    private JPanel createPanel(Color c) throws IOException {
        JPanel panel = new JPanel();
        panel.setBackground(c);
        return panel;
    }

    private void setupPanels() throws IOException {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        pnlMain = createPanel(Color.WHITE);
        pnlBtns = createPanel(Color.lightGray);
        getContentPane().add(pnlMain, BorderLayout.CENTER);
        getContentPane().add(pnlBtns, BorderLayout.WEST);
        repaint();
        setVisible(true);
    }

    private void setupGUI() throws IOException {
        setupPanels();
        btnLoad = createButton("Load");
        btnSave = createButton("Save");
        btnLine = createButton("Line");
        layoutButtonPanel();
    }

    private void layoutButtonPanel() {
        GridBagLayout layout = new GridBagLayout();
        pnlBtns.setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weightx = 100;
        constraints.weighty = 100;
        addToPanel(pnlBtns, btnLoad, constraints, 0, 0, 1, 1);
        addToPanel(pnlBtns, btnSave, constraints, 0, 1, 1, 1);
        addToPanel(pnlBtns, btnLine, constraints, 0, 2, 1, 1);
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

    @Override
    public void run() {
        try {
            setupGUI();
        } catch (IOException e) {

        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Tool("Vector Design Tool"));
    }
}
