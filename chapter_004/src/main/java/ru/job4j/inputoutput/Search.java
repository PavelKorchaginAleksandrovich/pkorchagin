package ru.job4j.inputoutput;

import java.io.*;
import java.util.*;

public class Search {
    private FileFilter filterDir = File::isDirectory;
    private List<File> result = new ArrayList<>();


    public List<File> files(String parent, List<String> exts) {

        String path = new File(parent).getAbsolutePath();
        File file = new File(path);
        search(file, exts);
        return result;
    }
    private void search(File parent, List<String> exts) {
        File[] dirs = parent.listFiles(filterDir);
        for (String ext : exts) {
           File[] matches =  parent.listFiles((File dir, String name) -> name.toLowerCase().endsWith("." + ext));
            result.addAll(Arrays.asList(matches));
        }
        for (File dir : dirs) {
            search(dir, exts);
        }
    }

    public static void main(String[] args) {
     String s = System.getProperty("java.io.tmpdir");
        System.out.println(s);

    }

}
