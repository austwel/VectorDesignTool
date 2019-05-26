package DesignTool;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ColorChooser extends JPanel implements ChangeListener {

    private JColorChooser colorChooser;
    private Color _penColor;

    public ColorChooser(Color penColor) {
        _penColor = penColor;
        colorChooser = new JColorChooser();
        colorChooser.setPreviewPanel(new JPanel());
        colorChooser.getSelectionModel().addChangeListener(this);
        colorChooser.setBounds(0, 0, 400, 200);
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Color"));
        setSize(614, 250);
        setLocation(270, 670);
        add(colorChooser, BorderLayout.SOUTH);
        new DragHandler(this);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        _penColor = colorChooser.getColor();
    }
}
