package io.lugonzo.unittesting108.service;

import io.lugonzo.unittesting108.interfaces.SomeDataService;

public class SomeBusinessImpl {

    /**
     * adds all data in the array
     *
     * @param data
     * @return
     */
    public int calculateSum(int[] data){
        int sum =0;

        for(int value : data){
            sum += value;
        }

        return sum;
    }

}
