package states;

import game.Game;
import gfx.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class GameOverState extends State implements ActionListener{

    private int width = 800;
    private int buttonHeight = 40;
    private int buttonWidth = 220;

    private BufferedImage background;
    private Canvas canvas;
    private JFrame jframe;

    private JButton start = new JButton("New game");
    private JButton exit = new JButton ("Exit");
    private JButton leaderboard = new JButton ("Leaderboard");
    private JPanel panel = new JPanel();

    private long score = 0;

    private JLabel gameOver = new JLabel("Game Over");
    private JLabel totalScore;

    private final int fontSize = 14;
    private final String fontType = "Times New Roman";


    public GameOverState(final long score){
        this.score = score;
        this.totalScore = new JLabel("Total score: " + this.score);
        this.jframe = new JFrame("Main Menu");
        setBackground();
        setFrame();
        createButtons();
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }

    public void actionPerformed(ActionEvent ae) {
        String comStr = ae.getActionCommand();
        if (comStr.equals("New game")){
            Game game= new Game("The Undertaker", 800, 600);
            game.start();
            jframe.dispose();
        } else if(comStr.equals("Leaderboard")){
            // Go to leaderboard
        } else if(comStr.equals("Exit")){
            System.exit(0);
        }
        System.out.println(comStr + " Selected");
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
        this.jframe.setBackground(Color.green);
    }

    private void setBackground(){
        this.background = ImageLoader.loadImage("/background.jpg");
        this.jframe.setContentPane(new JLabel(new ImageIcon(background)));
        this.jframe.pack();
    }



    private void createButtons(){
        start.addActionListener(this);
        leaderboard.addActionListener(this);
        exit.addActionListener(this);

        start.setForeground(Color.WHITE);
        leaderboard.setForeground(Color.WHITE);
        exit.setForeground(Color.WHITE);

        start.setBounds((width-buttonWidth)/2, 410, buttonWidth, buttonHeight);
        leaderboard.setBounds((width-buttonWidth)/2, 460, buttonWidth, buttonHeight);
        exit.setBounds((width-buttonWidth)/2, 510, buttonWidth, buttonHeight);

        start.setContentAreaFilled(false);
        leaderboard.setContentAreaFilled(false);
        exit.setContentAreaFilled(false);

        start.setFont(new Font(fontType, Font.PLAIN, fontSize));
        leaderboard.setFont(new Font(fontType, Font.PLAIN, fontSize));
        exit.setFont(new Font(fontType, Font.PLAIN, fontSize));

        panel.setBounds(800, 800, 200, 100);
        panel.add(start);
        panel.add(leaderboard);
        panel.add(exit);

        jframe.add(start);
        jframe.add(leaderboard);
        jframe.add(exit);

        gameOver.setForeground(Color.white);
        gameOver.setBounds(230, 0, 400, 300);
        gameOver.setFont(new Font(fontType, Font.PLAIN, 72));
        panel.add(gameOver);
        jframe.add(gameOver);

        totalScore.setForeground(Color.white);
        totalScore.setBounds(355, 150, 400, 300);
        totalScore.setFont(new Font(fontType, Font.PLAIN, 14));
        panel.add(totalScore);
        jframe.add(totalScore);
    }
}
