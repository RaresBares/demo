package de.cloud;

import de.cloud.input.CommandMaster;
import de.cloud.input.InputWaiter;

public class Cloud {

    public static void main(String[] args){
            Logs.log(Logs.WARNING,  "Cloud wird gestartet...");
        CommandMaster.setup();
        new InputWaiter(System.in);

    }

}
