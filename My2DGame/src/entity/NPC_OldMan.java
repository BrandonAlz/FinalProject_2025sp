package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class NPC_OldMan extends Entity{

    public NPC_OldMan (GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 0;
        getOldManImage();
        setDialogue();
    }

    public void getOldManImage(){

        try{
            down1 = ImageIO.read(getClass().getResourceAsStream("/npc/OldMan.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void setDialogue(){

        dialogues[0] = "I am an old man lmao";
        dialogues[1] = "But I am unfinished";
        dialogues[2] = "isn't that so sad?";
        dialogues[3] = "Here is a very long line so I can practice indenting because paint component doesn't do regular line breaks!!!";
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
