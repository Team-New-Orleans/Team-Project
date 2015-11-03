package menu;

import display.Display;
import game.Game;
import gfx.ImageLoader;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;

public class MainMenu implements ActionListener {
    private Display display;

    private int height = 600;
    private int width = 800;
    private int buttonHeight = 30;
    private int buttonWidth = 220;

    private BufferedImage background;
    private Game game;
    private Canvas canvas;
    private JFrame jframe = new JFrame();
    private Graphics graphics;
    private BufferStrategy bufferStrategy;

    JButton start = new JButton("New game");
    JButton exit = new JButton ("Exit");
    JButton settings = new JButton ("Settings");
    JButton leaderboard = new JButton ("Leaderboard");

    public MainMenu(){

        Dimension dimension = new Dimension(800,600);

        this.jframe = new JFrame("Main Menu");
        this.jframe.setSize(800,600);
        this.jframe.setVisible(true);
        this.jframe.setResizable(false);
        this.jframe.setFocusable(true);
        this.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jframe.setLocationRelativeTo(null);
        this.canvas = new Canvas();
        this.canvas.setMaximumSize(dimension);
        this.canvas.setMinimumSize(dimension);
        this.canvas.setPreferredSize(dimension);

        //this.jframe.getContentPane().setBackground( Color.green );
        this.background = ImageLoader.loadImage("/background.jpg");

        start.addActionListener(this);
        settings.addActionListener(this);
        leaderboard.addActionListener(this);
        exit.addActionListener(this);

        JPanel panel = new JPanel();
        start.setBounds((width-buttonWidth)/2, 150, buttonWidth, buttonHeight);
        settings.setBounds((width-buttonWidth)/2, 250, buttonWidth, buttonHeight);
        leaderboard.setBounds((width-buttonWidth)/2, 350, buttonWidth, buttonHeight);
        exit.setBounds((width-buttonWidth)/2, 450, buttonWidth, buttonHeight);

        //start.setOpaque(false);
        start.setContentAreaFilled(false);
        //start.setBorderPainted(false);
        settings.setContentAreaFilled(false);
        leaderboard.setContentAreaFilled(false);
        exit.setContentAreaFilled(false);

        panel.setBounds(800, 800, 200, 100);
        panel.add(start);
        panel.add(settings);
        panel.add(leaderboard);
        panel.add(exit);

        jframe.add(start);
        jframe.add(settings);
        jframe.add(leaderboard);
        jframe.add(exit);


        this.jframe.add(this.canvas);
        this.jframe.pack();

        final BufferedImage image = ImageLoader.loadImage("/background.jpg");

        JPanel pane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
            }
        };

//        this.background = ImageLoader.loadImage("/background.jpg");
//
//        this.bufferStrategy = canvas.getBufferStrategy();
//
//        if(this.bufferStrategy == null){
//            canvas.createBufferStrategy(2); // how many buffers to user
//            return;
//        }
//        this.graphics = this.bufferStrategy.getDrawGraphics();
//        this.graphics.drawRect(100,100,200,200);
//        this.graphics.drawImage(this.background, 0, 0, 800,600, null);
////
////        this.bufferStrategy.show();
////        this.graphics.dispose();
    }

    public void actionPerformed(ActionEvent ae) {
        String comStr = ae.getActionCommand();
        if (comStr.equals("START GAME")){
            game.Game game = new game.Game("Java Workshop", 800, 600);
            game.start();
        }
        System.out.println(comStr + " Selected");
    }
}