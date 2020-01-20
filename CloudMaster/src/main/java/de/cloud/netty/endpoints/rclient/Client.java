package de.cloud.netty.endpoints.rclient;

import de.cloud.netty.packet.Packet;
import de.cloud.netty.utils.THERE_NettyBiConsumer;
import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

@Getter
public class Client {

    public static ArrayList<Client> clients = new ArrayList<>();
    private InputStream is;
    private OutputStream os;
    protected Scanner scanner;
    protected ClientThread ClientThread;
    private THERE_NettyBiConsumer THERENettyBiConsumer;
    public Client(Socket s, THERE_NettyBiConsumer THERENettyBiConsumer) throws IOException {
        is = s.getInputStream();
        os = s.getOutputStream();

        scanner = new Scanner(is);
        ClientThread = new ClientThread();

        clients.add(this);
        startListening();
        this.THERENettyBiConsumer = THERENettyBiConsumer;
        ClientThread.Client = this;
        ClientThread.sc = scanner;
        System.out.println("Client erstellt");
    }

    public void startListening(){
        ClientThread.start();
    }
    public void stopListening(){
        ClientThread.stop();
    }

    public void send(Packet p) throws IOException {
        os.write(p.encode().getBytes());
    }

    public void send(String p) throws IOException {
        os.write(p.getBytes());
    }

    public  void NewMessage(String s){
        THERENettyBiConsumer.run(this, s);
    };

}
