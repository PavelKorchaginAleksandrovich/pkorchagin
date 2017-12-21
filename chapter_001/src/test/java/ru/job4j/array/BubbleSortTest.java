package ru.job4j.array;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;


public class BubbleSortTest {
    /**
     * Test BubbleSort
     * @author Pavel Kortchagin
     * @version 1.0
     * @since 21.12.2017
     */
    @Test
    public void whenArrayThenSortArray() {
        BubbleSort bubble = new BubbleSort();
        int[] array = {43, 54, 432, 21, 21, 32, 5, 72, 100};
        int[] result = bubble.sort(array);
        int[] expected = {5, 21, 21, 32, 43, 54, 72, 100, 432};
        assertThat(result, is(expected));
    }

}
