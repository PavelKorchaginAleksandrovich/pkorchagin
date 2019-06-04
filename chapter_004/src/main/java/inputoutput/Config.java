package inputoutput;

import java.util.*;
import java.io.*;
public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        String line;
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            while ((line = read.readLine()) != null) {
                String[] str  = line.split("##")[0].split("=");
                if (str.length == 2) {
                    values.put(str[0].trim(), str[1].trim());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String value(String key) {
        String result = values.get(key);
        if (result != null) {
            return result;
        }
        throw new UnsupportedOperationException("Don't impl this method yet!");
    }
    public static void main(String[] args) {
        Config config = new Config("app.properties");
        config.load();
    }
}