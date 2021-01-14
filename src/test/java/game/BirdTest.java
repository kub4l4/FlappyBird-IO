package test.java.game;

import main.java.game.Bird;

import static org.junit.jupiter.api.Assertions.*;

class BirdTest {

    private int temp;

    @org.junit.jupiter.api.Test
    void resetBird() {
        Bird testBird = new Bird();
        testBird.yPozBirdShift = 10;
        testBird.resetBird();
        assertEquals(0, testBird.yPozBirdShift);
    }

    @org.junit.jupiter.api.Test
    void flyUp() {
        Bird testBird = new Bird();
        temp = testBird.yPozBirdShift;
        testBird.flyUp();
        assertNotEquals(temp, testBird.yPozBirdShift);
    }

    @org.junit.jupiter.api.Test
    void flyDown() {
        Bird testBird = new Bird();
        temp = testBird.yPozBirdShift;
        testBird.flyDown();
        assertNotEquals(temp, testBird.yPozBirdShift);
    }

    @org.junit.jupiter.api.Test
    void move() {
        Bird testBird = new Bird();
        testBird.resetBird();
        temp = testBird.rectangleBird.y;
        testBird.yPozBirdShift=10;
        testBird.move();
        assertNotEquals(temp, testBird.rectangleBird.y);
    }
}