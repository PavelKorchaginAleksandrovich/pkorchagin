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
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenDrawSquare() {
        String squareString = new StringBuilder().append("+++++\n").
                                                  append("+   +\n").
                                                  append("+   +\n").
                                                  append("+++++").
                                                  append(System.lineSeparator()).toString();
        this.loadOutput();
        new Paint().draw(new Square());
        assertThat(new String(this.out.toByteArray()), is(squareString));
        this.backOutput();
    }

    @Test
    public void whenDrawTriangle() {
        String squareString = new StringBuilder().append("   +   \n").
                                                  append("  +++  \n").
                                                  append(" +++++ \n").
                                                  append("+++++++").
                                                  append(System.lineSeparator()).toString();
        this.loadOutput();
        new Paint().draw(new Triangle());
        assertThat(new String(this.out.toByteArray()), is(squareString));
        this.backOutput();
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
