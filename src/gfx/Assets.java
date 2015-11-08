package gfx;

import java.awt.image.BufferedImage;


public class Assets {


    public static SpriteSheet player, reversedPlayer, bullet, health,
            flyingDragon, flyingDragonReversed, flyingDragonAttack, getFlyingDragonAttackReversed,
            flyingDragonDeath, flyingDragonDeathReversed,
            dinosaur, dinosaurReversed, dinosaurAttack, dinosaurAttackReversed, dinosaurDeath, dinosaurDeathReversed,
            octopus, octopusReversed, octopusAttack, octopusDeath,
            octopus_t, octopus_tDeath;

    //Loads every resource needed for the game
    public static void init() {
        player = new SpriteSheet(ImageLoader.loadImage("/Player/player.png"));
        reversedPlayer = new SpriteSheet(ImageLoader.loadImage("/Player/reversedPlayer.png"));
        bullet = new SpriteSheet(ImageLoader.loadImage("/Player/bullet.png"));

        // Flying enemies
        flyingDragon = new SpriteSheet(ImageLoader.loadImage("/Enemies/flying-dragon.png"));
        flyingDragonReversed = new SpriteSheet(ImageLoader.loadImage("/Enemies/flying-dragon-reversed.png"));
        flyingDragonAttack = new SpriteSheet(ImageLoader.loadImage("/Enemies/flying-dragon-attack.png"));
        getFlyingDragonAttackReversed = new SpriteSheet(ImageLoader.loadImage("/Enemies/flying-dragon-attack-reversed.png"));
        flyingDragonDeath = new SpriteSheet(ImageLoader.loadImage("/Enemies/flying-dragon-death.png"));
        flyingDragonDeathReversed = new SpriteSheet(ImageLoader.loadImage("/Enemies/flying-dragon-death-reversed.png"));

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

        octopus_t = new SpriteSheet(ImageLoader.loadImage("/Enemies/octopus-t.png"));
        octopus_tDeath = new SpriteSheet(ImageLoader.loadImage("/Enemies/octopus-t-death.png"));

        //health
        health = new SpriteSheet(ImageLoader.loadImage("/Health/health.png"));
    }
}
