package test.java.game;

import main.java.game.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void newGame() {
        Game gameTest = new Game();
        gameTest.newGame();
        assertEquals(2,gameTest.gameStatus);
    }
}