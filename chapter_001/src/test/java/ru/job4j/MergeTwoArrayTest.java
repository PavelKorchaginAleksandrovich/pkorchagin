package ru.job4j;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class MergeTwoArrayTest {
@Test
public void whenThen() {
    MergeTwoArray merger = new MergeTwoArray();
    int[] first = {23, 43, 52, 92, 123, 231};
    int[] second = {4, 5, 32, 46, 52, 76, 132, 231, 234, 255, 377};
    int[] result = merger.merge(first, second);
    int[] expected = {4, 5, 23, 32, 43, 46, 52, 52, 76, 92, 123, 132, 231, 231, 234, 255, 377};
    assertArrayEquals(expected, result);
}

}
