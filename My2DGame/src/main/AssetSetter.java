package main;

//import entity.NPC_OldMan;
import entity.NPC_OldMan;
import object.*;

import java.io.IOException;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    // Here we have our method to set an object
    public void setObject(){

        // We created 2 keys, since OBJ_Key is a child class of SuperObject we can create a new key like this
        // We then set their placement on the map using coordinated in a map of your choice
        // We multiply by the game panel tile size so that they can be the correct size in our world
        gp.obj[0] = new OBJ_Door();
        gp.obj[0].x = 24;
        gp.obj[0].y = 17;

        gp.obj[1] = new OBJ_Key();
        gp.obj[1].x = 5;
        gp.obj[1].y = 8;

        gp.obj[2] = new OBJ_Hotdog();
        gp.obj[2].x = 3;
        gp.obj[2].y = 1;

        gp.obj[3] = new OBJ_Chest();
        gp.obj[3].x = 9;
        gp.obj[3].y = 9;

        gp.obj[4] = new OBJ_Chest();
        gp.obj[4].x = 11;
        gp.obj[4].y = 9;

        gp.obj[5] = new OBJ_Key();
        gp.obj[5].x = 1;
        gp.obj[5].y = 5;

        gp.obj[6] = new OBJ_Key();
        gp.obj[6].x = 1;
        gp.obj[6].y = 4;

        //gp.obj[7] = new OBJ_Placeholder();
        //gp.obj[7].x = 0;
        //gp.obj[7].y = 10;

    }


    public void setNPC(){
        gp.npc[0] = new NPC_OldMan(gp);
        gp.npc[0].x = 2;
        gp.npc[0].y = 0;

    }

}
