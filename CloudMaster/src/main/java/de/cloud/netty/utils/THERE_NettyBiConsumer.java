package de.cloud.netty.utils;

import de.cloud.netty.endpoints.rclient.Client;

public interface THERE_NettyBiConsumer {

    public void run(Client client, String msg);

}
