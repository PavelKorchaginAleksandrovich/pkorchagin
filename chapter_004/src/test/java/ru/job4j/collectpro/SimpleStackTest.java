package ru.job4j.collectpro;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleStackTest {

    @Test
    public void poll() {
    }

    @Test
    public void push() {
        SimpleStack<String> stack = new SimpleStack<>();
        stack.push("first");
        stack.push("second");
        stack.push("third");
        assertThat(stack.poll(), is("third"));
        assertThat(stack.poll(), is("second"));
        assertThat(stack.poll(), is("first"));
    }
}