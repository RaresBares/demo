package de.cloud.files;

import lombok.Getter;


public enum Files {

    @Getter private String name;
    Files(String name){
        this.getName = name;
    };

}
