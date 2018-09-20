package ru.job4j.collectpro;

import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class MyLinkedListTest {


    @Test
    public void whenAddElementThenTheyHaveIndexZero() {
        MyLinkedList<String> myList = new MyLinkedList<>();
        myList.add("first");
        myList.add("second");
        myList.add("third");
        assertThat(myList.get(0), is("third"));
        myList.add("fourth");
        assertThat(myList.get(0), is("fourth"));
    }


    @Test(expected = NoSuchElementException.class)
    public void whenHasNextIsFalseThenExeption() {
        MyLinkedList<String> myList = new MyLinkedList<>();
        myList.add("first");
        Iterator itr = myList.iterator();
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is("first"));
        assertThat(itr.hasNext(), is(false));
        itr.next();
    }
    @Test(expected = ConcurrentModificationException.class)
    public void whenArryChangedThenTrowExeption() {
        MyLinkedList<String> myList = new MyLinkedList<>();
        myList.add("first");
        Iterator itr = myList.iterator();
        myList.add("second");
        itr.next();
    }

}