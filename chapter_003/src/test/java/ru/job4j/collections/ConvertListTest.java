package ru.job4j.collections;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;
import java.util.*;
public class ConvertListTest {

    @Test
    public void whenToList() {
        int[][] array = {{1, 4}, {23, 83, 5}, {3, 2}, {21}};
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 4, 23, 83, 5, 3, 2, 21));
        List<Integer> result = new ConvertList().toList(array);
        assertThat(result, is(expected));
    }

    @Test
    public void whenToArray() {
        List<Integer> list = new ArrayList<>(Arrays.asList(9, 4, 5, 32, 5, 3, 2, 29));
        int[][] expected = {{9, 4, 5}, {32, 5, 3}, {2, 29, 0}};
        int[][] result = new ConvertList().toArray(list, 3);
        assertThat(result, is(expected));

    }
    @Test
    public void whenConvert() {

        List<int[]> list = new ArrayList<>();
        list.add(new int[] {23, 89, 72});
        list.add(new int[] {32, 22});
        list.add(new int[] {3, 7, 98, 100});
        List<Integer> expected = new ArrayList<>(Arrays.asList(23, 89, 72, 32, 22, 3, 7, 98, 100));
        List<Integer> result = new ConvertList().convert(list);
        assertThat(result, is(expected));
    }
}
