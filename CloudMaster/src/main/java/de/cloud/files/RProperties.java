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

    public void setInt(String key, int value) {
        getProperties().setProperty(key, String.valueOf(value));
    }

    public void setBoolean(String key, boolean value) {
        getProperties().setProperty(key, String.valueOf(value));
    }

    public void setByte(String key, byte value) {
        getProperties().setProperty(key, String.valueOf(value));
    }

    public void setShort(String key, short value) {
        getProperties().setProperty(key, String.valueOf(value));
    }

    public void setString(String key, String value) {
        getProperties().setProperty(key, value);
    }

    public void save(){
        try {
            getProperties().save(new FileOutputStream(getPropFile()), "");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void reload(){
        try {
            getProperties().load(new FileInputStream(getPropFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void finalize()
    {
       save();
    }

}
