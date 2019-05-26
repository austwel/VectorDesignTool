package DesignTool;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class MenuBar extends JMenuBar implements ActionListener {

    public JMenu menuFile, menuEdit, menuView;
    public JMenuItem menuNew, menuOpen, menuSave, menuExit;
    public JMenuItem menuUndo, menuRedo;
    public JCheckBoxMenuItem menuTools, menuColor, menuHistory;

    private JPanel _tools;
    private JPanel _color;
    private JPanel _history;


    public MenuBar(JPanel tools, JPanel color, JPanel history) {
        _tools = tools;
        _color = color;
        _history = history;

        createFile();
        createEdit();
        createView();
    }

    public void createFile() {
        menuFile = createMenu("File", KeyEvent.VK_F);
        menuNew = createMenuItem("New", KeyEvent.VK_N, KeyEvent.VK_1);
        menuFile.add(menuNew);
        menuFile.addSeparator();
        menuOpen = createMenuItem("Open", KeyEvent.VK_O, KeyEvent.VK_2);
        menuFile.add(menuOpen);
        menuFile.addSeparator();
        menuSave = createMenuItem("Save", KeyEvent.VK_S, KeyEvent.VK_3);
        menuFile.add(menuSave);
        menuFile.addSeparator();
        menuExit = createMenuItem("Exit", KeyEvent.VK_X, KeyEvent.VK_4);
        menuFile.add(menuExit);
        add(menuFile);
    }

    public void createEdit() {
        menuEdit = createMenu("Edit", KeyEvent.VK_E);
        add(menuEdit);
    }

    public void createView() {
        menuView = createMenu("View", KeyEvent.VK_V);
        menuTools = createCheckBoxMenuItem("Tools", KeyEvent.VK_1, KeyEvent.VK_T, true);
        menuView.add(menuTools);
        menuView.addSeparator();
        menuTools = createCheckBoxMenuItem("Color", KeyEvent.VK_2, KeyEvent.VK_C, true);
        menuView.add(menuColor);
        menuView.addSeparator();
        menuTools = createCheckBoxMenuItem("History", KeyEvent.VK_3, KeyEvent.VK_H, false);
        menuView.add(menuHistory);
        add(menuView);
    }

    public JMenuItem createMenuItem(String text, int keyEventText, int keyEventNum) {
        JMenuItem item = new JMenuItem(text, keyEventText);
        item.setAccelerator(KeyStroke.getKeyStroke(keyEventNum, ActionEvent.ALT_MASK));
        item.addActionListener(this);
        return item;
    }

    public JCheckBoxMenuItem createCheckBoxMenuItem(String text, int keyEventText, int keyEventNum, boolean active) {
        JCheckBoxMenuItem item = new JCheckBoxMenuItem(text, active);
        item.setMnemonic(keyEventText);
        item.setAccelerator(KeyStroke.getKeyStroke(keyEventNum, ActionEvent.ALT_MASK));
        item.addActionListener(this);
        return item;
    }

    public JMenu createMenu(String text, int keyEvent) {
        JMenu menu = new JMenu(text);
        menu.setMnemonic(keyEvent);
        return menu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == menuOpen) {
            JFileChooser fileChooser = new JFileChooser();
            int r = fileChooser.showOpenDialog(MenuBar.this);
            if (r == JFileChooser.APPROVE_OPTION) {
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                try {
                    Main.changePen("#000000");
                } catch (IOException ex) {

                }
                //Main.isFill = false;
                Main.openVec(filePath);
            }
        } else if (src == menuSave) {
            Main.saveVec();
        } else if (src == menuTools) {
            if (menuTools.getState()) {
                _tools.setVisible(true);
            } else {
                _tools.setVisible(false);
            }
        } else if (src == menuColor) {
            if (menuColor.getState()) {
                _color.setVisible(true);
            } else {
                _color.setVisible(false);
            }
        } else if (src == menuHistory) {
            if (menuHistory.getState()) {
                _history.setVisible(true);
            } else {
                _history.setVisible(false);
            }
        }
    }
}
