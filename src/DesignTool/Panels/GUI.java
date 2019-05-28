package DesignTool.Panels;

import DesignTool.Misc.CustomPaintComponent;
import DesignTool.Misc.DrawTool;
import DesignTool.Misc.KeybindHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GUI extends JFrame {

    public static final int WIDTH = 400;
    public static final int HEIGHT = 400;
    public static float _scale = 400;

    private static BufferedImage buf;

    public DrawTool draw;
    private JPanel canvas;
    private JLayeredPane layeredPane;
    private JPanel pnlColor;
    private JPanel pnlTools;
    private JPanel pnlHistory;

    public GUI() {
        super("Vector Design Tool");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setupGUI();
        draw = new DrawTool(canvas, buf, _scale);
        new KeybindHandler(canvas);
    }

    public void setupLayers() {
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

    public void setupGUI() {
        pnlColor = new ColorChooser(draw.getPenColor());
        pnlTools = new Tools();
        //History
        setJMenuBar(new MenuBar(pnlTools, pnlColor, pnlHistory));
        setupLayers();
        buf = new Img();
        canvas.add(new CustomPaintComponent(buf));
        canvas.repaint();
        repaint();
    }
}
