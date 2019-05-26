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
        menuFile = new JMenu("File");
        menuFile.setMnemonic(KeyEvent.VK_F);
        menuFile.getAccessibleContext().setAccessibleDescription("File Menu");
        menuEdit = new JMenu("Edit");
        menuEdit.setMnemonic(KeyEvent.VK_E);
        menuEdit.getAccessibleContext().setAccessibleDescription("Edit Menu");
        menuView = new JMenu("View");
        menuView.setMnemonic(KeyEvent.VK_V);
        menuView.getAccessibleContext().setAccessibleDescription("View Menu");
        menuNew = new JMenuItem("New", KeyEvent.VK_N);
        menuNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuNew.addActionListener(this);
        menuFile.add(menuNew);
        menuFile.addSeparator();
        menuOpen = new JMenuItem("Open", KeyEvent.VK_O);
        menuOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        menuOpen.addActionListener(this);
        menuFile.add(menuOpen);
        menuFile.addSeparator();
        menuSave = new JMenuItem("Save", KeyEvent.VK_S);
        menuSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.ALT_MASK));
        menuSave.addActionListener(this);
        menuFile.add(menuSave);
        menuFile.addSeparator();
        menuExit = new JMenuItem("Exit", KeyEvent.VK_X);
        menuExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, ActionEvent.ALT_MASK));
        menuExit.addActionListener(this);
        menuFile.add(menuExit);

        menuTools = new JCheckBoxMenuItem("Tools", true);
        menuTools.setMnemonic(KeyEvent.VK_T);
        menuTools.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuTools.addActionListener(this);
        menuView.add(menuTools);
        menuView.addSeparator();
        menuColor = new JCheckBoxMenuItem("Color", true);
        menuColor.setMnemonic(KeyEvent.VK_C);
        menuColor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        menuColor.addActionListener(this);
        menuView.add(menuColor);
        menuView.addSeparator();
        menuHistory = new JCheckBoxMenuItem("History", false);
        menuHistory.setMnemonic(KeyEvent.VK_H);
        menuHistory.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.ALT_MASK));
        menuHistory.addActionListener(this);
        menuView.add(menuHistory);

        add(menuFile);
        add(menuEdit);
        add(menuView);
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
