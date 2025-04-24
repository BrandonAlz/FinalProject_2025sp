package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Heart extends SuperObject{

    GamePanel gp;

    public OBJ_Heart(GamePanel gp){

        this.gp = gp;

        name = "Heart";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Full Heart.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/objects/Half Heart.png"));
            image3 = ImageIO.read(getClass().getResourceAsStream("/objects/Empty Heart.png"));
            image = scaleImage(image, (gp.tileSize/5) * 4, (gp.tileSize/5) * 4);
            image2 = scaleImage(image2, (gp.tileSize/5) * 4, (gp.tileSize/5) * 4);
            image3 = scaleImage(image3, (gp.tileSize/5) * 4, (gp.tileSize/5) * 4);


        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
