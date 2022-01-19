package io.lugonzo.unittesting108.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class SomeBusinessImplTest {

    @Autowired
    SomeBusinessImpl business;

    @Test
    void calculateSum_basic() {
        SomeBusinessImpl b1 = new SomeBusinessImpl();

        int[] arr1 = {1,2,3};

       int actualResult = b1.calculateSum(arr1);
       int expectedResult = 6;

       assertEquals(actualResult,expectedResult);
    }

    @Test
    void calculateSum_with_empty_array() {
        SomeBusinessImpl b1 = new SomeBusinessImpl();

        int[] arr1 = {};

        int actualResult = b1.calculateSum(arr1);
        int expectedResult = 0;

        assertEquals(actualResult,expectedResult);
    }
}