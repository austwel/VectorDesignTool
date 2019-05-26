package DesignTool;

import java.awt.*;
import java.awt.image.BufferedImage;

public class CustomPaintComponent extends Component {

    private BufferedImage _i;

    public CustomPaintComponent(BufferedImage i) {
        _i = i;
    }

    public void paint(Graphics g) {
        Graphics2D graphics = (Graphics2D)g;
        int x = 0;
        int y = 0;
        graphics.drawImage(_i, x, y, this);
    }
}
