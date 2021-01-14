package test.java.game;

import main.java.game.Pipe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PipeTest {

    @Test
    void create() {
        Pipe testPipe = new Pipe();
        testPipe.create();
        assertNotNull(testPipe.pipes);
    }
}