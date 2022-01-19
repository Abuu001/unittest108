package io.lugonzo.unittesting108.Utils;

import java.util.function.Predicate;

public class Condition {

    public  boolean isAdult(int age){
        boolean status = true;

        if(age < 18)
            status = false;

        return status;
    }
}
