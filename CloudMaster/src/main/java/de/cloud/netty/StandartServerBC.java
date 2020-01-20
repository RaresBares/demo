package de.cloud.netty;

import de.cloud.Logs;
import de.cloud.netty.endpoints.rmaster.Server;
import de.cloud.netty.utils.HERE_NettyBiConsumer;

public class StandartServerBC implements HERE_NettyBiConsumer {
    @Override
    public void run(Server here, String msg) {
        Logs.log(Logs.INFORMATION, msg);

    }
}