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

        int mapNum = 0;
        int i = 0;
        // We created 2 keys, since OBJ_Key is a child class of SuperObject we can create a new key like this
        // We then set their placement on the map using coordinated in a map of your choice
        // We multiply by the game panel tile size so that they can be the correct size in our world
        gp.obj[mapNum][i] = new OBJ_Door();
        gp.obj[mapNum][i].x = 21;
        gp.obj[mapNum][i].y = 20;
        i++;
        gp.obj[mapNum][i] = new OBJ_Key();
        gp.obj[mapNum][i].x = 5;
        gp.obj[mapNum][i].y = 8;
        i++;
        gp.obj[mapNum][i] = new OBJ_Hotdog();
        gp.obj[mapNum][i].x = 20;
        gp.obj[mapNum][i].y = 18;
        i++;
        gp.obj[mapNum][i] = new OBJ_Chest();
        gp.obj[mapNum][i].x = 9;
        gp.obj[mapNum][i].y = 9;
        i++;
    }


    public void setNPC(){

        int mapNum = 0;
        int i = 0;
        gp.npc[mapNum][i] = new NPC_OldMan(gp);
        gp.npc[mapNum][i].x = 2 * gp.tileSize;
        gp.npc[mapNum][i].y = 2 * gp.tileSize;
        i++;

    }

    public void setMonster(){

        int mapNum = 0;
        int i = 0;
        gp.monster[mapNum][i] = new MON_GreenSlime(gp);
        gp.monster[mapNum][i].x = 15 * gp.tileSize;
        gp.monster[mapNum][i].y = 14 * gp.tileSize;
        i++;
        gp.monster[mapNum][i] = new MON_GreenSlime(gp);
        gp.monster[mapNum][i].x = 11 * gp.tileSize;
        gp.monster[mapNum][i].y = 11 * gp.tileSize;
        i++;
    }
}
