package states;

import display.CurrentScore;
import display.Display;
import display.HUD;
import game.EnemyGenerator;
import game.Handler;
import game.InputHandler;

import java.awt.*;

/**
 * Created by Simooo on 8.11.2015 ã..
 */
public class GameState extends State {
    private Handler handler;
    private InputHandler inputHandler;
    private EnemyGenerator enemyGenerator;
    private HUD hud;
    private CurrentScore currentScore;

    public GameState(Display display) {
        this.handler = new Handler();
        this.inputHandler = new InputHandler(display);
        this.hud = new HUD();
        this.currentScore = new CurrentScore();
        this.enemyGenerator = new EnemyGenerator();
    }

    @Override
    public void tick() {
        this.enemyGenerator.generatingEnemy();
        handler.tick();
        this.hud.tick();
        this.currentScore.tick();
    }

    @Override
    public void render(Graphics graphics) {
        handler.render(graphics);
        this.hud.render(graphics);
        this.currentScore.render(graphics);

    }
}
