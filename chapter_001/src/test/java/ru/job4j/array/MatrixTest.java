package ru.job4j.array;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;


/**
 * Test Matrix
 * @author Pavel Kortchagin
 * @version 1.0
 * @since 21.12.2017
 */

public class MatrixTest {
    @Test
    public void whenFourThenMultiplyMatrixFour() {
        Matrix matrix = new Matrix();
        int[][] result = matrix.multiple(4);
        int[][] expected = {{1, 2, 3, 4}, {2, 4, 6, 8}, {3, 6, 9, 12}, {4, 8, 12, 16}};
        assertThat(result, is(expected));
    }
}
