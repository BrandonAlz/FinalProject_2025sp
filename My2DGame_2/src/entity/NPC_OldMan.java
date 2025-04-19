package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class NPC_OldMan extends Entity{

    public NPC_OldMan (GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 1;
        getOldManImage();
        setDialogue();
    }

    public void getOldManImage(){

        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/npc/Oldman_Back_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/npc/Oldman_Back_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/npc/Oldman_Front_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/npc/Oldman_Front_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/npc/Oldman_Left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/npc/Oldman_Left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/npc/Oldman_Right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/npc/Oldman_Right_2.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    // NPC "Ai" it just does a random number and each case is 25% likely to get chosen
    // This is also locked behind 120 frames so it doesn't make the NPC go nuts on the screen
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

    public void setDialogue(){

        dialogues[0] = "I am an old man lmao";
        dialogues[1] = "But I am unfinished";
        dialogues[2] = "isn't that so sad?";
        dialogues[3] = "Here is a very long line so I can practice indenting \nbecause paint component doesn't do regular \nline breaks!!!";
    }

    public void speak(){

        if (dialogues[dialogueIndex] == null){
            dialogueIndex = 0;
        }
        gp.ui.currentDialogue = dialogues[dialogueIndex];
        dialogueIndex++;

        // WILL BE USED WHEN OLD MAN HAS SOME DAMN SPRITES
        switch(gp.player.direction){
            case "up":
                direction = "down";
            case "down":
                direction = "up";
            case "left":
                direction = "right";
            case "right":
                direction = "left";

        }
    }
}
