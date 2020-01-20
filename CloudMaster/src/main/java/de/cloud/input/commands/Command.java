package de.cloud.input.commands;

import de.cloud.Cloud;
import de.cloud.input.CommandMaster;
import lombok.Getter;

import java.io.IOException;
import java.util.ArrayList;

@Getter
public abstract class Command {
    public Command(String name, String description, String[] keys) {
        this.name = name;
        this.description = description;
        register();
        this.keys = keys;
    }

    public String[] keys;
    public String name;
    public String description;

    public abstract void start(ArrayList<String> args) throws IOException;

    public void register() {
        Cloud.commandMaster.PushnewCommand(this);
    }

    ;


}
