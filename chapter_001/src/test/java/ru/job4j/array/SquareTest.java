package ru.job4j.array;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;


/**
 * Test
 * @author Pavel Kortchagin
 * @version 1.0
 * @since 20.12.2017
 */
public class SquareTest {
    @Test
    public void ifThreeThenOneFourNine() {
        Square square = new Square();
        int[] result;
        int[] actuals = {1, 4, 9, 16};
        result = square.calculate(4);
        assertThat(result, is(actuals));
    }
}
