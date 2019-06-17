package ru.job4j.inputoutput;

import java.io.*;

public class Analizy {
    private final String[] stopString = {"500", "400"};
    private final String[] startString = {"200", "300"};

    public void unavailable(String source, String target) {
        String line;
        String beginTime = "";
        int serverStatus = 1;
        try {
            BufferedReader read = new BufferedReader(new FileReader(source));
            PrintWriter out = new PrintWriter(new FileOutputStream(target));
            while ((line = read.readLine()) != null) {
                switch (serverStatus) {
                    case 1:
                        for (String stop : stopString) {
                            if (line.startsWith(stop)) {
                                beginTime = line.substring(3).trim();
                                serverStatus = 0;
                                break;
                            }
                        }
                        break;
                    case 0:
                        for (String start : startString) {
                            if (line.startsWith(start)) {
                                out.println(beginTime + " " + line.substring(3).trim());
                                System.out.println();
                                serverStatus = 1;
                                break;
                            }
                        }
                        break;
                    default:
                        break;
                }
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}



