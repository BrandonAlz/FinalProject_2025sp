package entity;

import main.GamePanel;
import main.KeyHandler2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player2 extends Entity{

    // We use game panel and key handler
    KeyHandler2 keyH2;

    // Key and Hotdog counter

    public Player2(GamePanel gp, KeyHandler2 keyH2){
        super(gp);

        this.keyH2 = keyH2;

        solidArea = new Rectangle();
        solidArea.x = 12;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 24;
        solidArea.height = 28;

        setDefaultValues();
        getPlayerImage();
    }

    // This is the default spawn of the player character
    public void setDefaultValues(){

        x = 15 * gp.tileSize;
        y = 15 * gp.tileSize;
        speed = 4;
        direction = "down";
    }

    // This assigns an image to a direction in a try catch
    public void getPlayerImage(){

        try{

            up1 = ImageIO.read(getClass().getResourceAsStream("/player/Mage_Back_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/Mage_Back_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/Mage_Front_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/Mage_Front_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/Mage_Left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/Mage_Left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/Mage_Right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/Mage_Right_2.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    // During updates this makes it so we can actually move and assigns a direction to the key
    // we pressed so we can get the right sprite
    public void update(){

        if (keyH2.upPressed2 == true || keyH2.downPressed2 == true || keyH2.leftPressed2 == true || keyH2.rightPressed2 == true){

            if (keyH2.upPressed2 == true){
                direction = "up";
            }
            else if (keyH2.downPressed2 == true){
                direction = "down";
            }
            else if (keyH2.leftPressed2 == true){
                direction = "left";
            }
            else if (keyH2.rightPressed2 == true){
                direction = "right";
            }

            // Check tile collision, if collision is false player can move.
            // If collision is
            collisionOn = false;
            gp.cChecker.checkTile(this);

            // Check object collision
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);

            // Check NPC collision
            int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
            //interactNPC(npcIndex);

            if (collisionOn == false){

                switch(direction){
                    case "up":
                        y -= speed;
                        break;
                    case "down":
                        y += speed;
                        break;
                    case "left":
                        x -= speed;
                        break;
                    case "right":
                        x += speed;
                        break;

                }
            }

            // Makes it so the player sprite changes every 12 frames only when a key is being pressed
            // Basically, the sprite counter is tied to update, which is updating 60 times a second
            // Once the counter reaches 13 frames (Above 12) it will change the spriteNum to 1 or 2
            // Then the counter will reset itself, and we do it again
            spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                }
                else if (spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void pickUpObject(int i){
        if(i != 999){
            String objectName = gp.obj[i].name;

            switch(objectName) {
                case "Key":
                    gp.obj[i] = null;
                    //gp.obj[i].name = "no name monka";
                    hasKey++;
                    //gp.obj[i].image = ImageIO.read(getClass().getResourceAsStream("/objects/Nothing.png"));
                    //gp.obj[i].collision = false;
                    System.out.println("Keys: " + hasKey);
                    break;
                case "Door":
                case "Chest":
                    if(hasKey > 0){
                        gp.obj[i] = null;
                        //gp.obj[i].name = "no name monka2";
                        //gp.obj[i].image = ImageIO.read(getClass().getResourceAsStream("/objects/Nothing.png"));
                        //gp.obj[i].collision = false;
                        hasKey--;
                        System.out.println("Keys: " + hasKey);
                    }
                    break;
                // Might be able to put the player speed back down by implementing a counter every time frames hit 60 and then do like 5 times of that lower speed again
                // That way the player can only get a power-up for a specific amount of time
                // ORRRR maybe they keep the power-up on the map and it resets speed when loading to a different map!
                case "Hotdog":
                    gp.obj[i] = null;
                    //gp.obj[i].name = "no name again";
                    speed += 2;
                    hasHotdog++;
                    //gp.obj[i].image = ImageIO.read(getClass().getResourceAsStream("/objects/Nothing.png"));
                    //gp.obj[i].collision = false;
                    System.out.println("Hotdogs: " + hasHotdog);
                    break;
            }
            //gp.obj[i].image = ImageIO.read(getClass().getResourceAsStream("/objects/Nothing.png"));
            //gp.obj[i].collision = false;
        }
    }

    // Draws the graphics
    public void draw(Graphics2D g2){
        // Setting image null it will change as we input
        BufferedImage image = null;
        // This will switch depending on the case. As the game updates, the png will change depending on direction and pngs tied to it.
        switch(direction){
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
