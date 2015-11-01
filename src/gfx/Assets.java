package gfx;

import java.awt.image.BufferedImage;


public class Assets {

    public static SpriteSheet player, reversedPlayer;
    //Loads every resource needed for the game
    public static void init() {
        SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/Player/player.png"));
        SpriteSheet reversedPlayerSheet = new SpriteSheet(ImageLoader.loadImage("/Player/reversedPlayer.png"));

        player = playerSheet;
        reversedPlayer = reversedPlayerSheet;

    }
}
