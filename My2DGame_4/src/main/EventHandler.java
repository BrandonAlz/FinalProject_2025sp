package main;

import java.awt.*;

public class EventHandler {

    GamePanel gp;
    EventRect eventRect[][][];

    int previousEventX, previousEventY;
    boolean canTouchEvent = true;

    public EventHandler(GamePanel gp){
        this.gp = gp;

        eventRect = new EventRect[gp.maxMap][gp.maxScreenCol][gp.maxScreenRow];

        int map = 0;
        int col = 0;
        int row = 0;
        while(map < gp.maxMap && col < gp.maxScreenCol && row < gp.maxScreenRow){

            eventRect[map][col][row] = new EventRect();
            eventRect[map][col][row].x = 23;
            eventRect[map][col][row].y = 23;
            eventRect[map][col][row].width = 2;
            eventRect[map][col][row].height = 2;
            eventRect[map][col][row].eventRectDefaultX = eventRect[map][col][row].x;
            eventRect[map][col][row].eventRectDefaultY = eventRect[map][col][row].y;

            col++;
            if(col == gp.maxScreenCol){
                col = 0;
                row++;

                if(row == gp.maxScreenRow){
                    row = 0;
                    map++;
                }
            }
        }
    }

    public void checkEvent() {

        // Check if the player character is more than one tile away from previous event
        // This will return a value positively even if negative so we don't worry about which way a player is moving away from previous event
        // Will get absolute value of the x and y distance of the previous x and y that triggered the event with the players x and y
        int xDistance = Math.abs(gp.player.x - previousEventX);
        int yDistance = Math.abs(gp.player.y - previousEventY);
        // We then take the bigger of the 2 values of the x and y distance to use for our if statement
        int distance = Math.max(xDistance, yDistance);
        // This checks the max value between the x and y and compares to the tile size.  If the distance the player has traveled fro the previous event is
        // bigger than a tile, then the event can once again be activated
        if (distance > gp.tileSize) {
            canTouchEvent = true;
        }

        if (canTouchEvent == true) {
            if (hit(0,10, 10, "any") == true) {
                // Here it comes baby some damage (note: any direction will fuck the player up lmao so avoid it if possible cuz they get 3 dmg per tile)
                damagePit(10, 10, gp.dialogueState);
            }
            else if (hit(0,21, 19, "down") == true) {
                // Healing
                healingPool(21, 19, gp.dialogueState);
            }
            else if (hit(0,20, 18, "any") == true) {
                teleport(20, 18, gp.dialogueState);
            }
            else if (hit(0,2, 2, "any") == true) {
                teleportMap(1,2, 2);
            }
            else if (hit(1,2, 2, "any") == true) {
                teleportMap(0,2, 2);
            }
        }
    }

    public boolean hit(int map, int col, int row, String reqDirection) {

        boolean hit = false;

        if (map == gp.currentMap){
            gp.player.solidArea.x = gp.player.x + gp.player.solidArea.x;
            gp.player.solidArea.y = gp.player.y + gp.player.solidArea.y;
            eventRect[map][col][row].x = col * gp.tileSize + eventRect[map][col][row].x;
            eventRect[map][col][row].y = row * gp.tileSize + eventRect[map][col][row].y;

            if (gp.player.solidArea.intersects(eventRect[map][col][row]) && eventRect[map][col][row].eventDone == false) {
                if (gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")) {
                    hit = true;

                    previousEventX = gp.player.x;
                    previousEventY = gp.player.y;
                }
            }

            gp.player.solidArea.x = gp.player.solidAreaDefaultX;
            gp.player.solidArea.y = gp.player.solidAreaDefaultY;
            eventRect[map][col][row].x = eventRect[map][col][row].eventRectDefaultX;
            eventRect[map][col][row].y = eventRect[map][col][row].eventRectDefaultY;

        }
        return hit;
    }

    public void damagePit(int col, int row, int gameState){

        gp. gameState = gameState;
        gp.ui.currentDialogue = "You got smacked bucko";
        gp.player.life -= 1;
        canTouchEvent = false;
    }

    public void healingPool(int col, int row, int gameState){

            if(gp.keyH.enterPressed){
                gp.gameState = gameState;
                gp.ui.currentDialogue = "You drank disgusting pig water\n but you healed anyway. Congrats!";
                gp.player.life = gp.player.maxLife;
            }
    }

    public void teleport(int col, int row, int gameState){

            gp.gameState = gameState;
            gp.ui.currentDialogue = "WHOOSH!";
            gp.player.x = gp.tileSize * 2;
            gp.player.y = gp.tileSize * 2;
        }

    public void teleportMap(int map, int col, int row){

        gp.currentMap = map;
        gp.player.x = gp.tileSize * col;
        gp.player.y = gp.tileSize * row;
        previousEventX = gp.player.x;
        previousEventY = gp.player.y;
        canTouchEvent = false;
    }
}
