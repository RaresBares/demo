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

    public RProperties(File f) throws Exception {
        setPropFile(f);
        this.properties = new Properties();
        getProperties().load(new FileInputStream(f));


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
        Boolean.parseBoolean(properties.getProperty(key, String.valueOf(value)));
    }

    public void setByte(String key, byte value) {
        Integer.parseInt(properties.getProperty(key, String.valueOf(value)));
    }

    public void setShort(String key, short value) {
        Integer.parseInt(properties.getProperty(key, String.valueOf(value)));
    }

    public void setString(String key, String value) {
        String.valueOf(Integer.parseInt(properties.getProperty(key, value)));
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
