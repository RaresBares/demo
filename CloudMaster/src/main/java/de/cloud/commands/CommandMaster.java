package de.cloud.commands;

import de.cloud.commands.commands.Command;

import java.util.ArrayList;
import java.util.TreeSet;

public class CommandMaster {

   private static ArrayList<Command> commands = new ArrayList<>();

  public static void PushnewCommand(Command c){
      commands.add(c);
  }
}
