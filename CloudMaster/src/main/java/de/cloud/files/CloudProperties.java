package de.cloud.files;

import java.io.File;

public class CloudProperties extends RProperties {
    public CloudProperties(File f) {
        super(f);
    }


    @Override
    public RProperties resetup() {
        setInt("cloud-port", 27777);
        return this;
    }
}
