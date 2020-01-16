package de.cloud.commands.commands;

import de.cloud.commands.CommandMaster;
import lombok.Getter;

@Getter
public abstract class Command {
    public Command(String name, String description) {
        this.name = name;
        this.description = description;
        register();
    }


    public String name;
    public String description;

    public abstract void start();

    public void register() {
        CommandMaster.PushnewCommand(this);
    }

    ;


}
