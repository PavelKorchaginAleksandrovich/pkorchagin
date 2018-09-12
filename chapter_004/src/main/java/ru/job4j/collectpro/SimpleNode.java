package ru.job4j.collectpro;

public class SimpleNode<T> {
    T value;
    SimpleNode<T> next;
    public SimpleNode(T date) {
        this.value = date;
    }
}
