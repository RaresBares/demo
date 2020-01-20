package de.cloud.netty.packet;


import com.sun.jmx.snmp.SnmpOpaque;
import de.cloud.Cloud;
import de.cloud.Logs;
import de.cloud.files.CloudProperties;
import lombok.Getter;

import java.util.HashMap;
import java.util.function.Consumer;

@Getter
public abstract class Packet {

    private String key;
    private String prefix;


    public Packet(String prefix, Runnable r){

        this.prefix = prefix;
        key = "Cloud.CloudProps.getString()";
        setRunnable(r);
    }

    public String encode() {
        String s = "";
        s = getPrefix() + "://" + getKey() + "://";
        return s;
    }
    public void setRunnable(Runnable r) {

        runnable = r;
    }
    public  Runnable runnable;

    public abstract void exec();





}
