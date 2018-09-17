package ru.job4j.collectpro;

import static org.hamcrest.core.Is.is;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.junit.Assert.*;

public class DynamicArrayTest {

    @Test
    public void whenAddMore10ElementsThenNewLengthAndGetLastElement() {
        DynamicArray<String> myArray = new DynamicArray<>();
        myArray.add("1");
        myArray.add("2");
        myArray.add("3");
        myArray.add("4");
        myArray.add("5");
        myArray.add("6");
        myArray.add("7");
        myArray.add("8");
        myArray.add("9");
        myArray.add("10");
        myArray.add("11");
        assertThat(myArray.getsize(), is(20));
        assertThat(myArray.get(10), is("11"));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenChangeArrayThenExeption() {
        DynamicArray<String> myArray = new DynamicArray<>();
        myArray.add("1");
        myArray.add("2");
        myArray.add("3");
        myArray.add("4");
        myArray.add("5");
        myArray.add("6");
        myArray.add("7");
        Iterator itr = myArray.iterator();
        itr.next();
        itr.next();
        itr.next();
        itr.next();
        itr.next();
        itr.next();
        assertThat(itr.next(), is("7"));
        myArray.add("8");
        itr.next();
    }
}