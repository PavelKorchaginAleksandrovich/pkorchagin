package ru.job4j;


import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

/**
 * Test ChekString
 * @author Pavel Kortchagin
 * @version 1.0
 * @since 23.12.2017
 */

public class ChekStringTest {
    ChekString chek = new ChekString();
    String string = "Паралеллипипед";

    @Test
    public void whenHasMatch() {
        String sub = "лип";
        boolean result = chek.contains(string, sub);
        assertThat(result, is(true));
    }

    @Test
    public void whenHasNoMatch() {
        String sub = "лид";
        boolean result = chek.contains(string, sub);
        assertThat(result, is(false));
    }


}
