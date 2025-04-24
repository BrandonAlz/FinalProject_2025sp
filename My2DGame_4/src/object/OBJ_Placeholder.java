package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Placeholder extends SuperObject{

    public OBJ_Placeholder(){
        name = "Placeholder";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Nothing.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
