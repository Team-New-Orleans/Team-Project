package gfx;

import java.awt.image.BufferedImage;


public class Assets {


    public static SpriteSheet player, reversedPlayer, bullet,
            flyingDragon, flyingDragonReversed,
            dinosaur, dinosaurReversed, dinosaurAttack, dinosaurAttackReversed,
            octopus, octopusReversed, octopusAttack;

    //Loads every resource needed for the game
    public static void init() {
        player = new SpriteSheet(ImageLoader.loadImage("/Player/player.png"));
        reversedPlayer = new SpriteSheet(ImageLoader.loadImage("/Player/reversedPlayer.png"));
        bullet = new SpriteSheet(ImageLoader.loadImage("/Player/bullet.png"));

        // Flying enemies
        flyingDragon = new SpriteSheet(ImageLoader.loadImage("/Enemies/flying-dragon.png"));
        flyingDragonReversed = new SpriteSheet(ImageLoader.loadImage("/Enemies/flying-dragon-reversed.png"));

        // Ground enemies
        dinosaur = new SpriteSheet(ImageLoader.loadImage("/Enemies/dinosaur.png"));
        dinosaurReversed = new SpriteSheet(ImageLoader.loadImage("/Enemies/dinosaur-reversed.png"));
        dinosaurAttack = new SpriteSheet(ImageLoader.loadImage("/Enemies/dinosaur-attack.png"));
        dinosaurAttackReversed = new SpriteSheet(ImageLoader.loadImage("/Enemies/dinosaur-attack-reversed.png"));

        octopus = new SpriteSheet(ImageLoader.loadImage("/Enemies/octopus.png"));
        octopusReversed = new SpriteSheet(ImageLoader.loadImage("/Enemies/octopus-reversed.png"));
        octopusAttack = new SpriteSheet(ImageLoader.loadImage("/Enemies/octopus-attack.png"));
    }
}
