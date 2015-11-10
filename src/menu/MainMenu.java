package menu;

import game.Game;
import gfx.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
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

    private JLabel gameName = new JLabel("The Undertaker");
    private JButton start = new JButton("New game");
    private JButton exit = new JButton ("Exit");
    private JButton leaderboard = new JButton ("Leaderboard");
    private JButton tutorial = new JButton ("Tutorial");
    private JPanel panel = new JPanel();

    private final int fontSize = 14;
    private final String fontType = "Times New Roman";

    public MainMenu(){
        this.jframe = new JFrame("Main Menu");
        setBackground();
        setFrame();
        createButtons();
    }

    public JFrame getJFrame(){
        return this.jframe;
    }

    public void setJFrame(JFrame jf){
        this.jframe = jf;
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
        tutorial.addActionListener(this);
        exit.addActionListener(this);

        gameName.setForeground(Color.WHITE);
        start.setForeground(Color.WHITE);
        leaderboard.setForeground(Color.WHITE);
        tutorial.setForeground(Color.WHITE);
        exit.setForeground(Color.WHITE);

        gameName.setBounds((width-480)/2, 70, 480, buttonHeight+10);
        start.setBounds((width-buttonWidth)/2, 280, buttonWidth, buttonHeight);
        tutorial.setBounds((width-buttonWidth)/2, 340, buttonWidth, buttonHeight);
        leaderboard.setBounds((width-buttonWidth)/2, 400, buttonWidth, buttonHeight);
        exit.setBounds((width-buttonWidth)/2, 460, buttonWidth, buttonHeight);

        //start.setOpaque(false);
        start.setContentAreaFilled(false);
        //start.setBorderPainted(false);

        leaderboard.setContentAreaFilled(false);
        tutorial.setContentAreaFilled(false);
        exit.setContentAreaFilled(false);

        gameName.setFont(new Font(fontType, Font.PLAIN, 72));
        start.setFont(new Font(fontType, Font.PLAIN, fontSize));
        tutorial.setFont(new Font(fontType, Font.PLAIN, fontSize));
        leaderboard.setFont(new Font(fontType, Font.PLAIN, fontSize));
        exit.setFont(new Font(fontType, Font.PLAIN, fontSize));

        panel.setBounds(800, 800, 200, 100);
        panel.add(start);
        panel.add(leaderboard);
        panel.add(tutorial);
        panel.add(exit);

        jframe.add(gameName);
        jframe.add(start);
        jframe.add(leaderboard);
        jframe.add(tutorial);
        jframe.add(exit);
    }

    public void JFDispose(){
        jframe.dispose();
    }

    public void setLabel(JLabel l){
        l.setForeground(Color.white);
        l.setBounds(200, 70, 400, 300);
        l.setFont(new Font(fontType, Font.PLAIN, fontSize+6));
        panel.add(l);
        jframe.add(l);
    }

    public void setLeaderBoard(JLabel l){
        l.setForeground(Color.white);
        l.setBounds(200, 160, 400, 400);
        l.setFont(new Font(fontType, Font.PLAIN, fontSize + 6));
        panel.add(l);
        jframe.add(l);
    }
    public void setLifeBar(JLabel l){
        l.setBackground(Color.GREEN);
        l.setBounds(350,290,200,30);
        l.setOpaque(true);
        panel.add(l);
        jframe.add(l);
    }

    public void setButton(JButton b, int buttonHeight){
        gameName.setVisible(false);
        start.setVisible(false);
        exit.setVisible(false);
        tutorial.setVisible(false);
        leaderboard.setVisible(false);

        b.addActionListener(this);
        b.setForeground(Color.CYAN);
        b.setBounds((width-buttonWidth)/2, buttonHeight, buttonWidth, buttonHeight);
        b.setContentAreaFilled(false);
        b.setFont(new Font(fontType, Font.PLAIN, fontSize));

        panel.add(b);
        jframe.add(b);
    }

    public void actionPerformed(ActionEvent ae) {
        String comStr = ae.getActionCommand();
        if (comStr.equals("New game")){
            Game game= new Game("The Undertaker", 800, 600);
            game.start();
            jframe.dispose();
        } else if(comStr.equals("Tutorial")){
            new Tutorial();
            jframe.dispose();
        } else if(comStr.equals("Leaderboard")){
            try {
                new Leaderboard();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if(comStr.equals("Exit")){
            System.exit(0);
        }
        System.out.println(comStr + " Selected");
    }
}
