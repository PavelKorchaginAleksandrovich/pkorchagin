package ru.job4j.strategy;

import org.junit.Test;
import ru.job4j.models.Item;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertArrayEquals;

public class PaintTest {
    @Test
    public void whenTringleThenPicTriangle() {
        String trangleString = new StringBuilder().append("   +   \n").
                                                   append("  +++  \n").
                                                   append(" +++++ \n").
                                                   append("+++++++").toString();
        Shape triangle = new Triangle();
        assertThat(triangle.draw(), is(trangleString));
    }
    @Test
    public void whenSquareThenPicSquare() {
        String squareString = new StringBuilder().append("+++++\n").
                                                  append("+   +\n").
                                                  append("+   +\n").
                                                  append("+++++").toString();
        Shape square = new Square();
        assertThat(square.draw(), is(squareString));
    }
}
