package de.cloud.input.commands;

import de.cloud.Cloud;

import java.io.IOException;
import java.util.ArrayList;

public class COMMAND_NETTYTEST extends Command {


    public COMMAND_NETTYTEST(String name, String description, String[] keys) {
        super(name, description, keys);
    }

    @Override
    public void start(ArrayList<String> args) {
        try {
            Cloud.here.test();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
