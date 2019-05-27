package DesignTool.Misc;

import DesignTool.Main;

import java.io.*;
import java.util.ArrayList;

public class Io {

    private static PrintWriter outputFile;
    private static FileReader inputFile;
    private ArrayList<String> _history;
    private static ArrayList<ArrayList<String>> commands = new ArrayList<>();

    public Io(ArrayList<String> history) throws IOException {
        _history = history;
        setupOutput();
    }

    public void saveFile(ArrayList<String> out) {
        output(out);
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
                _history.add(str);
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

    public void output(ArrayList<String> out) {
        for(String command : out) {
            outputFile.printf("%s\n", command);
        }
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