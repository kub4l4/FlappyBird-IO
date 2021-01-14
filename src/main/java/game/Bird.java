package main.java.game;

import java.awt.*;

public class Bird {

    public Rectangle rectangleBird;
    public int yPozBirdShift;

    public Bird(){
    }

    public void resetBird() {
        rectangleBird = new Rectangle(Constants.WINDOWSIZE / 2 - 10, Constants.WINDOWSIZE / 2 - 10, Constants.PLAYERSIZE, Constants.PLAYERSIZE);
        yPozBirdShift = 0;
    }

    public void flyUp() {
        if (yPozBirdShift > 0) {
            yPozBirdShift = 0;
        }
        yPozBirdShift -= 10;
    }

    public void flyDown(){
        yPozBirdShift += 2;
    }

    public void move(){
        rectangleBird.y += yPozBirdShift;
    }

}
