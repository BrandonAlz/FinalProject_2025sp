package main;

import object.OBJ_Key;

import java.awt.*;
import java.awt.image.BufferedImage;

// Uncomment all non comments to display key counter
public class UI {

    GamePanel gp;
    Graphics2D g2;
    Font timesNewRoman_40;
    public String currentDialogue = "";
    //BufferedImage keyImage;

    public UI(GamePanel gp){
        this.gp = gp;

        timesNewRoman_40 = new Font("Arial", Font.PLAIN, 30);
        //OBJ_Key key =new OBJ_Key();
        //keyImage = key.image;
    }

    public void draw(Graphics2D g2){

        this.g2 = g2;

        g2.setFont(timesNewRoman_40);
        g2.setColor(Color.WHITE);

        // Play State
        if(gp.gameState == gp.playState){
            // Playstate stuff
        }
        //Pause State
        if(gp.gameState == gp.pauseState){
            drawPauseScreen();
        }
        // Dialogue State
        if(gp.gameState == gp.dialogueState){
            drawDialogueScreen();
        }
        //g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
        //g2.drawString("x " + gp.player.hasKey, 74, 65);
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
        int width = gp.screenWidth - (gp.tileSize * 4);
        int height = gp.screenHeight - (gp.tileSize * 7);
        drawSubWindow(x,y,width,height);

        //g2.drawString("I am old man lmao ", 115, 80);
        // This is broken and I don't know why
        //x += gp.tileSize;
        //y += gp.tileSize;
        g2.drawString(currentDialogue,115,80);
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