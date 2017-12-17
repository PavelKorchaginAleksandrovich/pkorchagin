package ru.job4j.loop;

import static org.hamcrest.core.Is.is;
import org.junit.Test;
import static org.junit.Assert.assertThat;

/**
 * Test Factorial.
 * @author Pavel Kortchagin
 * @version 1.0
 * @since 17.12.2017
 */

public class FactorialTest {
    Factorial factorial = new Factorial();
    int result;
    /**
     *Test Factorial.
     */

    @Test
    public void whenNumberThenFactorialOfNumber() {
        Factorial factorial = new Factorial();
        result = factorial.calc(6);
        assertThat(result, is(720));

    }
    /**
     *Test Factorial Zero.
     */
    @Test
    public void whenZeroThenOne() {

        result = factorial.calc(0);
        assertThat(result, is(1));
    }
}
