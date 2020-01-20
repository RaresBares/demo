package de.cloud.netty.packet;

public class PACKET_StopServer extends Packet{


    public PACKET_StopServer() {
        super("serverstop", new Runnable() {
            @Override
            public void run() {
                System.exit(1);
            }
        });

    }




    @Override
    public void exec() {
        runnable.run();
    }


}
