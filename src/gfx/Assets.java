package gfx;

import java.awt.image.BufferedImage;


public class Assets {
    private static final int width = 50, height = 110;

    public static BufferedImage player;
    //Loads every resource needed for the game
    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/Player/soldier.png"));

        player = sheet.crop(0, 0, width, height);

    }
}
