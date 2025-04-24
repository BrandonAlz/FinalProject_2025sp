    package entity;

    import main.GamePanel;
    import main.KeyHandler;

    import javax.imageio.ImageIO;
    import java.awt.*;
    import java.awt.image.BufferedImage;
    import java.io.IOException;

    public class Player extends Entity{

        // We use game panel and key handler
        KeyHandler keyH;


        public Player(GamePanel gp, KeyHandler keyH){
            super(gp);

            type = 0;

            this.gp = gp;
            this.keyH = keyH;

            // The player's hitbox
            solidArea = new Rectangle();
            solidArea.x = 12; // 12
            solidArea.y = 16; // 16
            solidAreaDefaultX = solidArea.x;
            solidAreaDefaultY = solidArea.y;
            solidArea.width = 34; // 24
            solidArea.height = 34; // 28

            // This is the size of the hitbox when the player attcks
            attackArea.width = 60;
            attackArea.height = 60;

            setDefaultValues();
            getPlayerImage();
            getPlayerATKImage();
        }

        // This is the default spawn of the player character
        public void setDefaultValues(){

            x = 15 * gp.tileSize;
            y = 15 * gp.tileSize;
            speed = 4;
            direction = "down";

            // Player stuff
            maxLife = 6;
            life = maxLife;
        }

        // This assigns an image to a direction in a try catch
        public void getPlayerImage(){

            try{

                up1 = ImageIO.read(getClass().getResourceAsStream("/player/New_Mage_Back_1.png"));
                up2 = ImageIO.read(getClass().getResourceAsStream("/player/New_Mage_Back_2.png"));
                down1 = ImageIO.read(getClass().getResourceAsStream("/player/New_Mage_Front_1.png"));
                down2 = ImageIO.read(getClass().getResourceAsStream("/player/New_Mage_Front_2.png"));
                left1 = ImageIO.read(getClass().getResourceAsStream("/player/New_Mage_Left_1.png"));
                left2 = ImageIO.read(getClass().getResourceAsStream("/player/New_Mage_Left_2.png"));
                right1 = ImageIO.read(getClass().getResourceAsStream("/player/New_Mage_Right_1.png"));
                right2 = ImageIO.read(getClass().getResourceAsStream("/player/New_Mage_Right_2.png"));

            }catch (IOException e){
                e.printStackTrace();
            }
        }

        public void getPlayerATKImage(){

            try{

                ATKup1 = ImageIO.read(getClass().getResourceAsStream("/player/New_Mage_Back_ATK_1.png"));
                ATKup2 = ImageIO.read(getClass().getResourceAsStream("/player/New_Mage_Back_ATK_2.png"));
                ATKdown1 = ImageIO.read(getClass().getResourceAsStream("/player/New_Mage_Front_ATK_1.png"));
                ATKdown2 = ImageIO.read(getClass().getResourceAsStream("/player/New_Mage_Front_ATK_2.png"));
                ATKleft1 = ImageIO.read(getClass().getResourceAsStream("/player/New_Mage_Left_ATK_1.png"));
                ATKleft2 = ImageIO.read(getClass().getResourceAsStream("/player/New_Mage_Left_ATK_2.png"));
                ATKright1 = ImageIO.read(getClass().getResourceAsStream("/player/New_Mage_Right_ATK_1.png"));
                ATKright2 = ImageIO.read(getClass().getResourceAsStream("/player/New_Mage_Right_ATK_2.png"));

            }catch (IOException e){
                e.printStackTrace();
            }
        }

        // During updates this makes it so we can actually move and assigns a direction to the key
        // we pressed so we can get the right sprite
        public void update(){

            if(attacking == true){
                attacking();
            }
            else if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true || keyH.enterPressed ==true){

                if (keyH.upPressed == true){
                    direction = "up";
                }
                else if (keyH.downPressed == true){
                    direction = "down";
                }
                else if (keyH.leftPressed == true){
                    direction = "left";
                }
                else if (keyH.rightPressed == true){
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
                interactNPC(npcIndex);

                // Check monster collision
                int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
                contactMonster(monsterIndex);

                // Check Event
                gp.eHandler.checkEvent();

                if (collisionOn == false && keyH.enterPressed == false){

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

            if(invincible == true){
                invincibleCounter++;
                if (invincibleCounter > 60){
                    invincible = false;
                    invincibleCounter = 0;
                }
            }
        }

        public void attacking() {

            spriteCounter++;

            if(spriteCounter <= 5){
                spriteNum = 1;
            }
            if(spriteCounter > 5 && spriteCounter <= 25){
                spriteNum = 2;

                // Saving current x and y of player rectangle
                int currentX = x;
                int currentY = y;
                int solidAreaWidth = solidArea.width;
                int solidAreaHeight = solidArea.height;

                // Now we adjust that rectangle to match the weapon being used
                switch(direction){
                    case"up":
                        y -= attackArea.height;
                        break;
                    case"down":
                        y += attackArea.height;
                        break;
                    case"left":
                        x -= attackArea.width;
                        break;
                    case"right":
                        x += attackArea.width;
                        break;
                }

                // Attack area becomes solid area
                solidArea.width = attackArea.width;
                solidArea.height = attackArea.height;

                // Checking monster collision with the updated rectangles
                int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
                damageMonster(monsterIndex);

                // Resetting the variables we changed
                x = currentX;
                y = currentY;
                solidArea.width = solidAreaWidth;
                solidArea.height = solidAreaHeight;
            }
            if(spriteCounter > 25){
                spriteNum = 1;
                spriteCounter = 0;
                attacking = false;
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
            }
        }

        public void interactNPC(int i){

            if(gp.keyH.enterPressed == true) {
                if (i != 999) {
                        gp.gameState = gp.dialogueState;
                        gp.npc[i].speak();
                } else {
                        attacking = true;
                }
            }
        }

        public void contactMonster(int i) {
            if (i != 999) {
                if (invincible == false) {
                    life -= 1;
                    invincible = true;
                }
            }
        }

        public void damageMonster(int i) {
            if (i != 999) {
                if(gp.monster[i].invincible == false){
                    gp.monster[i].life -= 1;
                    System.out.println("Hit!");
                    gp.monster[i].invincible = true;
                    gp.monster[i].damageReaction();

                    if(gp.monster[i].life <= 0){
                        //gp.monster[i] = null;
                        gp.monster[i].dying = true;
                    }
                }
                else{
                    System.out.println("Miss!");
                }
            }
        }

        // Draws the graphics
        public void draw(Graphics2D g2){
            BufferedImage image = null;
            int drawX = x;
            int drawY = y;
            int drawWidth = gp.tileSize;
            int drawHeight = gp.tileSize;

            switch(direction){
                case "up":
                    if(attacking == false){
                        if (spriteNum == 1) {
                            image = up1;
                        }
                        if (spriteNum == 2) {
                            image = up2;
                        }
                    }
                    if (attacking == true){
                        if (spriteNum == 1) {
                            image = ATKup1;
                            drawY = y - gp.tileSize; // Adjust Y to draw above
                            drawHeight = gp.tileSize * 2;
                        }
                        if (spriteNum == 2) {
                            image = ATKup2;
                            drawY = y - gp.tileSize; // Adjust Y to draw above
                            drawHeight = gp.tileSize * 2;
                        }
                    }
                    break;
                case "down":
                    if(attacking == false){
                        if (spriteNum == 1) {
                            image = down1;
                        }
                        if (spriteNum == 2) {
                            image = down2;
                        }
                    }
                    if (attacking == true){
                        if (spriteNum == 1) {
                            image = ATKdown1;
                            drawHeight = gp.tileSize * 2;
                        }
                        if (spriteNum == 2) {
                            image = ATKdown2;
                            drawHeight = gp.tileSize * 2;
                        }
                    }
                    break;
                case "left":
                    if(attacking == false){
                        if (spriteNum == 1) {
                            image = left1;
                        }
                        if (spriteNum == 2) {
                            image = left2;
                        }
                    }
                    if (attacking == true){
                        if (spriteNum == 1) {
                            image = ATKleft1;
                            drawX = x - gp.tileSize; // Adjust X to draw to the left
                            drawWidth = gp.tileSize * 2;
                        }
                        if (spriteNum == 2) {
                            image = ATKleft2;
                            drawX = x - gp.tileSize; // Adjust X to draw to the left
                            drawWidth = gp.tileSize * 2;
                        }
                    }
                    break;
                case "right":
                    if(attacking == false){
                        if (spriteNum == 1) {
                            image = right1;
                        }
                        if (spriteNum == 2) {
                            image = right2;
                        }
                    }
                    if (attacking == true){
                        if (spriteNum == 1) {
                            image = ATKright1;
                            drawWidth = gp.tileSize * 2;
                        }
                        if (spriteNum == 2) {
                            image = ATKright2;
                            drawWidth = gp.tileSize * 2;
                        }
                    }
                    break;
            }

            if (invincible == true){
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
            }

            // Use the calculated drawX, drawY, drawWidth, and drawHeight
            g2.drawImage(image, drawX, drawY, drawWidth, drawHeight, null);

            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        }
    }
