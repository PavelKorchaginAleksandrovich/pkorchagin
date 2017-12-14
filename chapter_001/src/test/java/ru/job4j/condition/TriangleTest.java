package ru.job4j.condition;

import static org.hamcrest.number.IsCloseTo.closeTo;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Triangle.
 * @author Pavel Kortchagin
 * @version 1.0
 * @since 14.12.2017
 */
public class TriangleTest {

    @Test
    public void whenThreePointsThenTriangleArea() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(2, 0);
        Triangle triangle = new Triangle(a, b, c);

        double result = triangle.area();
        assertThat(result, is(closeTo(2.0, 0.0001)));
    }
}
