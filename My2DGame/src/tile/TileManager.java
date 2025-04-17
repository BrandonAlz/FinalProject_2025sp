package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {

    // Initializing variables we need
    // Game panel for sure, Tile array to store tiles, mapTileNum 2D array to store col and row position
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];

    // Constructor, we put in the game panel and make a tile array with a size of 10 (Holds 10 different tile types)
    // Fill up mapTileNum 2D array with tile information from map txt files.  If statement is below to do that
    // We call the getTitleImage and loadMap functions
    public TileManager(GamePanel gp){

        this.gp = gp;

        tile = new Tile[10];
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];

        getTitleImage();
        loadMap("/maps/map01.txt");
    }

    // This gets the image of Tiles just spelled wrong lol
    public void getTitleImage(){

        // In a try catch statement, we create a new tile spot in the array beginning at the first index 0
        // We then give that spot an image to be read in png format
        // Then we give it a collision boolean.  True means it is solid, false means passable
        try{

            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Grass.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Bricks.png"));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Water.png"));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Earth.png"));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Tree.png"));
            tile[4].collision = true;

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Sand.png"));
            
            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/House.png"));
            tile[6].collision = true;
            
            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Window.png"));
            tile[7].collision = true;


    }catch(IOException e){
        e.printStackTrace();}
    }

    // The map loader.  Takes a file and reads it line by line with a space break.
    // It stores what numbers it finds as it goes through the first row (col)
    // Then when it reaches the end, it will move to the second row and record the col
    // This stores in our mapTileNum 2D array which then gets called back in TileManager to load the map
    public void loadMap(String filePath){
        try{
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gp.maxScreenCol && row < gp.maxScreenRow){

                String line = br.readLine();

                while(col < gp.maxScreenCol){

                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxScreenCol){
                    col = 0;
                    row++;
                }
            }
            br.close();

        }catch(Exception e){

        }
    }

    // This is how we draw the graphics
    // We initialize variables starting at the very beginning
    // Next we use the GamePanel's maxScreenCol and maxScreenRow to set our bounds
    // We then tell g2 to draw the image at that x and y coordinate, with the size of our tile 16x16, null observer
    // We then increase the col number to move to the next col number info and increase x by our tile size so it doesn't overlap the tile with the next one
    // Keep going until we do everything in the row, increase the row, do the next row and so on making sure we reset x and col when we reach the bound
    // Think of this like a typewriter as we make our way to the right from the top left, filling in each row until we push it back and move down and continue
    public void draw(Graphics2D g2){

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while(col < gp.maxScreenCol  && row < gp.maxScreenRow){

            int tileNum = mapTileNum[col][row];

            g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;

            if (col == gp.maxScreenCol){
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }
    }
}
