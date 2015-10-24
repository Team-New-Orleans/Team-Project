package game;
import display.Display;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{

    private int width,height;
    private String title;
    private BufferStrategy bufferStrategy;
    private Graphics graphics;
    private Display display;

    private boolean isRunning;
    private Thread thread;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        this.isRunning = false;


    }

    public void init(){

        this.display = new Display(title, width, height);
    }

    // tick wait for any updated and movement
    public void tick(){

    }

    // after tick gives the update render draws it
    public void render(){
        this.bufferStrategy = this.display.getCanvas().getBufferStrategy();

        if(this.bufferStrategy == null){
            this.display.getCanvas().createBufferStrategy(3); // how many buffers to user
            return;
        }
        this.graphics = this.bufferStrategy.getDrawGraphics();
        // this coordinate system is like in the 4th quadrant. We are creating a rectangle with size 200 to 30 on X-100 and Y-100

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
