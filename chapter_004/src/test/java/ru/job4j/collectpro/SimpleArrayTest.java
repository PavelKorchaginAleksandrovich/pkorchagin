package ru.job4j.collectpro;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class SimpleArrayTest {

    @Test
    public void whenAddElementThenGetThatElement() {
        SimpleArray<String> stringArr = new SimpleArray<>(1);
        stringArr.add("12");
        assertThat(stringArr.get(0), is("12"));
    }

    @Test
    public void whenSetThenReplaceElement() {
        SimpleArray<Integer> stringArr = new SimpleArray<>(3);
        stringArr.set(1, 12);
        assertThat(stringArr.get(1), is(12));
    }

    @Test
   public void deleteThenRemoveElement() {
        SimpleArray<Integer> stringArr = new SimpleArray<>(3);
        stringArr.add(13);
        stringArr.add(14);
        stringArr.add(15);
        stringArr.delete(1);
        assertThat(stringArr.get(0), is(13));
        assertThat(stringArr.get(1), is(15));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenArrayHasNullElements() {
        SimpleArray<Integer> stringArr = new SimpleArray<>(7);
        stringArr.add(13);
        stringArr.add(14);
        stringArr.set(4, 15);
        Iterator it = stringArr.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(13));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(14));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(15));
        assertThat(it.hasNext(), is(false));
        it.next();
    }
}