package gfx;

import java.awt.image.BufferedImage;


public class Assets {


    public static SpriteSheet player, reversedPlayer, bullet,
            flyingDragon, flyingDragonReversed, flyingDragonAttack,
            dinosaur, dinosaurReversed, dinosaurAttack, dinosaurAttackReversed, dinosaurDeath, dinosaurDeathReversed,
            octopus, octopusReversed, octopusAttack, octopusDeath;

    //Loads every resource needed for the game
    public static void init() {
        player = new SpriteSheet(ImageLoader.loadImage("/Player/player.png"));
        reversedPlayer = new SpriteSheet(ImageLoader.loadImage("/Player/reversedPlayer.png"));
        bullet = new SpriteSheet(ImageLoader.loadImage("/Player/bullet.png"));

        // Flying enemies
        flyingDragon = new SpriteSheet(ImageLoader.loadImage("/Enemies/flying-dragon.png"));
        flyingDragonReversed = new SpriteSheet(ImageLoader.loadImage("/Enemies/flying-dragon-reversed.png"));
        flyingDragonAttack = new SpriteSheet(ImageLoader.loadImage("/Enemies/flying-dragon-attack.png"));

        // Ground enemies
        dinosaur = new SpriteSheet(ImageLoader.loadImage("/Enemies/dinosaur.png"));
        dinosaurReversed = new SpriteSheet(ImageLoader.loadImage("/Enemies/dinosaur-reversed.png"));
        dinosaurAttack = new SpriteSheet(ImageLoader.loadImage("/Enemies/dinosaur-attack.png"));
        dinosaurAttackReversed = new SpriteSheet(ImageLoader.loadImage("/Enemies/dinosaur-attack-reversed.png"));
        dinosaurDeath = new SpriteSheet(ImageLoader.loadImage("/Enemies/dinosaur-death.png"));
        dinosaurDeathReversed = new SpriteSheet(ImageLoader.loadImage("/Enemies/dinosaur-death-reversed.png"));

        octopus = new SpriteSheet(ImageLoader.loadImage("/Enemies/octopus.png"));
        octopusReversed = new SpriteSheet(ImageLoader.loadImage("/Enemies/octopus-reversed.png"));
        octopusAttack = new SpriteSheet(ImageLoader.loadImage("/Enemies/octopus-attack.png"));
        octopusDeath = new SpriteSheet(ImageLoader.loadImage("/Enemies/octopus-death.png"));
    }
}
