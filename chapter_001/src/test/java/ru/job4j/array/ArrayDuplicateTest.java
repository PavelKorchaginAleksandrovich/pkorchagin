package ru.job4j.array;


import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {

    @Test
    public void whenThen() {
        ArrayDuplicate arrayduplicate = new ArrayDuplicate();
        String[] string = {"Привет", "Мир", "Вода", "Порошок", "Вода", "Мир", "Мир", "Привет"};
        String[] expected = {"Привет", "Мир", "Вода", "Порошок"};
        String[] result = arrayduplicate.remove(string);
        assertArrayEquals(expected, result);

    }
}
