package ru.job4j.collectpro;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleQueueTest {

    @Test
    public void poll() {
    }

    @Test
    public void push() {
        SimpleQueue<String> queue = new SimpleQueue<>();
        queue.push("first");
        queue.push("second");
        queue.push("third");
        assertThat(queue.poll(), is("first"));
        assertThat(queue.poll(), is("second"));
        assertThat(queue.poll(), is("third"));
    }
}