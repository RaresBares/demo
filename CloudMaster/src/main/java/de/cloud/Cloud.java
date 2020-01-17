package de.cloud;

import de.cloud.files.CloudProperties;
import de.cloud.input.CommandMaster;
import de.cloud.input.InputWaiter;
import lombok.Getter;

import java.io.File;
import java.util.Properties;

@Getter
public class Cloud {

    private final Properties CloudProps = new CloudProperties(new File("./cloud.properties"));

    public static void main(String[] args){
            Logs.log(Logs.WARNING,  "Cloud wird gestartet...");
        CommandMaster.setup();
        new InputWaiter(System.in);

    }

}
