package de.cloud.netty.endpoints.rclient;

import java.util.Scanner;

public class ClientThread extends Thread {

    Client Client;
    Scanner sc;



    @Override
    public void run() {

        while (true) {

                if (sc.hasNext()) {
                    String msg = sc.next();
                    System.out.println("Client geschickt");
                    Client.NewMessage(msg);
                }

            try {
                sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

}
