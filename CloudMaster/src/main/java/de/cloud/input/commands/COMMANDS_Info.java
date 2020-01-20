package de.cloud.input.commands;

import de.cloud.Logs;

import java.util.ArrayList;

public class COMMANDS_Info extends Command{
    public COMMANDS_Info(String name, String description, String[] keys) {

        super(name, description, keys);

    }

    @Override
    public void start(ArrayList<String> args) {
        if(args.isEmpty()) {
            Logs.log(Logs.NOTHING, "OS: " + System.getProperty("os.name"));
            Logs.log(Logs.NOTHING, "JVM-Version: " + System.getProperty("java.runtime.version"));
            Logs.log(Logs.NOTHING, "UserName: " + System.getProperty("user.name"));
        }
    }

}
