package DesignTool;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class vecFile {

    private static PrintWriter outputFile;
    private static FileReader inputFile;
    private static ArrayList<ArrayList<String>> commands = new ArrayList<>();

    public vecFile() throws IOException {
        setupOutput();
    }

    public void saveFile() throws IOException {
        outputFile.close();
    }

    public void setupOutput() throws IOException {
        outputFile = new PrintWriter(new FileWriter("output.vec", false));
    }

    public void openFile(String filepath) throws IOException {
        File file = new File(filepath);
        if (file.exists()) {
            inputFile = new FileReader(file);
            int c;
            String s = "";
            while((c=inputFile.read())!=-1) {
                s += (char) c;
            }
            String[] commandList = s.split("\n");
            for(String str : commandList) {
                String[] strs = str.split(" ");
                ArrayList<String> command = new ArrayList<>();
                for(String value : strs) {
                    command.add(value);
                }
                commands.add(command);
            }
            runFile();
        }
    }

    public void runFile() throws IOException {
        for (ArrayList<String> command : commands) {
            executeCommand(command);
        }
    }

    public static void outputPen(String color) {
        //outputFile.printf("PEN %s", color);
    }

    public void outputFill(String color) {
        //outputFile.printf("FILL %s", color);
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
        for (Float value : values) {
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
                 Main.drawLine(
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
                Main.drawRectangle(
                        Float.valueOf(command.get(1)),
                        Float.valueOf(command.get(2)),
                        Float.valueOf(command.get(3)),
                        Float.valueOf(command.get(4)));
                break;
            case "PLOT":
                outputPlot(
                        Float.valueOf(command.get(1)),
                        Float.valueOf(command.get(2)));
                Main.drawPlot(
                        Float.valueOf(command.get(1)),
                        Float.valueOf(command.get(2)));
                break;
            case "ELLIPSE":
                outputEllipse(
                        Float.valueOf(command.get(1)),
                        Float.valueOf(command.get(2)),
                        Float.valueOf(command.get(3)),
                        Float.valueOf(command.get(4)));
                Main.drawEllipse(
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
                Main.drawPolygon(values);
                break;
            case "FILL":
                //outputFill(command.get(1));
                //Main.startFill(command.get(1));
                break;
            case "PEN":
                outputPen(command.get(1));
                Main.changePen(command.get(1));
                break;
        }
    }
}
