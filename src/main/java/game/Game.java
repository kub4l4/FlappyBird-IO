package main.java.game;

import java.awt.*;
import java.util.Random;

public class Game {

    Bird bird = new Bird();
    Pipe pipeNew = new Pipe();

    public int score;
    public int timerTick;
    public int gameStatus;  //Home Screen = 1, Game playing = 2, GameOver screen = 3, error = 0;

    public Game(){
        gameStatus = 1;
    }

    public void newGame() {
        bird.resetBird();
        pipeNew.create();
        gameStatus = 2;
        score = 0;
    }

    public void getPoint(Rectangle pipe, Bird bird){
        if (pipe.y == 0 && bird.rectangleBird.x + bird.rectangleBird.width / 2 > pipe.x + pipe.width / 2 - 7 && bird.rectangleBird.x + bird.rectangleBird.width / 2 < pipe.x + pipe.width / 2 + 7 && !(gameStatus == 3)) {
            score++;
        }
    }

    public void collision(Rectangle pipe, Bird bird){
        if (pipe.intersects(bird.rectangleBird)) {
            gameStatus = 3;
            if (bird.rectangleBird.x <= pipe.x) {
                bird.rectangleBird.x = pipe.x - bird.rectangleBird.width;
            } else if (pipe.y != 0) {
                bird.rectangleBird.y = pipe.y - bird.rectangleBird.height;
            } else if (bird.rectangleBird.y < pipe.height) {
                bird.rectangleBird.y = pipe.height;
            }
        } else if (bird.rectangleBird.y > Constants.MAPMAXHEIGHT || bird.rectangleBird.y < 0) {
            gameStatus = 3;
        } else if (bird.rectangleBird.y + bird.yPozBirdShift >= Constants.MAPMAXHEIGHT) {
            bird.rectangleBird.y = Constants.MAPMAXHEIGHT - bird.rectangleBird.height;
            gameStatus = 3;
        }
    }

    public void render(Renderer renderer){
        timerTick++;
        if (gameStatus == 2) {
            pipeNew.replace();
            pipeNew.move(Constants.PLAYERSPEED);
            bird.move();
            if (timerTick % 2 == 0) {
                bird.flyDown();
            }
            for (Rectangle pipe : pipeNew.pipes) {
                getPoint(pipe, bird);
                collision(pipe, bird);
            }
        }
        renderer.repaint();
    }
    public void draw(Visuals visual, Graphics g){
        if (gameStatus == 1) {
            visual.homeScreen(g);
        } else {
            visual.drawGame(g, bird.rectangleBird);
            for (Rectangle pipe : pipeNew.pipes) {
                visual.drawPipe(g, pipe);
            }
            g.setColor(Color.white);

            if (gameStatus == 1) {
                visual.startBanner(g);
            } else if (gameStatus == 2) {
                visual.scoreBar(g, score);
            } else if (gameStatus == 3) {
                visual.gameOverScreen(g, score);
            }
        }
    }
    public void tempFly(){
        bird.flyUp();
    }
    public void rand() {

        pipeNew.rand = new Random();
    }
}
