package main;

import entity.Entity;
import entity.Player;
//import entity.Player2;
import object.SuperObject;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable {

    // SCREEN SETTINGS
    final int originalTileSize = 16; // 16x16 tile which is the industry standard with retro sprites
    final int scale = 3; // The scale we are applying to our tiles

    public final int tileSize = originalTileSize * scale; // Makes it 48x48 tile size which is better for actually seeing the sprites
    public final int maxScreenCol = 40; // 16 original How many tiles wide
    public final int maxScreenRow = 23; // 11 originL How many tiles tall
    public final int screenWidth = tileSize * maxScreenCol; // originally 768 pixels
    public final int screenHeight = tileSize * maxScreenRow; // originally 576 pixels
    public final int maxMap = 10;
    public final int currentMap = 0;

    // FPS
    int FPS = 60;

    // We want our game panel to do many things when it is running SO!
    // Tile manager named tileM is this gp
    TileManager tileM = new TileManager(this);
    // Key handler named keyH is our keyhandler which is our movement
    public KeyHandler keyH = new KeyHandler(this);
    //public KeyHandler2 keyH2 = new KeyHandler2();
    // This is the "clock" of the game.  Time moves forward like an update
    Thread gameThread; // A clock
    // We make a collision checker named cChecker to this gp
    public CollisionChecker cChecker = new CollisionChecker(this);
    // AssetSetter handles all the setting of assets wow shocker, but for real it handles setting objects onto the map
    public AssetSetter aSetter = new AssetSetter(this);
    // UI
    public UI ui = new UI(this);
    // Handles events HAHA
    public EventHandler eHandler = new EventHandler(this);
    // Our players that use this gp and a keyhandler to move
    public Player player = new Player(this, keyH);
    //public Player2 player2 = new Player2(this, keyH2);
    // Our object super class being used to make an object array to store some objects (kinda like tiles!)
    public SuperObject[] obj = new SuperObject[10];
    // NPC Array
    public Entity[] npc = new Entity[10];
    // Monster Array
    public Entity[] monster = new Entity[20];
    // Array list for rendering
    //ArrayList<Entity> entityList = new ArrayList<>();
    // Game States
    public int gameState;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true); // Draws things in background makes for better performance
        this.addKeyListener(keyH);
        //this.addKeyListener(keyH2);
        this.setFocusable(true);
    }

    // This sets up the game and right now sets objects like our doors, keys, etc and starts the game in a non paused state
    // We can change this to start the game on a title screen which is why it's done like this for now
    public void setUpGame() {

        aSetter.setObject();
        aSetter.setNPC();
        aSetter.setMonster();
        // play music missing
        // stop music missing
        gameState = playState;

    }

    // It's like a clock so things can progress
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run() {
        double drawInterval = 1000000000 / FPS; // 0.0166666 seconds
        double delta = 0; // When we reach 1 second condition to update and repaint
        long lastTime = System.nanoTime(); // The previous time it was
        long currentTime; // The current time it is
        long timer = 0; // When timer reaches 1 second condition in nanoseconds
        int drawCount = 0; // Our FPS of the game

        while (gameThread != null) {

            // We set the current time to a second in nanoseconds for precision
            currentTime = System.nanoTime();


            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                try {
                    update();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;

            }


        }
    }

    public void update() throws IOException {
        // This updates our players as the game runs AND as the game is not paused
        if (gameState == playState) {

            //player2.update();
            player.update();

            for(int i = 0; i < npc.length; i++){
                if(npc[i] != null){
                    Entity currentNPC = npc[i]; // Create a local reference IMMEDIATELY
                    currentNPC.update();
                }
            }
            for(int i = 0; i < monster.length; i++){
                if(monster[i] != null){
                    if (monster[i].alive == true && monster[i].dying == false) {
                        monster[i].update();
                    }
                    if(monster[i].alive == false){
                        monster[i] = null;
                    }
                }
            }
        }

        // This will tell the game to do nothing when it is paused
        if (gameState == pauseState) {

        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // We draw tile before player because it is like a layer, we want the tiles beneath the player not on top of them
        tileM.draw(g2);
        // Objects
        for (int i = 0; i < obj.length; i++) {
            if (obj[i] != null) {
                obj[i].draw(g2, this);
            }
        }

        // NPC
        for (int i = 0; i < npc.length; i++) {
            if (npc[i] != null) {
                npc[i].draw(g2);
            }
        }

        // Monsters
        for (int i = 0; i < monster.length; i++) {
            if (monster[i] != null) {
                monster[i].draw(g2);
            }
        }

        // Players
        player.draw(g2);
        //player2.draw(g2);

        // UI (Has Key UI but that's from tutorial and not need rn)
        ui.draw(g2);
        g2.dispose();
            }
        }
