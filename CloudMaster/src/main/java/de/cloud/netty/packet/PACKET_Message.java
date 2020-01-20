package de.cloud.netty.packet;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import de.cloud.Logs;

public class PACKET_Message extends Packet {

    public PACKET_Message(String prefix, Runnable r) {
        super(prefix, r);
    }

    @Override
    public void exec() {

    }
}
