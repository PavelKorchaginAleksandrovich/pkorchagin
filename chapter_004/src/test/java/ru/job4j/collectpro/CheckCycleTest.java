package ru.job4j.collectpro;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class CheckCycleTest {

    @Test
    public void whenHasCycleThenTrue() {
        SimpleNode<Integer> first = new SimpleNode(1);
        SimpleNode<Integer> two = new SimpleNode(2);
        SimpleNode<Integer> third = new SimpleNode(3);
        SimpleNode<Integer> four = new SimpleNode(4);

        first.next = two;
        two.next = third;
        third.next = two;
        four.next = first;
        assertThat(new CheckCycle().hasCycle(first), is(true));

    }
    @Test
    public void whenNoCycleThenFalse() {
        SimpleNode<Integer> first = new SimpleNode(1);
        SimpleNode<Integer> two = new SimpleNode(2);
        SimpleNode<Integer> third = new SimpleNode(3);
        SimpleNode<Integer> four = new SimpleNode(4);
        SimpleNode<Integer> five = new SimpleNode(5);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = five;
        assertThat(new CheckCycle().hasCycle(first), is(false));

    }
}