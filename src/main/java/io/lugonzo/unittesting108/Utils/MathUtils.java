package io.lugonzo.unittesting108.Utils;

public class MathUtils {

    /**
     * Perform addition
     *
     * @param a
     * @param b
     *
     * @return a + b
     */
    public int add(int a ,int b){
        return a + b;
    }

    public double computeCircleArea(double radius){
        return Math.round (Math.PI * radius * radius) ;
    }

    public int divide(int a ,int b){
        return a / b;
    }

    public int minus(int a ,int b){
        return a - b;
    }

    public int multiply(int a ,int b){
        return a * b;
    }

}
