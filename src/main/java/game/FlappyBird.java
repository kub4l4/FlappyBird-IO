package main.java.game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

public class FlappyBird implements ActionListener, MouseListener, KeyListener {


    public static FlappyBird flappyBird;

    public Renderer renderer;
    public Music music = new Music();
    public Visuals visual = new Visuals();
    public JFrame jframe = new JFrame();

    Timer timer = new Timer(20, this);
    Game game = new Game();

    public static void main(String[] args) {
        flappyBird = new FlappyBird();
    }

    public FlappyBird() {
        initialize();
        visual.layout(visual.layoutNo);
        timer.start();
    }

    public void initialize() {
        renderer = new Renderer();
        jframe.add(renderer);
        jframe.setTitle("Flappy Creep");
        jframe.setIconImage(visual.icon);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(Constants.WINDOWSIZE, Constants.WINDOWSIZE);
        jframe.addMouseListener(this);
        jframe.addKeyListener(this);
        jframe.setResizable(false);
        jframe.setVisible(true);
        game.rand();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        game.render(renderer);
    }

    public void refresh(Graphics g) {
        game.draw(visual, g);
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == 1) {
            if (game.gameStatus == 1) {
                Point coords = e.getPoint();
                if (coords.x < 650 && coords.x > 150 && coords.y > 430 && coords.y < 490) { //Przycisk start nowej gry
                    game.newGame();
                }
                if (coords.x < 390 && coords.x > 160 && coords.y > 530 && coords.y < 590) { //Przycisk zmiana layout
                    visual.changeLayout();
                }
                if (coords.x < 650 && coords.x > 420 && coords.y > 540 && coords.y < 590) { //Przycisk wyjscie z gry
                    System.exit(0);
                }
            } else if (game.gameStatus == 3) {
                Point coords = e.getPoint();
                if (coords.x < 80 && coords.y < 90) {
                    game.gameStatus = 1;
                } else {
                    game.newGame();
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            if (game.gameStatus == 2) {
                game.tempFly();
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) { //wykonanie czynnosci po nacisnieciu spacji
            if (game.gameStatus == 1) {
                game.newGame();
            } else if (game.gameStatus == 2) {
                game.tempFly();
            } else if (game.gameStatus == 3) {
                game.newGame();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_L) {  //wykonanie czynnosci po nacisnieciu l
            visual.changeLayout();
        }
        if (e.getKeyCode() == KeyEvent.VK_M) {  //wykonanie czynnosci po nacisnieciu m
            music.changeMusic();
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) { //wykonanie czynnosci po nacisnieciu esc
            System.exit(0);
        }
    }
}