package de.revace.network.cloudsystem.master;

import de.revace.network.cloudsystem.master.core.ConnectionServer;

public class MasterInstance {
    private static ConnectionServer connectionServer;

    public static void main(String [] args) {
        startup();
    }

    private static void startup() {
        connectionServer = new ConnectionServer();
    }

    public static ConnectionServer getConnectionServer() {
        return connectionServer;
    }
}
