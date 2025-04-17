package object;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {

    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int x, y;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;
    public static String[] dialogues = new String[20];
    static GamePanel gp;

    public void draw(Graphics2D g2, GamePanel gp) {

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
            if (col == gp.obj[0].x && row == gp.obj[0].y) {
                        g2.drawImage(gp.obj[0].image, x, y, gp.tileSize, gp.tileSize, null);
            }

            if (col == gp.obj[1].x && row == gp.obj[1].y) {
                        g2.drawImage(gp.obj[1].image, x, y, gp.tileSize, gp.tileSize, null);
            }

            if (col == gp.obj[2].x && row == gp.obj[2].y) {
                        g2.drawImage(gp.obj[2].image, x, y, gp.tileSize, gp.tileSize, null);
            }

            if (col == gp.obj[3].x && row == gp.obj[3].y) {
                g2.drawImage(gp.obj[3].image, x, y, gp.tileSize, gp.tileSize, null);
            }

            if (col == gp.obj[4].x && row == gp.obj[4].y) {
                g2.drawImage(gp.obj[4].image, x, y, gp.tileSize, gp.tileSize, null);
            }

            if (col == gp.obj[5].x && row == gp.obj[5].y) {
                g2.drawImage(gp.obj[5].image, x, y, gp.tileSize, gp.tileSize, null);
            }

            if (col == gp.obj[6].x && row == gp.obj[6].y) {
                g2.drawImage(gp.obj[6].image, x, y, gp.tileSize, gp.tileSize, null);
            }

            //if (col == gp.obj[7].x && row == gp.obj[7].y) {
            //   g2.drawImage(gp.obj[7].image, x, y, gp.tileSize, gp.tileSize, null);
            //}

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