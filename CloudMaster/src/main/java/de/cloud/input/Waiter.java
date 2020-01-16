package de.cloud.input;

import java.util.Arrays;
import java.util.function.Consumer;

public class Waiter {
    private Consumer consumer;
    String[] waitables;
    public Waiter(Consumer c, String[] waitables){
        this.waitables = waitables.clone();
        this.consumer = c;
    }

    public boolean CheckIfFit(String a, boolean exec){
        if(Arrays.asList(waitables).contains(a)){
            return true;
        }else{
            return false;
        }
    }
    public void exec(String pattern){
        consumer.accept(pattern);
    }


}
