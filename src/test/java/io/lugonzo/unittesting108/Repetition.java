package io.lugonzo.unittesting108;

import io.lugonzo.unittesting108.Utils.MathUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Repetition {

    MathUtils mathUtils;

    @BeforeEach
    void setup(){
        mathUtils = new MathUtils();
    }

    @RepeatedTest(3)
    void testSubtraction(RepetitionInfo repetitionInfo){

        if (repetitionInfo.getCurrentRepetition() == 2){
            System.out.print("Performing other operations ## No." + repetitionInfo.getCurrentRepetition());
        }

        assertEquals(3,mathUtils.minus(5,2));
    }
}
