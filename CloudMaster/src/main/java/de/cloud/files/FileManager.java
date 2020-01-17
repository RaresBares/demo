package de.cloud.files;

import de.cloud.files.fileutils.Files;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FileManager {


 public static void setup(Files... files){

     List<Files> f = Arrays.asList(files);
     if(f.contains(Files.ALL)){

     }else{
         for (Files rfileh : f) {
             File file = new File(rfileh.getName());
             if(file.exists())
         }
     }

 }

 private static void deleteFIles(Files... files){

 }

}
