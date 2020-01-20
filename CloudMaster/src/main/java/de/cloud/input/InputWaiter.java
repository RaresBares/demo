package de.cloud.input;

import de.cloud.Cloud;
import de.cloud.Logs;
import de.cloud.input.commands.Command;
import javafx.util.Pair;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputWaiter extends Thread{
    InputStream is;
    private ArrayList<Waiter> waiters= new ArrayList<>();
    public InputWaiter(InputStream is){
        super();
        this.is = is;
        run();
    }
    @Override
    public void run(){
        Scanner sc = new Scanner(System.in);


        while (true) {
            if(sc.hasNext()){
                String nextLine = sc.nextLine();
                String current = nextLine.split(" ")[0];
                List<String> argsprototype = Arrays.asList(nextLine.split(" "));

                ArrayList<String> args = new ArrayList<>(argsprototype);
                args.remove(current);
                if(isWaiterWaiting(current).getValue()){
                    isWaiterWaiting(current).getKey().exec(current);
                    waiters.remove( isWaiterWaiting(current).getKey());
                }else{
                    Command c = GetCommandbyPattern(current);
                    if(c != null){

                        try {
                            c.start(args);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }else{
                        Logs.log(Logs.ERROR, " Diesen Befehl gibt es nicht!");
                    }
                }
            }


        }

    }
    private Pair<Waiter, Boolean> isWaiterWaiting(String a){
        Pair<Waiter, Boolean> pair = new Pair< >(null, false);
        for (Waiter waiter : waiters) {

            if(waiter.CheckIfFit(a,false)){
                pair = new Pair<>(waiter, true);
                return pair;
            }
        }
        return pair;
    }
    private Command GetCommandbyPattern(String a){
        for(Command c : Cloud.commandMaster.commands){
            if(Arrays.asList(c.getKeys()).contains(a)){
                return c;
            }
        }
        return null;
    }
}
