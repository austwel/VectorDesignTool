package DesignTool;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    private static GUI tool;
    private static vecFile v;

    public static void main(String[] args) throws IOException {
        tool = new GUI();
        v = new vecFile();
    }

    public static void drawLine(Float x1, Float y1, Float x2, Float y2) throws IOException {
        v.output(String.format("LINE %.6f %.6f %.6f %.6f", x1,y1,x2,y2));
        tool.drawLine(x1,y1,x2,y2);
    }

    public static void drawRectangle(Float x1, Float y1, Float x2, Float y2) throws IOException {
        tool.drawRectangle(x1,y1,x2,y2);
        v.output(String.format("RECTANGLE %.6f %.6f %.6f %.6f", x1,y1,x2,y2));
    }

    public static void drawPlot(Float x, Float y) throws IOException {
        tool.drawPlot(x,y);
        v.output(String.format("PLOT %.6f %.6f", x,y));
    }

    public static void drawEllipse(Float x1, Float y1, Float x2, Float y2) throws IOException {
        tool.drawEllipse(x1,y1,x2,y2);
        v.output(String.format("ELLIPSE %.6f %.6f %.6f %.6f", x1,y1,x2,y2));
    }

    public static void drawPolygon(ArrayList<Float> values) throws IOException {
        tool.drawPolygon(values);
        v.outputPolygon(values);
    }

    public static void endFill() throws IOException {
        tool.endFill();
        v.output("FILL OFF");
    }

    public static void startFill(String color) throws IOException {
        tool.startFill(Color.decode(color.substring(0, 7)));
        v.output(String.format("FILL %s", color));
    }

    public static void changePen(String color) throws IOException {
        tool.changePen(Color.decode(color.substring(0, 7)));
        v.output(String.format("PEN %s", color));
    }

    public static void openVec(String filePath) {
        try {
            v.openFile(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveVec() {
        try {
            v.saveFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
