package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Oldman extends SuperObject{

    public OBJ_Oldman(){
        setDialogue();
        name = "Oldman";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/OldMan.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
        collision = true;
    }

    public void setDialogue(){

        dialogues[0] = "I am old man lmao";
    }

    public void speak(){

        gp.ui.currentDialogue = dialogues[0];
    }
}
