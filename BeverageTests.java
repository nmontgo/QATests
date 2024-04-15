package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for the Beverage class.
 *
 * @author Nathameion Montgomery
 * @version Spring 2023
 */
public class BeverageTests {
    /** Beverage object to be used for testing. */
    private static Beverage beverage;


    @BeforeEach
    void setup() {
        final int mazeWallSize = 3;
        final int mazeEnemies = 10;
        final int mazeRoomSize = 500;
        beverage = new Beverage(new Vector2());
        Student student = new Student();
        Maze maze = new Maze(mazeWallSize, mazeWallSize, mazeRoomSize, mazeEnemies, student);
        GameModel.setMaze(maze);
    }

    /**
     * Test getPosition.
     */
    @Test
    void testGetPosition() {
        assertEquals(new Vector2(), beverage.getPosition(),
                "Method getPosition returned unexpected result.");
    }

    /**
     * Test ability.
     */
    @Test
    void testAbility() {
        int damageToStudent = 50;
        GameModel.getInstance().getMaze().getStudent().addHealth(-damageToStudent);
        beverage.ability();
        int expectedHealth = 75;
        int expectedConfusion = 25;

        int[] expectedResults = new int[] {expectedHealth, expectedConfusion};

        int actualHealth = GameModel.getInstance().getMaze().getStudent().getHealth();
        int actualConfusion = GameModel.getInstance().getMaze().getStudent().getConfusion();

        int[] actualResults = new int[] {actualHealth, actualConfusion};

        assertArrayEquals(expectedResults, actualResults,
                "Beverage had unexpected effects.");
    }
}
