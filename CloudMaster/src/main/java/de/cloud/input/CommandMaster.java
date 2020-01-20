package de.cloud.input;

import de.cloud.input.commands.*;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.Properties;

public class CommandMaster {

   public   ArrayList<Command> commands = new ArrayList<>();


public   void setup(){

    new COMMANDS_Info("info", "get Info", new String[]{"info", "i"});
    new COMMAND_Stop("stop", "Stop the Cloud", new String[]{"stop"});
    new COMMAND_Restart("restart", "restart the Cloud", new String[]{"restart","reload"});
    new COMMAND_NETTYTEST("test", "test the Cloud", new String[]{"test"});

}

  public  void PushnewCommand(Command c) {

      commands.add(c);


  }
  public    void close(){
    commands.clear();
  }

}
