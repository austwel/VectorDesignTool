package guiExploration;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FramesAndPanels extends JFrame implements ActionListener, Runnable {

    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;

    private JPanel pnlOne;
    private JPanel pnlTwo;
    private JPanel pnlThree;
    private JPanel pnlFour;
    private JPanel pnlFive;

    public FramesAndPanels(String title) throws HeadlessException {
        super(title);
    }

    private void createGUI() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        pnlOne = createPanel(Color.WHITE);
        pnlTwo = createPanel(Color.BLACK);
        pnlThree = createPanel(Color.RED);
        pnlFour = createPanel(Color.GREEN);
        pnlFive = createPanel(Color.BLUE);
        getContentPane().add(pnlOne, BorderLayout.CENTER);
        getContentPane().add(pnlTwo, BorderLayout.PAGE_START);
        getContentPane().add(pnlThree, BorderLayout.PAGE_END);
        getContentPane().add(pnlFour, BorderLayout.LINE_START);
        getContentPane().add(pnlFive, BorderLayout.LINE_END);
        repaint();
        setVisible(true);
    }

    private JPanel createPanel(Color c) {
        JPanel panel = new JPanel();
        panel.setBackground(c);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void run() {
        createGUI();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new FramesAndPanels("BorderLayout"));
    }
}
