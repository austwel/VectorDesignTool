package DesignTool;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GUI extends JFrame implements ActionListener, ChangeListener {

    public static final int WIDTH = 400;
    public static final int HEIGHT = 400;
    public static float _scale = 400;

    private static BufferedImage _buf;
    private static Color _penColor = new Color(0, 0, 0);

    private JPanel canvas;
    private JLayeredPane layeredPane;
    private JMenuBar menuBar;
    private JMenu menuFile, menuEdit, menuView;
    private JMenuItem menuNew, menuOpen, menuSave, menuExit;

    private JPanel colorPanel;
    private JColorChooser colorChooser;

    private JPanel pnlTools;
    private JButton btnFill, btnLine, btnRect, btnPlot, btnEllipse, btnPoly;

    public GUI() {
        super("Vector Design Tool");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setupGUI();
    }

    public static BufferedImage getImage() {
        return _buf;
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
        Graphics g = _buf.createGraphics();
        g.setColor(_penColor);
        g.drawLine(Math.round(x1 * _scale), Math.round(y1 * _scale), Math.round(x2 * _scale), Math.round(y2 * _scale));
        canvas.repaint();
    }

    public void drawRectangle(Float x1, Float y1, Float x2, Float y2) {
        Graphics g = _buf.createGraphics();
        g.setColor(_penColor);
        g.drawRect(Math.round(x1 * _scale), Math.round(y1 * _scale), Math.round((x2 - x1) * _scale), Math.round((y2 - y1) * _scale));
        canvas.repaint();
    }

    public void drawPlot(Float x, Float y) {
        Graphics g = _buf.createGraphics();
        g.setColor(_penColor);
        g.drawLine(Math.round(x * _scale), Math.round(y * _scale), Math.round(x * _scale), Math.round(y * _scale));
        canvas.repaint();
    }

    public void drawEllipse(Float x1, Float y1, Float x2, Float y2) {
        Graphics g = _buf.createGraphics();
        g.setColor(_penColor);
        g.drawOval(Math.round(x1 * _scale), Math.round(y1 * _scale), Math.round((x2 - x1) * _scale), Math.round((y2 - y1) * _scale));
        canvas.repaint();
    }

    public void drawPolygon(ArrayList<Float> values) {
        Graphics2D g = _buf.createGraphics();
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

    public void handleDrag(final JPanel panel){
        final int[] x = new int[1];
        final int[] y = new int[1];
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                x[0] = me.getX();
                y[0] = me.getY();
            }
        });
        panel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                me.translatePoint(me.getComponent().getLocation().x- x[0], me.getComponent().getLocation().y- y[0]);
                panel.setLocation(me.getX(), me.getY());
            }
        });
    }

    public void setupTools() {
        pnlTools = new JPanel(new GridBagLayout());
        pnlTools.setBorder(BorderFactory.createTitledBorder("Tools"));
        GridBagConstraints constraints = new GridBagConstraints();
        Dimension dimension = new Dimension(110, 50);
        pnlTools.setLocation(500, 200);
        pnlTools.setSize(240, 180);
        constraints.gridx = 0;
        constraints.gridy = 0;
        btnFill = new JButton();
        btnFill.setText("Fill");
        btnFill.setPreferredSize(dimension);
        btnFill.addActionListener(this);
        pnlTools.add(btnFill, constraints);
        constraints.gridx++;
        btnLine = new JButton();
        btnLine.setText("Line");
        btnLine.setPreferredSize(dimension);
        btnLine.addActionListener(this);
        pnlTools.add(btnLine, constraints);
        constraints.gridx = 0;
        constraints.gridy++;
        btnRect = new JButton();
        btnRect.setText("Rectangle");
        btnRect.setPreferredSize(dimension);
        btnRect.addActionListener(this);
        pnlTools.add(btnRect, constraints);
        constraints.gridx++;
        btnPlot = new JButton();
        btnPlot.setText("Plot");
        btnPlot.setPreferredSize(dimension);
        btnPlot.addActionListener(this);
        pnlTools.add(btnPlot, constraints);
        constraints.gridx = 0;
        constraints.gridy++;
        btnEllipse = new JButton();
        btnEllipse.setText("Ellipse");
        btnEllipse.setPreferredSize(dimension);
        btnEllipse.addActionListener(this);
        pnlTools.add(btnEllipse, constraints);
        constraints.gridx++;
        btnPoly = new JButton();
        btnPoly.setText("Polygon");
        btnPoly.setPreferredSize(dimension);
        btnPoly.addActionListener(this);
        pnlTools.add(btnPoly, constraints);
        handleDrag(pnlTools);
    }

    public void setupPanels() {
        layeredPane = getLayeredPane();
        canvas = new JPanel(this.getLayout());
        canvas.setBackground(Color.WHITE);
        canvas.setBounds(200, 200, 401, 401);
        layeredPane.setLayer(pnlTools, JLayeredPane.DRAG_LAYER);
        layeredPane.setLayer(canvas, JLayeredPane.DEFAULT_LAYER);
        layeredPane.setLayer(colorPanel, JLayeredPane.DRAG_LAYER);
        layeredPane.add(pnlTools);
        layeredPane.add(canvas);
        layeredPane.add(colorPanel);
        repaint();
        setVisible(true);
    }

    public void setupBufferedImage() {
        _buf = new BufferedImage(401, 401, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = _buf.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, _buf.getWidth(), _buf.getHeight());
    }

    public void setupColorChooser() {
        colorChooser = new JColorChooser();
        colorChooser.setPreviewPanel(new JPanel());
        colorChooser.getSelectionModel().addChangeListener(this);
        colorChooser.setBounds(0, 0, 400, 200);
        colorPanel = new JPanel(new BorderLayout());
        colorPanel.setBorder(BorderFactory.createTitledBorder("Color"));
        colorPanel.setSize(614, 250);
        colorPanel.setLocation(10, 50);
        colorPanel.add(colorChooser, BorderLayout.SOUTH);
        handleDrag(colorPanel);
    }

    public void setupMenu() {
        menuBar = new JMenuBar();
        menuFile = new JMenu("File");
        menuFile.getAccessibleContext().setAccessibleDescription("File Menu");
        menuEdit = new JMenu("Edit");
        menuEdit.getAccessibleContext().setAccessibleDescription("Edit Menu");
        menuView = new JMenu("View");
        menuView.getAccessibleContext().setAccessibleDescription("View Menu");
        menuNew = new JMenuItem("New", KeyEvent.VK_N);
        menuNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuNew.getAccessibleContext().setAccessibleDescription("");
        menuNew.addActionListener(this);
        menuFile.add(menuNew);
        menuFile.addSeparator();
        menuOpen = new JMenuItem("Open", KeyEvent.VK_O);
        menuOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        menuOpen.getAccessibleContext().setAccessibleDescription("");
        menuOpen.addActionListener(this);
        menuFile.add(menuOpen);
        menuFile.addSeparator();
        menuSave = new JMenuItem("Save", KeyEvent.VK_S);
        menuSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.ALT_MASK));
        menuSave.getAccessibleContext().setAccessibleDescription("");
        menuSave.addActionListener(this);
        menuFile.add(menuSave);
        menuFile.addSeparator();
        menuExit = new JMenuItem("Exit", KeyEvent.VK_X);
        menuExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, ActionEvent.ALT_MASK));
        menuExit.getAccessibleContext().setAccessibleDescription("");
        menuExit.addActionListener(this);
        menuFile.add(menuExit);

        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        menuBar.add(menuView);
        setJMenuBar(menuBar);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        _penColor = colorChooser.getColor();
    }

    public void setupGUI() {
        setupColorChooser();
        setupMenu();
        setupTools();
        setupPanels();
        setupBufferedImage();
        canvas.add(new CustomPaintComponent());
        canvas.repaint();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == menuOpen) {
            JFileChooser fileChooser = new JFileChooser();
            int r = fileChooser.showOpenDialog(GUI.this);
            if (r == JFileChooser.APPROVE_OPTION) {
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                changePen(Color.BLACK);
                //isFill = false;
                Main.openVec(filePath);
            }
        } else if (src == menuSave) {
            Main.saveVec();
        } else if (src == btnFill) {

        } else if (src == btnLine) {
            drawLine(0.2f, 0.2f, 0.8f, 0.8f);
        } else if (src == btnRect) {

        } else if (src == btnPlot) {

        } else if (src == btnEllipse) {

        } else if (src == btnPoly) {

        }
    }
}
