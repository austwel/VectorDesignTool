package DesignTool.Misc;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class DrawTool {

    private JPanel _canvas;
    private BufferedImage _buf;
    private static Color _penColor;
    private static Color _fillColor;
    private float _scale;
    private boolean _isFill;

    public DrawTool(JPanel canvas, BufferedImage buf, float scale) {
        _canvas = canvas;
        _buf = buf;
        _penColor = new Color(0, 0, 0);
        _fillColor = new Color(0, 0, 0);
        _scale = scale;
        _isFill = false;
    }

    public static Color getPenColor() {
        return _penColor;
    }

    public void changePen(Color color) {
        _penColor = color;
    }

    public void endFill() {
        _isFill = false;
    }

    public void startFill(Color color) {
        _isFill = true;
        _fillColor = color;
    }

    public void drawLine(Float x1, Float y1, Float x2, Float y2) {
        Graphics2D g = _buf.createGraphics();
        g.setColor(_penColor);
        g.draw(new Line2D.Float(Math.round(x1 * _scale), Math.round(y1 * _scale), Math.round(x2 * _scale), Math.round(y2 * _scale)));
        _canvas.repaint();
    }

    public void drawRectangle(Float x1, Float y1, Float x2, Float y2) {
        Graphics2D g = _buf.createGraphics();
        g.setColor(_penColor);
        if (_isFill) {
            g.setPaint(_fillColor);
            g.fill(new Rectangle(Math.round(x1 * _scale), Math.round(y1 * _scale), Math.round((x2 - x1) * _scale), Math.round((y2 - y1) * _scale)));
            g.setColor(_penColor);
            g.draw(new Rectangle(Math.round(x1 * _scale), Math.round(y1 * _scale), Math.round((x2 - x1) * _scale), Math.round((y2 - y1) * _scale)));
        } else {
            g.draw(new Rectangle(Math.round(x1 * _scale), Math.round(y1 * _scale), Math.round((x2 - x1) * _scale), Math.round((y2 - y1) * _scale)));
        }
        _canvas.repaint();
    }

    public void drawPlot(Float x, Float y) {
        Graphics2D g = _buf.createGraphics();
        g.setColor(_penColor);
        g.drawLine(Math.round(x * _scale), Math.round(y * _scale), Math.round(x * _scale), Math.round(y * _scale));
        _canvas.repaint();
    }

    public void drawEllipse(Float x1, Float y1, Float x2, Float y2) {
        Graphics2D g = _buf.createGraphics();
        g.setColor(_penColor);
        if (_isFill) {
            g.setPaint(_fillColor);
            g.fillOval(Math.round(x1 * _scale), Math.round(y1 * _scale), Math.round((x2 - x1) * _scale), Math.round((y2 - y1) * _scale));
            g.setColor(_penColor);
            g.drawOval(Math.round(x1 * _scale), Math.round(y1 * _scale), Math.round((x2 - x1) * _scale), Math.round((y2 - y1) * _scale));
        } else {
            g.drawOval(Math.round(x1 * _scale), Math.round(y1 * _scale), Math.round((x2 - x1) * _scale), Math.round((y2 - y1) * _scale));
        }
        _canvas.repaint();
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
        if (_isFill) {
            g.setPaint(_fillColor);
            g.fill(new Polygon(xArray, yArray, values.size() / 2));
            g.setColor(_penColor);
            g.draw(new Polygon(xArray, yArray, values.size() / 2));
        } else {
            g.draw(new Polygon(xArray, yArray, values.size() / 2));
        }
        _canvas.repaint();
    }

}
