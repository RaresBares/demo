package de.cloud.files.fileutils;

import lombok.Getter;

@Getter
public enum Files {

    WRAPPER("./wrapper"),COUD_PROPS("./cloud.properties"),WRAPPER_TEMPLATES("./wrapper/templates"),WRAPPER_SERVER("./wrapper/server"), ALL("*");

     private String name;
    Files(String name){
        this.name = name;
    };

}
