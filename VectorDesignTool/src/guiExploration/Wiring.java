package guiExploration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Wiring extends JFrame implements ActionListener, Runnable {

    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;

    private JPanel pnlDisplay;
    private JPanel pnlTwo;
    private JPanel pnlBtn;
    private JPanel pnlFour;
    private JPanel pnlFive;
    private JButton btnLoad;
    private JButton btnUnload;
    private JButton btnFind;
    private JButton btnSwitch;
    private JTextArea areDisplay;

    public Wiring(String title) throws HeadlessException {
        super(title);
    }

    private void setupPanels() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        pnlDisplay = createPanel(Color.WHITE);
        pnlTwo = createPanel(Color.lightGray);
        pnlBtn = createPanel(Color.lightGray);
        pnlFour = createPanel(Color.lightGray);
        pnlFive = createPanel(Color.lightGray);
        getContentPane().add(pnlDisplay, BorderLayout.CENTER);
        getContentPane().add(pnlTwo, BorderLayout.PAGE_START);
        getContentPane().add(pnlBtn, BorderLayout.PAGE_END);
        getContentPane().add(pnlFour, BorderLayout.LINE_START);
        getContentPane().add(pnlFive, BorderLayout.LINE_END);
        repaint();
        setVisible(true);
    }

    private void createGUI() {
        setupPanels();
        btnLoad = createButton("Load");
        btnUnload = createButton("Unload");
        btnFind = createButton("Find");
        btnSwitch = createButton("Switch");
        layoutButtonPanel();
        setupDisplay();
        pnlDisplay.add(areDisplay, BorderLayout.LINE_START);
    }

    private void setupDisplay() {
        areDisplay = new JTextArea();
        areDisplay.setEditable(false);
        areDisplay.setLineWrap(true);
        areDisplay.setFont(new Font("Arial",Font.BOLD,24));
        areDisplay.setBorder(BorderFactory.createEtchedBorder());
    }

    private void layoutButtonPanel() {
        GridBagLayout layout = new GridBagLayout();
        pnlBtn.setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weightx = 100;
        constraints.weighty = 100;
        addToPanel(pnlBtn, btnLoad, constraints, 0, 0, 2, 1);
        addToPanel(pnlBtn, btnUnload, constraints, 3, 0, 2, 1);
        addToPanel(pnlBtn, btnFind, constraints, 0, 2, 2, 1);
        addToPanel(pnlBtn, btnSwitch, constraints, 3, 2, 2, 1);
    }

    private void addToPanel(JPanel jp, Component c, GridBagConstraints constraints, int x, int y, int w, int h) {
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = w;
        constraints.gridheight = h;
        jp.add(c, constraints);
    }

    private JButton createButton(String str) {
        JButton button = new JButton();
        button.setText(str);
        button.addActionListener(this);
        return button;
    }

    private JPanel createPanel(Color c) {
        JPanel panel = new JPanel();
        panel.setBackground(c);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == btnLoad) {
            JButton btn = ((JButton) src);
            areDisplay.setText(btn.getText().trim());
        } else if (src == btnUnload) {
            areDisplay.setText("");
        } else if (src == btnSwitch) {
            JOptionPane.showMessageDialog(this, "A Stupid Warning Message", "Wiring Class: Warning", JOptionPane.WARNING_MESSAGE);
        } else if (src == btnFind) {
            JOptionPane.showMessageDialog(this, "A Stupid Error Message", "Wiring Class: Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void run() {
        createGUI();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Wiring("BorderLayout"));
    }
}
