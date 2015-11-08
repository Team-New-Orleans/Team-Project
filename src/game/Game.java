package game;
import display.Display;
import display.HUD;
import display.CurrentScore;
import gameObjects.Health;
import gameObjects.Player;
import gfx.Assets;
import gfx.ImageLoader;
import gfx.SpriteSheet;
import states.*;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Game implements Runnable{

    private int width,height;
    private String title;
    private BufferStrategy bufferStrategy;
    private Graphics graphics;
    private Display display;


    //States
    private State gameState;
    private State menuState;
    private State gameOverState;


    // images
    private BufferedImage background;
    private SpriteSheet sheet;

    private boolean isRunning;
    private Thread thread;


    public static Player player;


    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        this.isRunning = false;
    }

    public void init(){
        this.display = new Display(title, width, height);
        this.background = ImageLoader.loadImage("/background.jpg");

        Assets.init();
        player = new Player();

        gameState = new GameState(this.display);
        menuState = new MenuState();
        gameOverState = new GameOverSate();
        StateManager.setState(gameState);
        Handler.objects.add(player);

    }

    // tick wait for any updated and movement
    public void tick(){
        if (StateManager.getState() != null) {
            StateManager.getState().tick();
        }
        if(player.getIsDead()){
            this.stop();
        }
    }

    // after tick gives the update render draws it
    public void render(){
        this.bufferStrategy = this.display.getCanvas().getBufferStrategy();
        if(this.bufferStrategy == null){
            this.display.getCanvas().createBufferStrategy(2); // how many buffers to user
            return;
        }
        // instantiate the graphics.
        this.graphics = this.bufferStrategy.getDrawGraphics();
        // this coordinate system is like in the 4th quadrant. We are creating a rectangle with size 200 to 30 on X-100 and Y-100
        // clearing the screen
        this.graphics.clearRect(0,0 , this.width, this.height);
        // drawing

        this.graphics.drawImage(this.background, 0, 0, this.width, this.height, null);

       // rendering every single object
        if (StateManager.getState() != null){
            StateManager.getState().render(this.graphics);
        }
        this.bufferStrategy.show();
        this.graphics.dispose();
    }
    // the Runnable class runs you program automaticallly when you run a new thread.
    @Override
    public void run() {
        this.init();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double delta = 0;
        double ns = 1_000_000_000.0 / amountOfTicks;
        long timer = System.currentTimeMillis();
        int frames = 0;
        long now;

        while (isRunning){
            now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1){
                tick();
                delta--;
            }
            if(isRunning){
                render();
                frames++;
            }
            if(System.currentTimeMillis() - timer > 1000) {
                timer +=1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        this.stop();
    }

    // run is a multithreading Class so we want our start and Stop methods to be synchronized this means 2 threads should not be allowed to work on start and stop simultaniously
    public synchronized void start(){
        // by starting a new thread the run method is called automatically
        if(!isRunning){
            this.isRunning = true;
            this.thread = new Thread(this);
            this.thread.start();
        }

    }

    public synchronized void stop(){ // this joins all the threads and stops the application
        if(this.isRunning){
            try{
                this.isRunning = false;
                this.thread.join();

            } catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }

    }
}
