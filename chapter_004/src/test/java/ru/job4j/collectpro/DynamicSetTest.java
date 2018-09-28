package ru.job4j.collectpro;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DynamicSetTest {

    @Test
    public void whenAddContainsElementThenDoNotAdd() {
        DynamicSet<String> myArray = new DynamicSet<>();
        myArray.add("1");
        myArray.add("2");
        myArray.add("3");
        myArray.add("4");
        myArray.add("3");
        myArray.add("5");
        assertThat(myArray.get(0), is("1"));
        assertThat(myArray.get(1), is("2"));
        assertThat(myArray.get(2), is("3"));
        assertThat(myArray.get(3), is("4"));
        assertThat(myArray.get(4), is("5"));


    }
}