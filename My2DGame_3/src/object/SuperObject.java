package object;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {

    public BufferedImage image, image2, image3;
    public String name;
    public boolean collision = false;
    public int x, y;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;
    static GamePanel gp;

    public static BufferedImage scaleImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        BufferedImage scaledImage = new BufferedImage(targetWidth, targetHeight, originalImage.getType());
        Graphics2D g = scaledImage.createGraphics();

        // Improve scaling quality
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        g.dispose();

        return scaledImage;
    }

    public void draw(Graphics2D g2, GamePanel gp) {

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
            for (int i = 0; i < gp.obj.length; i++) {
                if (gp.obj[i] != null) {
                    if (col == gp.obj[i].x && row == gp.obj[i].y) {
                        g2.drawImage(gp.obj[i].image, x, y, gp.tileSize, gp.tileSize, null);
                    }
                }

            }
            col++;
            x += gp.tileSize;

            if (col == gp.maxScreenCol) {
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;

            }
        }
    }
}