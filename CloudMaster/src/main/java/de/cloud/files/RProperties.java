package de.cloud.files;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.io.*;
import java.util.Properties;

@Getter
@Setter
public class RProperties {

    public File PropFile;
    private Properties properties;

    public RProperties(File f) {
        setPropFile(f);
        this.properties = new Properties();
        try {
            getProperties().load(new FileInputStream(f));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public int getInt(String key) {
        return Integer.parseInt(properties.getProperty(key));

    }

    public boolean getBoolean(String key) {
        return Boolean.parseBoolean(properties.getProperty(key));

    }

    public byte getByte(String key) {
        return (byte) Integer.parseInt(properties.getProperty(key));

    }

    public short getShort(String key) {
        return (short) Integer.parseInt(properties.getProperty(key));

    }

    public String getString(String key) {
        return String.valueOf(Integer.parseInt(properties.getProperty(key)));

    }

    public RProperties setInt(String key, int value) {
        getProperties().setProperty(key, String.valueOf(value));
        return this;
    }

    public RProperties setBoolean(String key, boolean value) {
        getProperties().setProperty(key, String.valueOf(value));
        return this;
    }

    public RProperties setByte(String key, byte value) {
        getProperties().setProperty(key, String.valueOf(value));
        return this;
    }

    public RProperties setShort(String key, short value) {
        getProperties().setProperty(key, String.valueOf(value));
        return this;
    }

    public RProperties setString(String key, String value) {
        getProperties().setProperty(key, value);
        return this;
    }

    public RProperties save(){
        try {
            getProperties().save(new FileOutputStream(getPropFile()), "");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return this;
    }
    public RProperties reinit(File f){
        setPropFile(f);
        return this;
    }

    public RProperties reload(){
        try {
            getProperties().load(new FileInputStream(getPropFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }
    protected void finalize()
    {
       save();
       
    }

    public RProperties resetup() {
        return this;
    }

}
