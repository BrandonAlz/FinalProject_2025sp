/*package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class MON_GreenSlime extends Entity {

    public MON_GreenSlime(GamePanel gp) {
        super(gp);

        name = "Green Slime";
        speed = 1;
        direction = "down";
        maxLife = 4;
        life = maxLife;

        /*
        solidArea.x = 3;
        solidArea.y = 18;
        solidArea.width = 42;
        solidArea.height = 30;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

         */

        //getSlimeImage();
        /*
    }

    public void getSlimeImage(){

        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/npc/Slime_Start_End.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/npc/Slime_Start_End.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/npc/Slime_Start_End.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/npc/Slime_Start_End.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/npc/Slime_Start_End.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/npc/Slime_Start_End.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/npc/Slime_Start_End.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/npc/Slime_Start_End.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Old man AI for right now
    public void setAction(){

        actionLockCounter ++;

        if(actionLockCounter == 120){
            Random random = new Random();
            int i = random.nextInt(100)+1;

            if(i <= 25){
                direction = "up";
            }
            if(i > 25 && i <= 50){
                direction = "down";
            }
            if(i > 50 && i <= 75){
                direction = "left";
            }
            if(i > 75 && i <= 100){
                direction = "right";
            }

            actionLockCounter = 0;
        }
    }
}

         */
