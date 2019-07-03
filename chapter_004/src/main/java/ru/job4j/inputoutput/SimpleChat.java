package ru.job4j.inputoutput;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class SimpleChat {

        Scanner in = new Scanner(System.in);
        String ask = "";


        public void chat() {
            String[] answers = getAnswers();
            boolean silence = false;

            while (!(ask = in.next()).equals("stop")) {
                if (ask.equals("pause") || ask.equals("continue")) {
                    silence = ask.equals("pause");
                    continue;
                }
                if (silence) {
                    continue;
                }
                System.out.println(answers[(int) Math.floor(Math.random() * answers.length)].trim());
            }
        }

        private String[] getAnswers() {
            try {
                Path path = Paths.get("gopnik.txt");
                return Files.readString(path).split(";");

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        }

}
