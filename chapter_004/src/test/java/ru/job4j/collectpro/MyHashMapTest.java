package ru.job4j.collectpro;

import static org.hamcrest.Matchers.is;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class MyHashMapTest {

    @Test
    public void insert() {
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
        assertThat(myHashMap.insert(10, "Test"), Is.is(true));
        assertThat(myHashMap.insert(20, "Test2"), Is.is(false));
        assertThat(myHashMap.insert(5, "Test3"), Is.is(true));
    }

    @Test
    public void get() {
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
        myHashMap.insert(10, "Test");
        myHashMap.insert(5, "Test3");
        assertThat(myHashMap.get(20), Is.is((String) null));
        assertThat(myHashMap.get(10), Is.is("Test"));
        assertThat(myHashMap.get(5), Is.is("Test3"));

    }

    @Test
    public void delete() {
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
        myHashMap.insert(10, "Test");
        myHashMap.insert(5, "Test3");
        myHashMap.insert(3, "Test4");
        assertThat(myHashMap.delete(20), Is.is(false));
        assertThat(myHashMap.get(5), Is.is("Test3"));
        assertThat(myHashMap.delete(5), Is.is(true));
        assertThat(myHashMap.delete(5), Is.is(false));
        assertThat(myHashMap.get(5), Is.is((String) null));

    }

    @Test
    public void increase() {
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
        assertThat(myHashMap.getSize(), Is.is(10));
        assertThat(myHashMap.insert(9, "Test9"), Is.is(true));
        assertThat(myHashMap.insert(19, "Test19"), Is.is(false));
        assertThat(myHashMap.insert(1, "Test1"), Is.is(true));
        assertThat(myHashMap.insert(2, "Test2"), Is.is(true));
        assertThat(myHashMap.insert(3, "Test3"), Is.is(true));
        assertThat(myHashMap.insert(4, "Test4"), Is.is(true));
        assertThat(myHashMap.insert(5, "Test5"), Is.is(true));
        assertThat(myHashMap.insert(6, "Test6"), Is.is(true));
        assertThat(myHashMap.insert(19, "Test19"), Is.is(true));
        assertThat(myHashMap.getSize(), Is.is(20));
        assertThat(myHashMap.get(1), Is.is("Test1"));
        assertThat(myHashMap.get(2), Is.is("Test2"));
        assertThat(myHashMap.get(3), Is.is("Test3"));
        assertThat(myHashMap.get(4), Is.is("Test4"));
        assertThat(myHashMap.get(5), Is.is("Test5"));
        assertThat(myHashMap.get(6), Is.is("Test6"));
        assertThat(myHashMap.get(9), Is.is("Test9"));
        assertThat(myHashMap.get(19), Is.is("Test19"));
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator() {
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
        assertThat(myHashMap.insert(1, "Test1"), Is.is(true));
        assertThat(myHashMap.insert(2, "Test2"), Is.is(true));
        assertThat(myHashMap.insert(3, "Test3"), Is.is(true));
        assertThat(myHashMap.insert(4, "Test4"), Is.is(true));
        Iterator itr = myHashMap.iterator();
        assertThat(itr.hasNext(), Is.is(true));
        assertThat(itr.next(), Is.is((String) null));
        assertThat(itr.hasNext(), Is.is(true));
        assertThat(itr.next(), Is.is("Test1"));
        assertThat(itr.hasNext(), Is.is(true));
        assertThat(itr.next(), Is.is("Test2"));
        assertThat(itr.hasNext(), Is.is(true));
        assertThat(itr.next(), Is.is("Test3"));
        assertThat(itr.hasNext(), Is.is(true));
        assertThat(itr.next(), Is.is("Test4"));
        assertThat(itr.hasNext(), Is.is(true));
        assertThat(itr.next(), Is.is((String) null));
        assertThat(itr.hasNext(), Is.is(true));
        assertThat(itr.next(), Is.is((String) null));
        assertThat(itr.hasNext(), Is.is(true));
        assertThat(itr.next(), Is.is((String) null));
        assertThat(itr.hasNext(), Is.is(true));
        assertThat(itr.next(), Is.is((String) null));
        assertThat(itr.hasNext(), Is.is(true));
        assertThat(itr.next(), Is.is((String) null));
        assertThat(itr.hasNext(), Is.is(false));
        itr.next();
    }
}