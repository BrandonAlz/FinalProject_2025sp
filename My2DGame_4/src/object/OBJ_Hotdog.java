package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Hotdog extends SuperObject{

        public OBJ_Hotdog(){
            name = "Hotdog";
            try{
                image = ImageIO.read(getClass().getResourceAsStream("/objects/Hotdog.png"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
}
