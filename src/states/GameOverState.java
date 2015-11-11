package states;

import game.Game;
import gfx.ImageLoader;
import menu.Leaderboard;
import menu.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    private JButton submit = new JButton("Submit");
    private long score = 0;

    private JLabel gameOver = new JLabel("Game Over");
    private JLabel totalScore;
    private JTextField input = new JTextField();

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
            try {
                new Leaderboard();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if(comStr.equals("Exit")){
            System.exit(0);
        } else if(comStr.equals("Submit")){
            checkingIfTheUserIsInTopFive();
            //System.exit(0);
            new MainMenu();
            jframe.dispose();

        }
        System.out.println(comStr + " Selected");
    }

    private void checkingIfTheUserIsInTopFive() {
        LinkedHashMap<String, Long> statistics = new LinkedHashMap<>();
        String userName = input.getText();
        Long pointsOfUser = score;
        boolean userSaved = false;
        int numberOfUsersSaved = 0;
        try(BufferedReader bufferedReader =
                    new BufferedReader(
                            new FileReader("Resources/Leaderboard.txt"))){
            String playerStats;
            while (!((playerStats=bufferedReader.readLine())== null)){
                numberOfUsersSaved++;
                String name = playerStats.split(" ")[1];
                System.out.println();
                System.out.println(name);
                Pattern pattern = Pattern.compile("\\d{3,}");
                Matcher matcher = pattern.matcher(playerStats);
                matcher.find();
                Long points = Long.parseLong(matcher.group(0));
                if(pointsOfUser > points && !userSaved){
                    statistics.put(userName, pointsOfUser);
                    userSaved = true;
                }
                if(numberOfUsersSaved == 5){
                    savingNewLeaderBoard(statistics);
                    return;
                }
                statistics.put(name, points);
            }
        } catch (NoSuchElementException ex){
            System.out.print("Leaders not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void savingNewLeaderBoard(LinkedHashMap<String, Long> statistics) {
        int index = 1;
        try( BufferedWriter bufferedWriter =
                     new BufferedWriter(
                             new FileWriter("Resources/Leaderboard.txt"))){
            for(String user : statistics.keySet()){
                String stats = String.format("%d. %s - %dpts", index, user, statistics.get(user));
                if(index == 5){
                    bufferedWriter.write(stats);
                } else {
                    bufferedWriter.write(stats + "\n");
                }
                index++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

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
        submit.addActionListener(this);

        start.setForeground(Color.WHITE);
        leaderboard.setForeground(Color.WHITE);
        exit.setForeground(Color.WHITE);
        submit.setForeground(Color.WHITE);
        input.setForeground(Color.BLACK);

        input.setBounds(200, 360, buttonWidth, buttonHeight - 15 );
        submit.setBounds(440, 360, buttonWidth - 80, buttonHeight - 15);
        start.setBounds((width-buttonWidth)/2, 410, buttonWidth, buttonHeight);
        leaderboard.setBounds((width-buttonWidth)/2, 460, buttonWidth, buttonHeight);
        exit.setBounds((width-buttonWidth)/2, 510, buttonWidth, buttonHeight);

        submit.setContentAreaFilled(false);
        start.setContentAreaFilled(false);
        leaderboard.setContentAreaFilled(false);
        exit.setContentAreaFilled(false);
        input.setBorder(BorderFactory.createEmptyBorder());

        input.setFont(new Font(fontType, Font.PLAIN, fontSize));
        submit.setFont(new Font(fontType, Font.PLAIN, fontSize));
        start.setFont(new Font(fontType, Font.PLAIN, fontSize));
        leaderboard.setFont(new Font(fontType, Font.PLAIN, fontSize));
        exit.setFont(new Font(fontType, Font.PLAIN, fontSize));


        panel.setBounds(800, 800, 200, 100);
        panel.add(input);
        panel.add(start);
        panel.add(leaderboard);
        panel.add(exit);
        panel.add(submit);

        jframe.add(input);
        jframe.add(submit);
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
