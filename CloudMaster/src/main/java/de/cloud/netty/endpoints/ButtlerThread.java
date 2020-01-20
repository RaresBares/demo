package de.cloud.netty.endpoints;

import de.cloud.netty.StandartClientBC;
import de.cloud.netty.endpoints.rclient.Client;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ButtlerThread extends Thread{





    @SneakyThrows
    @Override
    public void run(){

        ServerSocket server = new ServerSocket( 3141 );

        while ( true )
        {
            Socket client = null;

            try
            {
                client = server.accept();
                System.out.println("Client angenommen");
               Client backClient = new Client(client, new StandartClientBC());

            }
            catch ( Exception e ) {
                e.printStackTrace();
            }
            finally {
                if ( client != null )
                    try { client.close(); } catch ( IOException e ) { }
            }
        }
    }

}
