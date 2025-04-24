package main;

import java.awt.*;

public class EventHandler {

    GamePanel gp;
    EventRect eventRect[][];

    int previousEventX, previousEventY;
    boolean canTouchEvent = true;

    public EventHandler(GamePanel gp){
        this.gp = gp;

        eventRect = new EventRect[gp.maxScreenCol][gp.maxScreenRow];

        int col = 0;
        int row = 0;
        while(col < gp.maxScreenCol && row < gp.maxScreenRow){

            eventRect[col][row] = new EventRect();
            eventRect[col][row].x = 23;
            eventRect[col][row].y = 23;
            eventRect[col][row].width = 2;
            eventRect[col][row].height = 2;
            eventRect[col][row].eventRectDefaultX = eventRect[col][row].x;
            eventRect[col][row].eventRectDefaultY = eventRect[col][row].y;

            col++;
            if(col == gp.maxScreenCol){
                col = 0;
                row++;
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
            if (hit(10, 10, "any") == true) {
                // Here it comes baby some damage (note: any direction will fuck the player up lmao so avoid it if possible cuz they get 3 dmg per tile)
                damagePit(10, 10, gp.dialogueState);
            }

            if (hit(21, 19, "down") == true) {
                // Healing
                healingPool(21, 19, gp.dialogueState);
            }

            if (hit(20, 18, "any") == true) {
                // Healing
                teleport(20, 18, gp.dialogueState);
            }
        }
    }

    public boolean hit(int col, int row, String reqDirection){

        boolean hit = false;

        gp.player.solidArea.x = gp.player.x + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.y + gp.player.solidArea.y;
        eventRect[col][row].x = col * gp.tileSize + eventRect[col][row].x;
        eventRect[col][row].y = row * gp.tileSize + eventRect[col][row].y;

        if(gp.player.solidArea.intersects(eventRect[col][row]) && eventRect[col][row].eventDone == false){
            if(gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")){
                hit = true;

                previousEventX = gp.player.x;
                previousEventY = gp.player.y;
            }
        }

        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        eventRect[col][row].x = eventRect[col][row].eventRectDefaultX;
        eventRect[col][row].y = eventRect[col][row].eventRectDefaultY;




        return hit;
    }

    public void damagePit(int col, int row, int gameState){

        gp. gameState = gameState;
        gp.ui.currentDialogue = "You got smacked bucko";
        gp.player.life -= 1;
        //eventRect[col][row].eventDone = true;
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
}
