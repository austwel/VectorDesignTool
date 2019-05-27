package DesignTool.Misc;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DragHandler {

    public DragHandler(final JPanel panel){
        final int[] x = new int[1];
        final int[] y = new int[1];
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                x[0] = me.getX();
                y[0] = me.getY();
            }
        });
        panel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                me.translatePoint(me.getComponent().getLocation().x- x[0], me.getComponent().getLocation().y- y[0]);
                panel.setLocation(me.getX(), me.getY());
            }
        });
    }

}
