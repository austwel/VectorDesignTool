package DesignTool;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    private static GUI tool;
    private static vecFile v;

    public static void main(String[] args) throws IOException {
        tool = new GUI("Tool");
        tool.setupGUI();
        v = new vecFile();
    }

    public static void drawLine(Float x1, Float y1, Float x2, Float y2) throws IOException {
        v.outputLine(x1,y1,x2,y2);
        tool.drawLine(x1,y1,x2,y2);
    }

    public static void drawRectangle(Float x1, Float y1, Float x2, Float y2) throws IOException {
        tool.drawRectangle(x1,y1,x2,y2);
        v.outputRectangle(x1,y1,x2,y2);
    }

    public static void drawPlot(Float x, Float y) throws IOException {
        tool.drawPlot(x,y);
        v.outputPlot(x,y);
    }

    public static void drawEllipse(Float x1, Float y1, Float x2, Float y2) throws IOException {
        tool.drawEllipse(x1,y1,x2,y2);
        v.outputEllipse(x1,y1,x2,y2);
    }

    public static void drawPolygon(ArrayList<Float> values) throws IOException {
        tool.drawPolygon(values);
        v.outputPolygon(values);
    }

    public static void startFill(String color) throws IOException {
        tool.startFill(color.substring(1));
        v.outputFill(color);
    }

    public static void changePen(String color) throws IOException {
        tool.changePen(color.substring(1));
        v.outputPen(color);
    }

    public static void openVec() {
        try {
            v.openFile("vectors/example1.vec");
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
