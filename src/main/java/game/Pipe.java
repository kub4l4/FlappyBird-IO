package main.java.game;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Pipe {

    public ArrayList<Rectangle> pipes;
    public Random rand = new Random();
    int space;
    int width;
    int height;

    public Pipe() {
        pipes = new ArrayList<>();
        space = 350;
        width = 100;
        Random rand = new Random();
    }

    public void create() { //tworze MAXPIPES  rury
        pipes.clear();
        for (int i = 0; i < Constants.MAXPIPESNUM; i++) {
            resetSpace(rand);
            pipes.add(new Rectangle(Constants.WINDOWSIZE + width + pipes.size() * Constants.DISTANCEBEETWEENPIPES, Constants.MAPMAXHEIGHT - height, width, height));
            pipes.add(new Rectangle(Constants.WINDOWSIZE + width + (pipes.size() - 1) * Constants.DISTANCEBEETWEENPIPES, Constants.MAPMINHEIGHT, width, Constants.WINDOWSIZE - height - space));
        }
    }

    public void resetSpace(Random rand) { //resetuje wysokosc na ktorej znajduje sie szpara miedzy rurami
        height = Constants.MINHEIGHTPIPE + rand.nextInt(350);
    }

    public void move(int speed) { //przesuwam rury w lewo
        for (Rectangle pipe : pipes) {
            pipe.x -= speed;
        }
    }

    public void replace() { //zastepuje rure, która gracz juz pokonał nową rurą
        for (int i = 0; i < pipes.size(); i++) {
            Rectangle pipe = pipes.get(i);
            if (pipe.x + pipe.width < 0) {
                pipes.remove(pipe);
                if (pipe.y == 0) {
                    resetSpace(rand);
                    pipes.add(new Rectangle(pipes.get(pipes.size() - 1).x + 2*Constants.DISTANCEBEETWEENPIPES, Constants.MAPMAXHEIGHT - height, width, height));
                    pipes.add(new Rectangle(pipes.get(pipes.size() - 1).x, Constants.MAPMINHEIGHT, width, Constants.WINDOWSIZE - height - space));
                }
            }
        }
    }
}
