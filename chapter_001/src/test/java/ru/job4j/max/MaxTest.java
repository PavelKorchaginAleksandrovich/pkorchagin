package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test MAX.
 * @author Pavel Kortchagin
 * @version 1.0
 * @since 14.12.2017
 */

public class MaxTest {
    @Test
    public void whenTwoNumbersThenMaxOfTwoNumbers() {
        Max max = new Max();
        int result = max.max(45, 46);
        assertThat(result, is(46));
    }
}
