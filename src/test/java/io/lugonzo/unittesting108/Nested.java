package io.lugonzo.unittesting108;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lugonzo.unittesting108.Utils.MathUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Nested {

    MathUtils mathUtils;

    @BeforeEach
    void setup(){
        mathUtils = new MathUtils();
    }

    @org.junit.jupiter.api.Nested
    @DisplayName(" Add Methode ")
    class AddTest {   // contains tests for add alone
        @Test
        @DisplayName("when adding  positive numbers")
        void testAddPositive() {

            assertEquals(2,mathUtils.add(1,1));
        }

        @Test
        @DisplayName("when adding   negative numbers")
        void testAddNegative() {

            assertEquals(-2,mathUtils.add(-1,-1));
        }
    }

}
