package monster;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class MON_GreenSlime extends Entity {

    public MON_GreenSlime(GamePanel gp) {
        super(gp);

        type = 2;
        name = "Green Slime";
        speed = 1;
        direction = "down";
        maxLife = 4;
        life = maxLife;

        solidArea.x = 3;
        solidArea.y = 18;
        solidArea.width = 42;
        solidArea.height = 30;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getSlimeImage();
    }

    public void update() {

        System.out.println("Updating " + name);
        System.out.println("Monster X: " + x + ", Y: " + y + ", Direction: " + direction);
        setAction();
        collisionOn = false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObject(this, false);
        gp.cChecker.checkEntity(this, gp.npc);
        gp.cChecker.checkEntity(this, gp.monster);
        //gp.cChecker.checkEntity(this, new Entity[][]{gp.player});
        boolean contactPlayer = gp.cChecker.checkPlayer(this);

        if(this.type == 2 && contactPlayer == true){
            if(gp.player.invincible == false){
                gp.player.life -= 1;
                gp.player.invincible = true;
            }
        }

        if (collisionOn == false) {
            switch (direction) {
                case "up": y -= speed; break;
                case "down": y += speed; break;
                case "left": x -= speed; break;
                case "right": x += speed; break;
            }
        }
        spriteCounter++;
        if (spriteCounter > 4) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 3;
            } else if (spriteNum == 3){
                spriteNum = 4;
            } else if (spriteNum == 4){
                spriteNum = 5;
            } else if (spriteNum == 5){
                spriteNum = 6;
            } else if (spriteNum == 6){
                spriteNum = 7;
            } else if (spriteNum == 7){
                spriteNum = 8;
            } else if (spriteNum == 8){
                spriteNum = 9;
            } else if (spriteNum == 9){
                spriteNum = 10;
            } else if (spriteNum == 10){
                spriteNum = 11;
            } else if (spriteNum == 11){
                spriteNum = 12;
            } else if (spriteNum == 12){
                spriteNum = 1;
            }
            spriteCounter = 0;
        }

        if(invincible == true){
            invincibleCounter++;
            if (invincibleCounter > 30){
                invincible = false;
                invincibleCounter = 0;
            }
        }
    }

    public void getSlimeImage(){

        try {
            one = ImageIO.read(getClass().getResourceAsStream("/npc/Slime_Start_End.png"));
            two = ImageIO.read(getClass().getResourceAsStream("/npc/Slime_2_12.png"));
            three = ImageIO.read(getClass().getResourceAsStream("/npc/Slime_3_11.png"));
            four = ImageIO.read(getClass().getResourceAsStream("/npc/Slime_4_10.png"));
            five = ImageIO.read(getClass().getResourceAsStream("/npc/Slime_5.png"));
            six = ImageIO.read(getClass().getResourceAsStream("/npc/Slime_6.png"));
            seven = ImageIO.read(getClass().getResourceAsStream("/npc/Slime_7.png"));
            eight = ImageIO.read(getClass().getResourceAsStream("/npc/Slime_8.png"));
            nine = ImageIO.read(getClass().getResourceAsStream("/npc/Slime_9.png"));
            ten = ImageIO.read(getClass().getResourceAsStream("/npc/Slime_4_10.png"));
            eleven = ImageIO.read(getClass().getResourceAsStream("/npc/Slime_3_11.png"));
            twelve = ImageIO.read(getClass().getResourceAsStream("/npc/Slime_2_12.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Slime AI runs when attacked in direction opposite of player
    public void setAction() {

        // Action lock counter makes it so every 60 seconds the direction has a chance of changing
        // The frame counter makes it so the slime will go through all 12 sprites before attempting to change directions
        actionLockCounter++;
        FrameCounter++;
        if (FrameCounter > 12) {
            if (actionLockCounter == 120) {
                Random random = new Random();
                int i = random.nextInt(100) + 1;

                if (i <= 25) {
                    direction = "up";
                }
                if (i > 25 && i <= 50) {
                    direction = "down";
                }
                if (i > 50 && i <= 75) {
                    direction = "left";
                }
                if (i > 75 && i <= 100) {
                    direction = "right";
                }
                //if (i > 100 && i <= 200) {
                //    speed = 0;
                //}

                actionLockCounter = 0;
            }
        }
    }

    public void damageReaction(){

        // Moves away from the player
        actionLockCounter = 0;
        direction = gp.player.direction;
    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;

        switch (direction) {
            case "up":
            case "right":
            case "left":
            case "down":
                if (spriteNum == 1) {
                    image = one;
                }
                if (spriteNum == 2) {
                    image = two;
                }
                if (spriteNum == 3) {
                    image = three;
                }
                if (spriteNum == 4) {
                    image = four;
                }
                if (spriteNum == 5) {
                    image = five;
                }
                if (spriteNum == 6) {
                    image = six;
                }
                if (spriteNum == 7) {
                    image = seven;
                }
                if (spriteNum == 8) {
                    image = eight;
                }
                if (spriteNum == 9) {
                    image = nine;
                }
                if (spriteNum == 10) {
                    image = ten;
                }
                if (spriteNum == 11) {
                    image = eleven;
                }
                if (spriteNum == 12) {
                    image = twelve;
                }
                break;
        }

        // Monster HP bar
        if(type == 2 && hpBarOn == true) {

            double oneScale = (double)gp.tileSize/maxLife;
            double hpBarValue = oneScale*life;

            g2.setColor(new Color(35, 35, 35));
            g2.fillRect(x - 1, y - 16, gp.tileSize + 2, 12);

            g2.setColor(new Color(255, 0, 30));
            g2.fillRect(x, y - 15, (int)hpBarValue, 10);

            hpBarCounter++;

            if (hpBarCounter > 300){
                hpBarCounter = 0;
                hpBarOn = false;
            }
        }

        if (invincible == true){
            hpBarOn = true;
            hpBarCounter = 0;
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
        }

        if (dying == true){
            dyingAnimation(g2);
        }

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);

        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
    }
}