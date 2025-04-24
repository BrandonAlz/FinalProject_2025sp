package main;

import entity.Entity;

import java.awt.*;

public class CollisionChecker {

    GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;

    }

    public void checkTile(Entity entity) {

        int entityLeftX = entity.x + entity.solidArea.x;
        int entityRightX = entity.x + entity.solidArea.x + entity.solidArea.width;
        int entityTopY = entity.y + entity.solidArea.y;
        int entityBottomY = entity.y + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftX / gp.tileSize;
        int entityRightCol = entityRightX / gp.tileSize;
        int entityTopRow = entityTopY / gp.tileSize;
        int entityBottomRow = entityBottomY / gp.tileSize;

        int tileNum1, tileNum2;

        switch (entity.direction) {
            case "up":
                entityTopRow = (entityTopY - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityTopRow];
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true)
                    entity.collisionOn = true;
                break;
            case "down":
                entityBottomRow = (entityBottomY + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true)
                    entity.collisionOn = true;
                break;
            case "left":
                entityLeftCol = (entityLeftX - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true)
                    entity.collisionOn = true;
                break;
            case "right":
                entityRightCol = (entityRightX + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true)
                    entity.collisionOn = true;
                break;
        }

    }

    public int checkObject(Entity entity, boolean player) {

        int index = 999;

        for (int i = 0; i < gp.obj.length; i++) {
            if (gp.obj[i] != null) {
                // Get entity solid area position
                entity.solidArea.x = entity.x + entity.solidArea.x;
                entity.solidArea.y = entity.y + entity.solidArea.y;
                // Get object's solid area position
                gp.obj[i].solidArea.x = (gp.obj[i].x + gp.obj[i].solidArea.x) * gp.tileSize;
                gp.obj[i].solidArea.y = (gp.obj[i].y + gp.obj[i].solidArea.y) * gp.tileSize;

                switch (entity.direction) {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if (gp.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if (gp.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if (gp.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if (gp.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                ;
                gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
                gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
            }
        }
        return index;
    }

    // NPC and Player collision
    // It kept checking the entity against itself where it was trying to move
    // SO NOW AFTER 6 HOURS
    // It does not check against itself in the new position relative to the old and then get collision detection
    public int checkEntity(Entity entity, Entity[] target) {

        int index = 999;

        for (int i = 0; i < target.length; i++) {
            if (target[i] != null && target[i] != entity) {
                // Get entity's next possible solid area position
                Rectangle entityNextArea = new Rectangle(entity.x + entity.solidAreaDefaultX, entity.y + entity.solidAreaDefaultY, entity.solidArea.width, entity.solidArea.height);
                switch (entity.direction) {
                    case "up":
                        entityNextArea.y -= entity.speed;
                        break;
                    case "down":
                        entityNextArea.y += entity.speed;
                        break;
                    case "left":
                        entityNextArea.x -= entity.speed;
                        break;
                    case "right":
                        entityNextArea.x += entity.speed;
                        break;
                }

                // Get target entity's current solid area position
                Rectangle targetArea = new Rectangle(target[i].x + target[i].solidAreaDefaultX, target[i].y + target[i].solidAreaDefaultY, target[i].solidArea.width, target[i].solidArea.height);

                if (entityNextArea.intersects(targetArea)) {
                    entity.collisionOn = true;
                    index = i;
                }
            }
        }
        return index;
    }

    public boolean checkPlayer(Entity entity) {

        boolean contactPlayer = false;

        // Get entity's solid area position for this check
        Rectangle entityArea = new Rectangle(entity.x + entity.solidAreaDefaultX, entity.y + entity.solidAreaDefaultY, entity.solidArea.width, entity.solidArea.height);

        // Get player's solid area position for this check
        Rectangle playerArea = new Rectangle(gp.player.x + gp.player.solidAreaDefaultX, gp.player.y + gp.player.solidAreaDefaultY, gp.player.solidArea.width, gp.player.solidArea.height);

        // Create a temporary rectangle representing the entity's potential next position
        Rectangle entityNextArea = new Rectangle(entityArea); // Start with the current area

        switch (entity.direction) {
            case "up":
                entityNextArea.y -= entity.speed;
                break;
            case "down":
                entityNextArea.y += entity.speed;
                break;
            case "left":
                entityNextArea.x -= entity.speed;
                break;
            case "right":
                entityNextArea.x += entity.speed;
                break;
        }

        if (entityNextArea.intersects(playerArea)) {
            entity.collisionOn = true;
            contactPlayer = true;
        }

        return contactPlayer;
    }
}


