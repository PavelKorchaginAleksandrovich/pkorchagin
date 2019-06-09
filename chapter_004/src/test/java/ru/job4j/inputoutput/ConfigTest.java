package ru.job4j.inputoutput;

import org.junit.Test;
import  org.junit.jupiter.api.*;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

import static org.junit.jupiter.api.Assertions.*;

public class ConfigTest {

    @Test
    public void whenValueExist() {
//        Config config = new Config("app.properties");
//        config.load();
//        assertThat(config.value("hibernate.connection.driver_class"), is("org.postgresql.Driver"));
//        assertThat(config.value("hibernate.connection.username"), is("postgres"));
        File file = new File("test.txt");
        System.out.println(file.getAbsolutePath());
    }

    @Test
    public void whenValueNotExist() {
        Config config = new Config("app.properties");
        String exeptionMessage = "Don't impl this method yet!";
        config.load();
        Throwable exception = assertThrows(UnsupportedOperationException.class, () -> config.value("нет такого ключа"));
        assertEquals(exeptionMessage, exception.getMessage());
    }

}