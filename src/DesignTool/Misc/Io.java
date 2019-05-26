package DesignTool.Misc;

import DesignTool.Main;

import java.io.*;
import java.util.ArrayList;

public class Io {

    private static PrintWriter outputFile;
    private static FileReader inputFile;
    private static ArrayList<ArrayList<String>> commands = new ArrayList<>();

    public Io() throws IOException {
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

    public void output(String string) throws IOException {
        outputFile.printf("%s\n", string);
    }

    public void outputPolygon(ArrayList<Float> values) throws IOException {
        String outputString = "POLYGON";
        for (Float value : values) {
            outputString += " " + value.toString();
        }
        outputFile.printf(outputString + "\n");
    }

    public void executeCommand(ArrayList<String> command) throws IOException {
        switch (command.get(0)) {
            case "LINE":
                Main.drawLine(
                        Float.valueOf(command.get(1)),
                        Float.valueOf(command.get(2)),
                        Float.valueOf(command.get(3)),
                        Float.valueOf(command.get(4)));
                break;
            case "RECTANGLE":
                Main.drawRectangle(
                        Float.valueOf(command.get(1)),
                        Float.valueOf(command.get(2)),
                        Float.valueOf(command.get(3)),
                        Float.valueOf(command.get(4)));
                break;
            case "PLOT":
                Main.drawPlot(
                        Float.valueOf(command.get(1)),
                        Float.valueOf(command.get(2)));
                break;
            case "ELLIPSE":
                Main.drawEllipse(
                        Float.valueOf(command.get(1)),
                        Float.valueOf(command.get(2)),
                        Float.valueOf(command.get(3)),
                        Float.valueOf(command.get(4)));
                break;
            case "POLYGON":
                ArrayList<Float> values = new ArrayList<>();
                int valueNum = 0;
                for (String value : command) {
                    if (valueNum>0) {
                        values.add(Float.parseFloat(value));
                    }
                    valueNum++;
                }
                Main.drawPolygon(values);
                break;
            case "FILL":
                if (command.get(1).length() < 5) {
                    Main.endFill();
                } else {
                    Main.startFill(command.get(1));
                }
                break;
            case "PEN":
                Main.changePen(command.get(1));
                break;
        }
    }
}