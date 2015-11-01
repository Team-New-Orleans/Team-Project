package gfx;

import java.awt.image.BufferedImage;


public class Assets {

    public static SpriteSheet player;
    //Loads every resource needed for the game
    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/Player/soldier.png"));

        player = sheet;

    }
}
