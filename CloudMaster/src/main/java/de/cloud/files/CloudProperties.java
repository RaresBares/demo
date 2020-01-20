package de.cloud.files;

import de.cloud.Logs;

import java.io.File;

public class CloudProperties extends RProperties {
    public CloudProperties(File f) {
        super(f);
    }


    @Override
    public RProperties resetup() {
        setInt("cloud-port", 27777);
        save();
        Logs.log(Logs.INFORMATION, "Reset of cloud.properties");
        return this;
    }
}
