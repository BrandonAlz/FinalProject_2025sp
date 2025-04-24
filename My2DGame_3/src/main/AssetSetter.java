package main;

import monster.MON_GreenSlime;
import entity.NPC_OldMan;
//import monster.MON_GreenSlime;
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
        gp.obj[0].x = 21;
        gp.obj[0].y = 20;

        gp.obj[1] = new OBJ_Key();
        gp.obj[1].x = 5;
        gp.obj[1].y = 8;

        gp.obj[2] = new OBJ_Hotdog();
        gp.obj[2].x = 20;
        gp.obj[2].y = 18;

        gp.obj[3] = new OBJ_Chest();
        gp.obj[3].x = 9;
        gp.obj[3].y = 9;
    }


    public void setNPC(){
        gp.npc[0] = new NPC_OldMan(gp);
        gp.npc[0].x = 2 * gp.tileSize;
        gp.npc[0].y = 2 * gp.tileSize;

    }

    public void setMonster(){

        gp.monster[0] = new MON_GreenSlime(gp);
        gp.monster[0].x = 15 * gp.tileSize;
        gp.monster[0].y = 14 * gp.tileSize;

        gp.monster[1] = new MON_GreenSlime(gp);
        gp.monster[1].x = 11 * gp.tileSize;
        gp.monster[1].y = 11 * gp.tileSize;
    }
}
