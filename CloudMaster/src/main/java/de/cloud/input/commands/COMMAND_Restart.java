package de.cloud.input.commands;

import de.cloud.Cloud;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class COMMAND_Restart extends Command{
    public COMMAND_Restart(String name, String description, String[] keys) {
        super(name, description, keys);
    }

    @Override
    public void start(ArrayList<String> args) throws IOException {
        if(args.isEmpty()) {
            Cloud.restart();
        }
    }
}
