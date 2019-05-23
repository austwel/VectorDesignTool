package DesignTool;

import java.awt.*;

public class CustomPaintComponent extends Component {

    public void paint(Graphics g) {
        Graphics2D graphics = (Graphics2D)g;
        int x = 0;
        int y = 0;
        graphics.drawImage(GUI.getImage(), x, y, this);
    }
}
