package ru.job4j.collectpro;


import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicArray<T> implements Iterable {
    private Object[] container;
    private int modcount = 0;
    private int position = 0;

    public DynamicArray() {
        container = new Object[10];
    }
    public int getPosition() {
        return this.position;
    }

    public void add(T value) {
        if (this.position < this.container.length) {
            this.container[position++] = value;
        } else {
            this.container = Arrays.copyOf(this.container, this.container.length * 2);
            this.container[position++] = value;
        }
        modcount++;
    }

    public T get(int index) {
        return (T) this.container[index];
    }

    public int getsize() {
        return this.container.length;
    }


    public Iterator iterator() {
        return new Itr();
    }



    private class Itr<T> implements Iterator<T> {
        int cursor = 0;
        int expectedModCount = modcount;

        @Override
        public boolean hasNext() {
            return cursor != container.length;
        }

        @Override
        public T next() {
            checkForComodification();
            if (cursor >= container.length) {
                throw new NoSuchElementException();
            }
            return (T) container[cursor++];

        }

        final void checkForComodification() {
            if (modcount != expectedModCount) {
                throw new ConcurrentModificationException();
            }

        }
    }

}