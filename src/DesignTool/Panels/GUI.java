package DesignTool.Panels;

import DesignTool.Misc.CustomPaintComponent;
import DesignTool.Misc.DrawTool;
import DesignTool.Misc.KeybindHandler;
import DesignTool.Misc.DrawMouse;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

public class GUI extends JFrame {

    public static final int WIDTH = 400;
    public static final int HEIGHT = 400;
    public static float _scale = 400;

    private static BufferedImage buf;
    private static Color _penColor = new Color(0, 0, 0);

    public static DrawTool draw;
    private JPanel _canvas;
    private JLayeredPane _layeredPane;
    public static JPanel _pnlColor;
    public static JPanel _pnlTools;
    public static JPanel _pnlHistory;
    public static JPanel _pnlCoords;

    public GUI() {
        super("Vector Design Tool");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setupGUI();
        draw = new DrawTool(_canvas, buf, _penColor, _scale);
        new KeybindHandler(_canvas);


    }

    public void setupLayers() {
        _layeredPane = getLayeredPane();
        _canvas = new JPanel(this.getLayout());
        _canvas.setBackground(Color.WHITE);
        _canvas.setBounds(250, 250, 401, 401);
        _layeredPane.setLayer(_pnlTools, JLayeredPane.DRAG_LAYER);
        _layeredPane.setLayer(_canvas, JLayeredPane.DEFAULT_LAYER);
        _layeredPane.setLayer(_pnlColor, JLayeredPane.DRAG_LAYER);
        _layeredPane.setLayer(_pnlHistory, JLayeredPane.DRAG_LAYER);
        _layeredPane.setLayer(_pnlCoords, JLayeredPane.DRAG_LAYER);
        _layeredPane.add(_pnlTools);
        _layeredPane.add(_canvas);
        _layeredPane.add(_pnlColor);
        _layeredPane.add(_pnlHistory);
        _layeredPane.add(_pnlCoords);
        repaint();
        setVisible(true);
    }

    public void setupGUI() {
        _pnlColor = new ColorChooser(_penColor);
        _pnlTools = new Tools();
        _pnlHistory = new History();
        _pnlCoords = new Coords();
        setJMenuBar(new MenuBar(_pnlTools, _pnlColor, _pnlHistory, _pnlCoords));
        setupLayers();
        buf = new Img();
        _canvas.add(new CustomPaintComponent(buf));
        _canvas.repaint();
        repaint();
    }
}