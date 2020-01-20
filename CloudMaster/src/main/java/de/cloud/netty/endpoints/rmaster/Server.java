package de.cloud.netty.endpoints.rmaster;

import de.cloud.netty.StandartServerBC;
import de.cloud.netty.packet.Packet;
import de.cloud.netty.utils.HERE_NettyBiConsumer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {

    public static ArrayList<Server> heres = new ArrayList<>();
    Socket socket;
    private InputStream is;
    private OutputStream os;
    protected Scanner sc;
    private HERE_NettyBiConsumer HERENettyBiConsumer;
    private ServerThread hereThread;
    public Server(Socket target, HERE_NettyBiConsumer standartHereNBC) throws IOException {

        heres.add(this);
        socket = target;
        is = target.getInputStream();
        os = target.getOutputStream();
        sc = new Scanner(is);

        HERENettyBiConsumer = standartHereNBC;
        hereThread = new ServerThread();
        hereThread.here = this;
        hereThread.sc = sc;
        hereThread.start();

    }

    public void test() throws IOException {
        send("test von here");
        System.out.println("test von here");
    }

    public static Server connect(String ip, int port) {
        try {
            return new Server(new Socket(ip, port), new StandartServerBC());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void send(Packet p) throws IOException {

        os.write(p.encode().getBytes());
    }

    public void NewMessage(String s) {
        HERENettyBiConsumer.run(this, s);
    }

    ;
    public void send(String p) throws IOException {
        os.write(p.getBytes());
    }


    public void stopListening() {
        hereThread.stop();
    }


}
