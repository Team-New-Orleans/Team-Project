package menu;

import gfx.ImageLoader;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainMenu implements ActionListener {
    private int height = 600;
    private int width = 800;
    private int buttonHeight = 40;
    private int buttonWidth = 220;

    private BufferedImage background;
    private Canvas canvas;
    private JFrame jframe = new JFrame();

    JButton start = new JButton("New game");
    JButton exit = new JButton ("Exit");
    JButton leaderboard = new JButton ("Leaderboard");
    JButton settings = new JButton ("Settings");

    public MainMenu(){
        this.jframe = new JFrame("Main Menu");
        setBackground();
        setFrame();
        createButtons();
    }

    private void setFrame(){
        Dimension dimension = new Dimension(800,600);
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
    }

    private void setBackground(){
        this.background = ImageLoader.loadImage("/background.jpg");
        this.jframe.setContentPane(new JLabel(new ImageIcon(background)));
        this.jframe.pack();
    }

    private void createButtons(){
        start.addActionListener(this);
        leaderboard.addActionListener(this);
        settings.addActionListener(this);
        exit.addActionListener(this);

        start.setForeground(Color.WHITE);
        leaderboard.setForeground(Color.WHITE);
        settings.setForeground(Color.WHITE);
        exit.setForeground(Color.WHITE);

        JPanel panel = new JPanel();
        start.setBounds((width-buttonWidth)/2, 100, buttonWidth, buttonHeight);
        leaderboard.setBounds((width-buttonWidth)/2, 220, buttonWidth, buttonHeight);
        settings.setBounds((width-buttonWidth)/2, 340, buttonWidth, buttonHeight);
        exit.setBounds((width-buttonWidth)/2, 460, buttonWidth, buttonHeight);

        //start.setOpaque(false);
        start.setContentAreaFilled(false);
        //start.setBorderPainted(false);

        leaderboard.setContentAreaFilled(false);
        settings.setContentAreaFilled(false);
        exit.setContentAreaFilled(false);

        panel.setBounds(800, 800, 200, 100);
        panel.add(start);
        panel.add(leaderboard);
        panel.add(settings);
        panel.add(exit);

        jframe.add(start);
        jframe.add(leaderboard);
        jframe.add(settings);
        jframe.add(exit);
    }

    public void actionPerformed(ActionEvent ae) {
        String comStr = ae.getActionCommand();
        if (comStr.equals("New game")){
            game.Game game = new game.Game("Java Workshop", 800, 600);
            game.start();
            jframe.dispose();
        } else if(comStr.equals("Settings")){
            //go to settings
        } else if(comStr.equals("Leaderboard")){
            // Go to leaderboard
        } else if(comStr.equals("Exit")){
            System.exit(0);
        }
        System.out.println(comStr + " Selected");
    }
}
