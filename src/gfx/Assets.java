package gfx;

import java.awt.image.BufferedImage;


public class Assets {

    public static SpriteSheet player, reversedPlayer, bullet, flyingDragon, flyingDragonReversed, dinosaur, dinosaurReversed;
    //Loads every resource needed for the game
    public static void init() {
        // Player
        player = new SpriteSheet(ImageLoader.loadImage("/Player/player.png"));
        reversedPlayer = new SpriteSheet(ImageLoader.loadImage("/Player/reversedPlayer.png"));
        bullet = new SpriteSheet(ImageLoader.loadImage("/Player/bullet.png"));

        // Enemies
        flyingDragon = new SpriteSheet(ImageLoader.loadImage("/Enemies/flying-dragon.png"));
        flyingDragonReversed = new SpriteSheet(ImageLoader.loadImage("/Enemies/flying-dragon-reversed.png"));
        dinosaur = new SpriteSheet(ImageLoader.loadImage("/Enemies/dinosaur.png"));
        dinosaurReversed = new SpriteSheet(ImageLoader.loadImage("/Enemies/dinosaur-reversed.png"));
    }
}
