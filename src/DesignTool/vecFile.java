package DesignTool;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class vecFile {

    private PrintWriter outputFile;
    private ArrayList<ArrayList<String>> commands = new ArrayList<>();

    public void saveFile() throws IOException {
        outputFile.close();
    }

    public void setupOutput() throws IOException {
        outputFile = new PrintWriter(new FileWriter("output.vec", false));
    }

    public void openFile() {

    }

    public void runFile() throws IOException {
        for (ArrayList<String> command : commands) {
            executeCommand(command);
        }
    }

    public void outputPen(String color) {
        outputFile.printf("PEN %s", color);
    }

    public void outputFill(String color) {
        outputFile.printf("FILL %s", color);
    }

    public void outputLine(Float x1, Float y1, Float x2, Float y2) throws IOException {
        outputFile.printf("LINE %.2f %.2f %.2f %.2f", x1, x2, y1, y2);
    }

    public void outputRectangle(Float x1, Float y1, Float x2, Float y2) throws IOException {
        outputFile.printf("LINE %.2f %.2f %.2f %.2f", x1, x2, y1, y2);
    }

    public void outputPlot(Float x, Float y) throws IOException {
        outputFile.printf("LINE %.2f %.2f", x, y);
    }

    public void outputEllipse(Float x1, Float y1, Float x2, Float y2) throws IOException {
        outputFile.printf("LINE %.2f %.2f %.2f %.2f", x1, x2, y1, y2);
    }

    public void outputPolygon(ArrayList<Float> values) throws IOException {
        String outputString = "POLYGON";
        for(Float value : values) {
            outputString += " " + value.toString();
        }
        outputFile.printf(outputString);
    }

    public void executeCommand(ArrayList<String> command) throws IOException {
        switch (command.get(0)) {
            case "LINE":
                outputLine(
                        Float.valueOf(command.get(1)),
                        Float.valueOf(command.get(2)),
                        Float.valueOf(command.get(3)),
                        Float.valueOf(command.get(4)));
                Tool.drawLine(
                        Float.valueOf(command.get(1)),
                        Float.valueOf(command.get(2)),
                        Float.valueOf(command.get(3)),
                        Float.valueOf(command.get(4)));
                break;
            case "RECTANGLE":
                outputRectangle(
                        Float.valueOf(command.get(1)),
                        Float.valueOf(command.get(2)),
                        Float.valueOf(command.get(3)),
                        Float.valueOf(command.get(4)));
                Tool.drawRectangle(
                        Float.valueOf(command.get(1)),
                        Float.valueOf(command.get(2)),
                        Float.valueOf(command.get(3)),
                        Float.valueOf(command.get(4)));
                break;
            case "PLOT":
                outputPlot(
                        Float.valueOf(command.get(1)),
                        Float.valueOf(command.get(2)));
                Tool.drawPlot(
                        Float.valueOf(command.get(1)),
                        Float.valueOf(command.get(2)));
                break;
            case "ELLIPSE":
                outputEllipse(
                        Float.valueOf(command.get(1)),
                        Float.valueOf(command.get(2)),
                        Float.valueOf(command.get(3)),
                        Float.valueOf(command.get(4)));
                Tool.drawEllipse(
                        Float.valueOf(command.get(1)),
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
                outputPolygon(values);
                Tool.drawPolygon(values);
                break;
            case "FILL":
                outputFill(command.get(1));
                Tool.startFill(command.get(1));
                break;
            case "PEN":
                outputPen(command.get(1));
                Tool.changePen(command.get(1));
                break;
        }
    }
}
