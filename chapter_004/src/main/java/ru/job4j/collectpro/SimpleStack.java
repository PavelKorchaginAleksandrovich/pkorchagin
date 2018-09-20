package ru.job4j.collectpro;

import java.util.Iterator;

public class SimpleStack<T> {
    private MyLinkedList<T> stack = new MyLinkedList<>();


    public T poll() {
        Iterator itr = stack.iterator();
        return stack.delete();
    }
    public void push(T value) {
        stack.add(value);
    }

}

