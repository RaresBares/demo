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
import java.util.ArrayList;


@Getter
public class Cloud {

    public static RProperties CloudProps;
    public static InputWaiter inputWaiter;
    public static CommandMaster commandMaster;
    public static ArrayList<Files> filled = new ArrayList<>();




    public static void main(String[] args) throws IOException {

        start();
    }

    public static void start() throws IOException {


        Runnable r = () -> {
            int i = 3;
            while (i != 0) {
                Logs.log(Logs.INFORMATION, "Cloud starting in " + i);
                i--;
                try {

                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Logs.log(Logs.INFORMATION, "Cloud starting...");
            FileManager.reloadFiles();








            CloudProps = new CloudProperties(new File(Files.COUD_PROPS.getName()));
            commandMaster = new CommandMaster();

            commandMaster.setup();
        };

        Thread t = new Thread(r);

        t.start();
        if (!filled.isEmpty()) {
            for (Files files : filled) {
                FileManager.setupFiles(files);
                filled.remove(files);
            }
        }

        inputWaiter = new InputWaiter(System.in);
    }

    public static void stop() {
        Logs.log(Logs.INFORMATION, "Cloud stopping...");
        CloudProps = null;
        inputWaiter = null;
        commandMaster = null;
        Logs.log(Logs.INFORMATION, "Cloud stopped");
        System.exit(0);
    }

    public static void restart() throws IOException {
        stop();


        start();


    }


}
