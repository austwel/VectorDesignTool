package DesignTool;

import DesignTool.Misc.Io;
import DesignTool.Panels.GUI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static GUI tool;
    public static Io io;

    private static ArrayList<String> history;

    public static void main(String[] args) throws IOException {
        tool = new GUI();
        history = new ArrayList<>();
        io = new Io(history);
    }

    public static void undo() {
        System.out.println("Undo");
    }

    public static void redo() {
        System.out.println("Redo");
    }

    public static void newFile() {
        history.clear();
        System.out.println("New");
    }

    public static void drawLine(Float x1, Float y1, Float x2, Float y2) {
        tool.draw.drawLine(x1,y1,x2,y2);
    }

    public static void drawRectangle(Float x1, Float y1, Float x2, Float y2) {
        tool.draw.drawRectangle(x1,y1,x2,y2);
    }

    public static void drawPlot(Float x, Float y) {
        tool.draw.drawPlot(x,y);
    }

    public static void drawEllipse(Float x1, Float y1, Float x2, Float y2) {
        tool.draw.drawEllipse(x1,y1,x2,y2);
    }

    public static void drawPolygon(ArrayList<Float> values) {
        tool.draw.drawPolygon(values);
    }

    public static void endFill() {
        tool.draw.endFill();
    }

    public static void startFill(String color) {
        tool.draw.startFill(Color.decode(color.substring(0, 7)));
    }

    public static void changePen(String color) {
        tool.draw.changePen(Color.decode(color.substring(0, 7)));
    }

    public static void changePenColor(Color color) { tool.draw.changePen(color); }

    public static void openVec() {
        newFile();
        JFileChooser fileChooser = new JFileChooser();
        int r = fileChooser.showOpenDialog(tool);
        if (r == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            try {
                Main.changePen("#000000");
                io.openFile(filePath);
            } catch (IOException ex) {

            }
        }
    }

    public static void saveVec() {
        io.saveFile(history);
    }

}