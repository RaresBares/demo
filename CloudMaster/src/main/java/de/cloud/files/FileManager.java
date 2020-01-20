package de.cloud.files;

import de.cloud.Cloud;
import de.cloud.Logs;
import de.cloud.files.fileutils.Files;
import de.cloud.utilities.ConsoleColors;
import javafx.util.Pair;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileManager {


    public static Pair<Boolean, ArrayList<Files>> isEveryThing() {
        boolean b = true;
        ArrayList<Files> files = new ArrayList<>();
        for (Files f : Files.values()) {
            if (f != Files.ALL) {
                File file = new File(f.getName());
                if (file.exists()) {

                } else {
                    if (b) {
                        b = false;
                    }
                    Logs.log(Logs.WARNING, "Missing File: " + f.getName());
                    files.add(f);
                }
            }
        }
        return new Pair<>(b, files);
    }

    public static void setup(Files... files) throws IOException {
        Logs.log(Logs.INFORMATION, "Initializating Files");
        File files1 = new File("./Cloud");
        Logs.log(Logs.INFORMATION, files1.getAbsolutePath());
        List<Files> f = Arrays.asList(files);
        if (f.contains(Files.ALL)) {

            for (Files rfile : Files.values()) {

                if (rfile != Files.ALL) {

                    File file = new File(rfile.getName());
                    if (file.exists()) {
                        deleteFiles(rfile);
                    } else {

                        if (file.isDirectory() || !file.getName().contains(".")) {
                            file.mkdirs();
                        } else {

                            Logs.log(Logs.INFORMATION, rfile.getName());
                            Logs.log(Logs.INFORMATION, file.getAbsolutePath());
                            file.createNewFile();
                        }

                    }
                }
            }
        } else {
            for (Files rfile : f) {
                File file = new File(rfile.getName());
                if (file.exists()) {
                    deleteFiles(rfile);
                } else {
                    ;

                    try {
                        if (file.isDirectory()) {
                            file.mkdirs();
                        } else {
                            file.createNewFile();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    public static void setup(ArrayList<Files> files) throws IOException {
        Logs.log(Logs.INFORMATION, "Initializating Files");

        List<Files> f = files;
        if (f.contains(Files.ALL)) {

            for (Files rfile : Files.values()) {

                if (rfile != Files.ALL) {

                    File file = new File(rfile.getName());
                    if (file.exists()) {
                        deleteFiles(rfile);
                    } else {

                        if (file.isDirectory() || !file.getName().contains(".")) {
                            file.mkdirs();
                        } else {

                            Logs.log(Logs.INFORMATION, rfile.getName());
                            Logs.log(Logs.INFORMATION, file.getAbsolutePath());
                            file.createNewFile();
                        }

                    }
                }
            }
        } else {
            for (Files rfile : f) {
                File file = new File(rfile.getName());
                if (file.exists()) {
                    deleteFiles(rfile);
                } else {
                    ;

                    try {
                        if (file.isDirectory()) {
                            file.mkdirs();
                        } else {
                            file.createNewFile();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    private static void deleteFiles(Files... files) {
        for (Files f : files) {
            File file = new File(f.getName());
            deleteFile(file);
        }
    }

    public static void reloadFiles() {
        Pair<Boolean, ArrayList<Files>> pair = isEveryThing();
        if (pair.getKey() == false) {
            Logs.log(Logs.WARNING, ConsoleColors.RED + "Missing server files!" + ConsoleColors.RESET);
            try {
                setup(pair.getValue());

            } catch (IOException e) {
                e.printStackTrace();
            }



        } else {
            Logs.log(Logs.INFORMATION, "No missing server files!");
        }
        try {
            setupFiles(pair.getValue());
        } catch (NullPointerException ex){
           Logs.log(Logs.WARNING, "Cloud is restarting!");
           Cloud.filled.add(Files.COUD_PROPS);

        }
    }

    public static void setupFiles(Files... files){
        if (Arrays.asList(files).contains(Files.COUD_PROPS)) {

            Cloud.CloudProps.reinit(new File(Files.COUD_PROPS.getName()));
            Cloud.CloudProps.reload();
            Cloud.CloudProps.resetup();
        }
    }
    public static void setupFiles(ArrayList<Files> files){

        if (files.contains(Files.COUD_PROPS)) {

            Cloud.CloudProps.reinit(new File(Files.COUD_PROPS.getName()));
            Cloud.CloudProps.reload();
            Cloud.CloudProps.resetup();

        }
    }

    public static void deleteFile(File file) {

        if (file.exists()) {
            if (file.isDirectory()) {
                for (File f : file.listFiles()) {
                    if (f.isDirectory()) {
                        deleteFile(f);
                    } else {
                        f.delete();
                    }
                }
                file.delete();
            } else {
                file.delete();
            }
        }
    }


}
