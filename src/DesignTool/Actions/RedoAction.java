package DesignTool.Actions;

import DesignTool.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RedoAction extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent e) {
        Main.redo();
    }
}
