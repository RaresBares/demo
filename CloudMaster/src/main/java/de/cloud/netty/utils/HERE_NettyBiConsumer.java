package de.cloud.netty.utils;

import de.cloud.netty.endpoints.rmaster.Server;

public interface HERE_NettyBiConsumer {

    public void run(Server here, String msg);

}
