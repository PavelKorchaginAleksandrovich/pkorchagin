package ru.job4j.array;


import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;


/**
 * Test Findloop
 * @author Pavel Kortchagin
 * @version 1.0
 * @since 20.12.2017
 */
public class FindloopTest {
    int[] array = {2, 45, 63, 9, 100};
    Findloop loop = new Findloop();
    int result;

    @Test
    public void whenHasMatchThenMatch() {
    result = loop.indexOf(array, 45);
    assertThat(result, is(1));
    }

    @Test
    public void whenHasNoMatchThenMinusOne() {
        result = loop.indexOf(array, 34);
        assertThat(result, is(-1));
    }


}
