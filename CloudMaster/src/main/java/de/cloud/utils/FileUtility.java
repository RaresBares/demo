package de.cloud.utils;

import java.io.File;

public enum  FileUtility {

    MASTER,
    WRAPPER;

    static File active;

    public static void setupBasicFiles(FileUtility type) throws Exception {
        switch (type) {

            case MASTER:
                File wrapperSettings = new File("./settings");
                active = new File("./active");
                wrapperSettings.mkdirs();
                active.mkdirs();
            break;

            case WRAPPER:
                File masterSettings = new File("./settings");
                File groups = new File("./groups");
                File templates = new File("./templates");
                masterSettings.mkdirs();
                templates.mkdirs();
                groups.mkdirs();
                break;
        }
    }

    public static void deleteActiveDirectory() {
        //TODO: STOP ALL INSTANCES
        active.delete();
    }
}
