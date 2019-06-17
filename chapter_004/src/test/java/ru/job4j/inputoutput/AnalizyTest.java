package ru.job4j.inputoutput;

import org.junit.Assert;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public  class AnalizyTest {

    @Test
    public void unavailable() {
        String line;
        Analizy analizy = new Analizy();
        analizy.unavailable("server.log", "unavailable.csv");
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> match = new ArrayList<>();
        match.add("10:58:01 10:59:01");
        match.add("11:01:02 11:10:02");
        try  {
            BufferedReader read = new BufferedReader(new FileReader("unavailable.csv"));
            while ((line = read.readLine()) != null) {
                result.add(line.trim());
                }
            read.close();
            } catch (Exception e) {
        e.printStackTrace();
        }
        assertThat(result, is(match));
    }
}