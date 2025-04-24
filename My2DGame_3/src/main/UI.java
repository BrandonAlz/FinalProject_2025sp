package main;

import object.OBJ_Heart;
import object.OBJ_Key;
import object.SuperObject;

import java.awt.*;
import java.awt.image.BufferedImage;

// Uncomment all non comments to display key counter
public class UI {

    GamePanel gp;
    Graphics2D g2;
    Font timesNewRoman_40;
    public String currentDialogue = "";
    BufferedImage keyImage, heartFull, heartHalf, heartEmpty;

    public UI(GamePanel gp){
        this.gp = gp;

        timesNewRoman_40 = new Font("Arial", Font.PLAIN, 30);
        //OBJ_Key key =new OBJ_Key();
        //keyImage = key.image;

        // Create HUD
        SuperObject heart = new OBJ_Heart(gp);
        heartFull = heart.image;
        heartHalf = heart.image2;
        heartEmpty = heart.image3;
    }

    public void draw(Graphics2D g2){

        this.g2 = g2;

        g2.setFont(timesNewRoman_40);
        g2.setColor(Color.WHITE);

        // Play State
        if(gp.gameState == gp.playState){
            // Playstate stuff
            drawPlayerlife();
        }
        //Pause State
        if(gp.gameState == gp.pauseState){
            drawPlayerlife();
            drawPauseScreen();
        }
        // Dialogue State
        if(gp.gameState == gp.dialogueState){
            drawPlayerlife();
            drawDialogueScreen();
        }
        //g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
        //g2.drawString("x " + gp.player.hasKey, 74, 65);
    }

    public void drawPlayerlife(){

        int x = gp.tileSize/2;
        int y = gp.tileSize/2;
        int i = 0;

        // Draw Max Life
        while(i < gp.player.maxLife/2){
            g2.drawImage(heartEmpty, x, y, null);
            i++;
            x += gp.tileSize;
        }

        x = gp.tileSize/2;
        y = gp.tileSize/2;
        i = 0;

        // Draw Current Life
        while(i < gp.player.life){
            g2.drawImage(heartHalf, x, y, null);
            i++;
            if(i < gp.player.life){
                g2.drawImage(heartFull, x, y, null);
            }
            i++;
            x += gp.tileSize;
        }


    }

    public void drawPauseScreen(){
        String text = "PAUSED";
        int x = getXForCenteredText(text);
        int y = gp.screenHeight/2;

        g2.drawString(text, x ,y);
    }

    public void drawDialogueScreen(){

        //Window
        int x = gp.tileSize * 2;
        int y = gp.tileSize / 2;
        int width = gp.screenWidth - (gp.tileSize * 25);
        int height = gp.screenHeight - (gp.tileSize * 18);
        drawSubWindow(x,y,width,height);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,28F));
        x += gp.tileSize;
        y += gp.tileSize;

        for(String line : currentDialogue.split("\n")){
            g2.drawString(line,x,y); // 115, 80
            y += 40;
        }
    }

    public void drawSubWindow(int x, int y, int width, int height){

        Color c = new Color(0,0,0,215);
        g2.setColor(c);
        g2.fillRoundRect(x,y,width,height,35,35);

        c = new Color(255,255,255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5,y+5,width-10,height-10,25,25);
    }

    public int getXForCenteredText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }

}