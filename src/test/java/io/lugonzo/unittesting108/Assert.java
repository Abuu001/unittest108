package io.lugonzo.unittesting108;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import io.lugonzo.unittesting108.Utils.Condition;
import io.lugonzo.unittesting108.Utils.MathUtils;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Assert {

    @Test
    public void checkIfArrayValuesAreEquall(){
        String[] arr1 ={"s1,s2,s3"};
        String[] arr2 ={"s1,s2,s3"};

        assertArrayEquals(arr1,arr2);
     }

    @Test
    public void checkIfNotAdult(){
        Condition c1 = new Condition();

        int age = 5;
        boolean status = c1.isAdult(age);

        assertFalse(status);
    }

    @Test
    @DisplayName("test multiplcation")
    void testMultiply(){
        MathUtils mathUtils = new MathUtils();

        assertAll(
                () -> assertEquals(4,mathUtils.multiply(2,2)),
                () -> assertEquals(16,mathUtils.multiply(4,4)),
                () -> assertEquals(0,mathUtils.multiply(0,2)),
                () -> assertEquals(7,mathUtils.multiply(1,7))
        );  // if all conditions pass then test will pass
    }

    @Test
    public void test2(){
        List<Integer> numbers = Arrays.asList(12,23,34,45);

        assertThat(numbers)
                .contains(12,45)
                .allMatch(x -> x > 1);

        assertThat("").isEmpty();
        assertThat("ABCDE")
                .contains("BCD")
                .startsWith("A");
    }

  /*   @Test
    public void checkIfIterablesAreEqual(){
        List<Long> actual = List.of(2L,3L,4L);
        List<Long> expected = List.of(2L,3L,4L);

        assertIterableEquals(expected,actual);
     }*/


}
