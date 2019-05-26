package DesignTool;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GUI extends JFrame {

    public static final int WIDTH = 400;
    public static final int HEIGHT = 400;
    public static float _scale = 400;

    private static BufferedImage buf;
    private static Color _penColor = new Color(0, 0, 0);

    private JPanel canvas;
    private JLayeredPane layeredPane;

    private JPanel pnlColor;
    private JColorChooser colorChooser;
    private JMenuBar menuBar;

    private JPanel pnlTools;

    private JPanel pnlHistory;

    public GUI() {
        super("Vector Design Tool");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setupGUI();
    }

    public void changePen(Color color) {
        _penColor = color;
    }

    public void endFill() {
        //
    }

    public void startFill(Color color) {
        //
    }

    public void drawLine(Float x1, Float y1, Float x2, Float y2) {
        Graphics g = buf.createGraphics();
        g.setColor(_penColor);
        g.drawLine(Math.round(x1 * _scale), Math.round(y1 * _scale), Math.round(x2 * _scale), Math.round(y2 * _scale));
        canvas.repaint();
    }

    public void drawRectangle(Float x1, Float y1, Float x2, Float y2) {
        Graphics g = buf.createGraphics();
        g.setColor(_penColor);
        g.drawRect(Math.round(x1 * _scale), Math.round(y1 * _scale), Math.round((x2 - x1) * _scale), Math.round((y2 - y1) * _scale));
        canvas.repaint();
    }

    public void drawPlot(Float x, Float y) {
        Graphics g = buf.createGraphics();
        g.setColor(_penColor);
        g.drawLine(Math.round(x * _scale), Math.round(y * _scale), Math.round(x * _scale), Math.round(y * _scale));
        canvas.repaint();
    }

    public void drawEllipse(Float x1, Float y1, Float x2, Float y2) {
        Graphics g = buf.createGraphics();
        g.setColor(_penColor);
        g.drawOval(Math.round(x1 * _scale), Math.round(y1 * _scale), Math.round((x2 - x1) * _scale), Math.round((y2 - y1) * _scale));
        canvas.repaint();
    }

    public void drawPolygon(ArrayList<Float> values) {
        Graphics2D g = buf.createGraphics();
        g.setColor(_penColor);
        int[] xArray = new int[values.size() / 2];
        int[] yArray = new int[values.size() / 2];
        for (int i = 0, len = values.size(); i < len; i++) {
            switch (i % 2) {
                case 0:
                    xArray[i / 2] = Math.round(values.get(i) * _scale);
                    break;
                case 1:
                    yArray[(i - 1) / 2] = Math.round(values.get(i) * _scale);
                    break;
            }
        }
        g.draw(new Polygon(xArray, yArray, values.size() / 2));
        canvas.repaint();
    }

    public void setupPanels() {
        layeredPane = getLayeredPane();
        canvas = new JPanel(this.getLayout());
        canvas.setBackground(Color.WHITE);
        canvas.setBounds(250, 250, 401, 401);
        layeredPane.setLayer(pnlTools, JLayeredPane.DRAG_LAYER);
        layeredPane.setLayer(canvas, JLayeredPane.DEFAULT_LAYER);
        layeredPane.setLayer(pnlColor, JLayeredPane.DRAG_LAYER);
        layeredPane.add(pnlTools);
        layeredPane.add(canvas);
        layeredPane.add(pnlColor);
        repaint();
        setVisible(true);
    }

    public void setupMenu() {
        menuBar = new MenuBar(pnlTools, pnlColor, pnlHistory);
        setJMenuBar(menuBar);
    }

    public void setupGUI() {
        pnlColor = new ColorChooser(_penColor);
        pnlTools = new Tools();
        //History
        setupMenu();
        setupPanels();
        buf = new Img();
        canvas.add(new CustomPaintComponent(buf));
        canvas.repaint();
        repaint();
    }
}
