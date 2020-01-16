package de.cloud;

import de.cloud.input.CommandMaster;
import de.cloud.input.InputWaiter;
import de.cloud.input.Waiter;
import de.cloud.utilities.ConsoleColors;

import java.io.InputStream;

public class Cloud {

    public static void main(String[] args){
            Logs.log(Logs.WARNING,  "Cloud wird gestartet...");
        CommandMaster.setup();
        new InputWaiter(System.in);

    }

}
