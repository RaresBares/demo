package de.cloud.input.commands;

import de.cloud.input.CommandMaster;
import lombok.Getter;

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

    public abstract void start();

    public void register() {
        CommandMaster.PushnewCommand(this);
    }

    ;


}
