package de.cloud;

import de.cloud.files.CloudProperties;
import de.cloud.files.FileManager;
import de.cloud.files.RProperties;
import de.cloud.files.fileutils.Files;
import de.cloud.input.CommandMaster;
import de.cloud.input.InputWaiter;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;


@Getter
public class Cloud {

    public static RProperties CloudProps;
   // public static InputWaiter inputWaiter;
   // public static CommandMaster commandMaster;



    public static void start(){
        Logs.log(Logs.INFORMATION,  "Cloud wird gestartet...");
        FileManager.reloadFiles();
        CloudProps = new CloudProperties(new File(Files.COUD_PROPS.getName()));
      new CommandMaster(). setup();


      new InputWaiter(System.in);
    }
    public static void stop(){
        CloudProps = null;

    }
    public static void restart(){
        stop();
        start();
    }
    public static void main(String[] args) throws IOException {

        start();
    }
}
