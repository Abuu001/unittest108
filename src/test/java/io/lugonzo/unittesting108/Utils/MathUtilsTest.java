package io.lugonzo.unittesting108.Utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MathUtilsTest {

    @Test
    @Tag("Math")
    void add() {
        MathUtils mathUtils = new MathUtils();

        int expected = 2;
        int actual = mathUtils.add(1,1);

        assertEquals(expected,actual);
    }

    @Test
    @Tag("Circle")
    void testComputeCircleRadius() {
        MathUtils mathUtils = new MathUtils();

        assertEquals(314.159,mathUtils.computeCircleArea(10),"Should return area of circle");
    }

    @Test
    @Tag("Math")
    void divide() {
        MathUtils mathUtils = new MathUtils();
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1,0),"divide by 0 shld throw");
    }
}