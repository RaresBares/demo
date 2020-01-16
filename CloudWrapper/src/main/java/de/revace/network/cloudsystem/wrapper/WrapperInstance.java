package de.revace.network.cloudsystem.wrapper;

import de.revace.network.cloudsystem.wrapper.core.ConnectionClient;

public class WrapperInstance {
    private static ConnectionClient connectionClient;

    public static void main(String[] args) {
        startup();
    }

    private static void startup() {
        connectionClient = new ConnectionClient();
    }

    public static ConnectionClient getConnectionClient() {
        return connectionClient;
    }
}
