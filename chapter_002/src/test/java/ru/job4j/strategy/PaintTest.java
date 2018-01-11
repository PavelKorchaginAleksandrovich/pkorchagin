package ru.job4j.strategy;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import ru.job4j.models.Item;

import static org.hamcrest.core.Is.is;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertArrayEquals;

public class PaintTest {
    @Test
    public void whenDrawSquare() {
        String squareString = new StringBuilder().append("+++++\n").
                                                  append("+   +\n").
                                                  append("+   +\n").
                                                  append("+++++").
                                                  append(System.lineSeparator()).toString();
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Square());
        assertThat(new String(out.toByteArray()), is(squareString));
    }

    @Test
    public void whenDrawTriangle() {
        String squareString = new StringBuilder().append("   +   \n").
                                                  append("  +++  \n").
                                                  append(" +++++ \n").
                                                  append("+++++++").
                                                  append(System.lineSeparator()).toString();
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Triangle());
        assertThat(new String(out.toByteArray()), is(squareString));
    }

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
