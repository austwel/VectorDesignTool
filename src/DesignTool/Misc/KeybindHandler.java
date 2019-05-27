package DesignTool.Misc;

import DesignTool.Actions.*;

import javax.swing.*;

public class KeybindHandler {

    private JPanel _canvas;

    public KeybindHandler(JPanel canvas) {
        _canvas = canvas;
        addKeybind("control N", "New", new NewAction());
        addKeybind("control O", "Open", new OpenAction());
        addKeybind("control S", "Save", new SaveAction());
        addKeybind("control Z", "Undo", new UndoAction());
        addKeybind("control Y", "Redo", new RedoAction());
    }

    public void addKeybind(String stroke, String key, Action action) {
        _canvas.getInputMap(2).put(KeyStroke.getKeyStroke(stroke), key);
        _canvas.getActionMap().put(key, action);
    }

}
