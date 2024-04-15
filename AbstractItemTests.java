package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests for the AbstractItem class.
 *
 * @author Nathameion Montgomery
 * @version Spring 2023
 */
public class AbstractItemTests {
    /** Beverage object to be used for testing. */
    private static Beverage beverage;

    /** TLC object to be used for testing. */
    private static TLC tlc;

    /** WaterBottle object to be used for testing. */
    private static WaterBottle waterBottle;

    @BeforeEach
    void setup() {
        beverage = new Beverage(new Vector2());
        tlc = new TLC(new Vector2());
        waterBottle = new WaterBottle(new Vector2());
    }

    /**
     * Test constructor that has a Vector2 parameter with null.
     */
    @Test
    void testInitialPositionConstructorNullParam() {
        assertThrows(NullPointerException.class, () -> new Beverage(null),
                "NullPointerException should be thrown for null initial position.");
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
     * Test toString.
     */
    @Test
    void testToString() {
        String expected = "WaterBottle (0.000000, 0.000000)";
        assertEquals(expected, waterBottle.toString());
    }
}
