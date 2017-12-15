package ru.job4j.loop;

import static org.hamcrest.core.Is.is;
import org.junit.Test;
import static org.junit.Assert.assertThat;

/**
 * Test Counter.
 * @author Pavel Kortchagin
 * @version 1.0
 * @since 15.12.2017
 */
public class CounterTest {
    /**
     * Test counter
     */
    @Test
    public void whenFirstSecondThenSumm() {

        Counter count = new Counter();
        int result = count.add(10, 21);
        assertThat(result, is(90));
    }
}
