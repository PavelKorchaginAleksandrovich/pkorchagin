package ru.job4j.collectpro;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {
    private Node<T> first;
    private int size;
    private int modcount;

    public void add(T date) {
        Node<T> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
        this.modcount++;
    }

    public T get(int index) {
        Node<T> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }
    public T delete() {
        Node<T> delItem = this.first;
        this.first = this.first.next;
        this.size--;
        this.modcount--;
        return delItem.date;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {
        private int expectedModCount = modcount;
        Node<T> current = first;
        int cursor;
        @Override
        public boolean hasNext() {
            return this.cursor < size;
        }

        @Override
        public T next() {
            checkForComodification();
            T result;

            if (this.current != null) {
                result = current.date;
                this.current = this.current.next;
                this.cursor++;
            } else {
                throw new NoSuchElementException();
            }
            return result;
        }
        final void checkForComodification() throws ConcurrentModificationException {
            if (modcount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }
        private static class Node<T> {
            T date;
            Node<T> next;
            Node(T date) {
                this.date = date;
            }
    }

}