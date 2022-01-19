package io.lugonzo.unittesting108;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import io.lugonzo.unittesting108.Utils.MathUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class LifeCycles {

    MathUtils mathUtils;

    @BeforeEach //set up initialization before each mthd
    void init(){
        mathUtils = new MathUtils();
        System.out.print("#BeforeEach# This needs to run b4 each mthd .... \n");
    }

    @BeforeAll
    static void beforeInitialization(){
        System.out.print("#BeforeAll# This needs to run b4 all mthd .... \n \n"   );
    }

    @AfterEach
     void cleanup(){
        System.out.print("#AfterEach# Cleaning up .... \n \n");
    }

    @AfterAll
    static void afterAllMethods(){
        System.out.print("#AterAll# This needs to run after all mthd .... \n \n");
    }


    @Test
    @DisplayName("Test add method")
    void add() {
        int expected = 2;
        int actual = mathUtils.add(1,1);

        System.out.print("add mthd \n");
        assertEquals(expected,actual);
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void divide() {
        System.out.print("divide mthd \n");
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1,0),"divide by 0 shld throw");
    }

    @Test
    @Disabled
    @DisplayName("This mthd should fail")
    void testDisabled() {
        fail("This test shld be disabled");
    }


}
