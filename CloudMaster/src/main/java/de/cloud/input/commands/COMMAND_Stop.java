package de.cloud.input.commands;

import de.cloud.Cloud;

import java.util.ArrayList;

public class COMMAND_Stop extends Command{
    public COMMAND_Stop(String name, String description, String[] keys) {
        super(name, description, keys);
    }

      @Override
    public void start(ArrayList<String> args) {
          if (args.isEmpty()) {
              Cloud.stop();
          }
      }
}
