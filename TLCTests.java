package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for the TLC class.
 *
 * @author Nathameion Montgomery
 * @version Spring 2023
 */
public class TLCTests {
    /** TLC object to be used for testing. */
    private static TLC tlc;


    @BeforeEach
    void setup() {
        final int mazeWallSize = 3;
        final int mazeEnemies = 10;
        final int mazeRoomSize = 500;
        tlc = new TLC(new Vector2());
        Student student = new Student();
        Maze maze = new Maze(mazeWallSize, mazeWallSize, mazeRoomSize, mazeEnemies, student);
        GameModel.setMaze(maze);
    }

    /**
     * Test getPosition.
     */
    @Test
    void testGetPosition() {
        assertEquals(new Vector2(), tlc.getPosition(),
                "Method getPosition returned unexpected result.");
    }

    /**
     * Test ability.
     */
    @Test
    void testAbility() {
        int confusionToAdd = 61;
        GameModel.getInstance().getMaze().getStudent().addConfusion(confusionToAdd);
        tlc.ability();

        int expectedConfusion = 0;

        int actualConfusion = GameModel.getInstance().getMaze().getStudent().getConfusion();

        assertEquals(expectedConfusion, actualConfusion,
                "TLC had unexpected effects.");
    }
}
