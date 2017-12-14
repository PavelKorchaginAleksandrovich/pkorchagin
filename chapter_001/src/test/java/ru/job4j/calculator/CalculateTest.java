package ru.job4j.calculator;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Test.
 *
 * @author Pavel Kortchagin
 * @version 1.0
 * @since 14.12.2017
 */
public class CalculateTest {


    double first = 30, second = 6;
    ru.job4j.calculator.Calculate calc = new Calculate();
    /**
     * Test простой калькулятор.
     */
    @Test
    public void whenAddThenOnePlusTwo() {
        double expect = 36;
        calc.add(first, second);
        Double result = calc.getResult();
        assertThat(result, is(expect));
    }
    public void whenSubtractThenOneMinusTwo() {
        double expect = 24;
        calc.subtract(first, second);
        Double result = calc.getResult();
        assertThat(result, is(expect));
    }
    public void whenMultipleThenOneMultiplyTwo() {
        double expect = 180;
        calc.multiple(first, second);
        Double result = calc.getResult();
        assertThat(result, is(expect));
    }
    public void whenDivThenOneDivideTwo() {
        double expect = 5;
        calc.div(first, second);
        Double result = calc.getResult();
        assertThat(result, is(expect));
    }
}