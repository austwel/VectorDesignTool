package DesignTool.Actions;

import DesignTool.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class OpenAction extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent e) {
        Main.openVec();
    }
}
