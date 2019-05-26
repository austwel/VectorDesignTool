package DesignTool;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Img extends BufferedImage {

    public Img() {
        super(401, 401, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

}
