package gfx;

import java.awt.image.BufferedImage;


public class Assets {

    public static SpriteSheet player, reversedPlayer, bullet, flyingDragon, flyingDragonReversed;
    //Loads every resource needed for the game
    public static void init() {
        player = new SpriteSheet(ImageLoader.loadImage("/Player/player.png"));
        reversedPlayer = new SpriteSheet(ImageLoader.loadImage("/Player/reversedPlayer.png"));
        bullet = new SpriteSheet(ImageLoader.loadImage("/Player/bullet.png"));
        flyingDragon = new SpriteSheet(ImageLoader.loadImage("/Enemies/flying-dragon.png"));
        flyingDragonReversed = new SpriteSheet(ImageLoader.loadImage("/Enemies/flying-dragon-reversed.png"));
    }
}
