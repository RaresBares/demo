package de.cloud.netty.endpoints.rmaster;

import java.util.Scanner;

public class ServerThread extends Thread {

    public Server here;
    public Scanner sc;



    @Override
    public void run() {

        while (true) {
            if (!isInterrupted()) {
                if (sc.hasNext()) {
                    String msg = sc.next();
                    here.NewMessage(msg);
                }
            }
            try {
                sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

}
