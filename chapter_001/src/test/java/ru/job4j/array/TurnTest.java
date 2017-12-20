package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test Turn
 * @author Pavel Kortchagin
 * @version 1.0
 * @since 20.12.2017
 */
public class TurnTest {
    Turn array = new Turn();

    /**
     * Тест массива с нечетным количеством элементов.
     */
    @Test
    public void whenOddArryayThenTurnArray() {
        int[] oddArray = {23, 2, 73, 122, 53, 1, 87};
        int[] expected = {87, 1, 53, 122, 73, 2, 23};
        int[] result = array.back(oddArray);
        assertThat(result, is(expected));
    }

    /**
     *  Тест массива с четным количеством элементов.
     */
    @Test
    public void whenEvenArryayThenTurnArray() {
        int[] oddArray = {23, 2, 73, 45, 53, 1, 87, 53};
        int[] expected = {53, 87, 1, 53, 45, 73, 2, 23};
        int[] result = array.back(oddArray);
        assertThat(result, is(expected));
    }
}

