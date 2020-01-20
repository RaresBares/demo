package de.cloud.netty;

import de.cloud.Logs;
import de.cloud.netty.endpoints.rclient.Client;
import de.cloud.netty.utils.THERE_NettyBiConsumer;

public class StandartClientBC implements THERE_NettyBiConsumer {
    @Override
    public void run(Client client, String msg) {
        Logs.log(Logs.INFORMATION, msg);

    }
}
