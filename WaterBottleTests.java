package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for the WaterBottle class.
 *
 * @author Nathameion Montgomery
 * @version Spring 2023
 */
public class WaterBottleTests {
    /** WaterBottle object to be used for testing. */
    private static WaterBottle waterBottle;


    @BeforeEach
    void setup() {
        final int mazeWallSize = 3;
        final int mazeEnemies = 10;
        final int mazeRoomSize = 500;
        waterBottle = new WaterBottle(new Vector2());
        Student student = new Student();
        Maze maze = new Maze(mazeWallSize, mazeWallSize, mazeRoomSize, mazeEnemies, student);
        GameModel.setMaze(maze);
    }

    /**
     * Test getPosition.
     */
    @Test
    void testGetPosition() {
        assertEquals(new Vector2(), waterBottle.getPosition(),
                "Method getPosition returned unexpected result.");
    }

    /**
     * Test ability.
     */
    @Test
    void testAbility() {
        int damageToStudent = 90;
        GameModel.getInstance().getMaze().getStudent().addHealth(-damageToStudent);
        waterBottle.ability();

        int expectedHealth = 60;

        int actualHealth = GameModel.getInstance().getMaze().getStudent().getHealth();

        assertEquals(expectedHealth, actualHealth,
                "WaterBottle had unexpected healing strength.");
    }
}
