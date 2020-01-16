package de.cloud;

import de.cloud.utilities.ConsoleColors;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public enum Logs {

    INFORMATION("Info"),
    WARNING(ConsoleColors.YELLOW + "Warning" + ConsoleColors.RESET),
    ERROR(ConsoleColors.RED_BOLD + "Info"+ ConsoleColors.RESET),
    NOTHING("");
    private String name;

    Logs(String name){
        this.name = name();
    }

    public static void log(Logs logs, String s){
        Date d = new Date();
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        String date = df.format(d);
        System.out.println("[" + date + " | Master] |-" + logs.name + "-| » "  + s);
    }

}
