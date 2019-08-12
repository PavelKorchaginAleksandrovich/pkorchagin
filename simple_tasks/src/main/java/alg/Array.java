package alg;

import java.util.*;

public class Array<T extends Object & Comparable<? super T>> implements Iterable{
    private static final int CAPACITY = 10;
    private T[] container;
    private int modcount = 0;
    private int position = 0;

    public Array() {
        container = (T[]) new Object[CAPACITY];
    }
    public Array(int size) {
        container = (T[]) new Object[size];

    }
    public void delete(int pos) {
        System.arraycopy(this.container, pos + 1, this.container, pos, this.position - pos - 1);
        this.container[--position] = null;
    }
    public int search(T elem) {
        int result = -1;
        for (int i = 0; i < position; i++) {
            if (elem.equals(container[i])) {
                result = i;
                break;
            }
        }
        return result;
    }

    public T get(int index) {
        T result = null;
            if (index > 0 && index < position) {
                result = container[index];
            }
        return result;
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

    public Array<T> copy() {
       Array<T> result = new Array<>(this.position);
       System.arraycopy(this.container, 0, result.container, 0, this.position);
       result.position = this.position;
       result.modcount = this.modcount;
       return result;
    }

    public void sortBubble() {
        for (int i = this.position - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (container[j].compareTo(container[j + 1]) > 0) {
                    swap(j, j + 1);
                }
            }
        }
    }

    public void sortInsert() {
        for(int i = 1; i < position; i++) {
            T tmp = container[i];
            int in = i;
            while (in > 0 && container[in - 1].compareTo(tmp) >= 0) {
                container[in] = container[in-- - 1];
            }
            container[in] = tmp;
        }
    }
    public void sortSelect() {
        for (int i = 0; i < position -1; i++) {
            int min = i;
            for (int j = i + 1; j < position; j++) {
                if (container[j].compareTo(container[min]) < 0) {
                    min = j;
                }
            }
            swap(min, i);
        }
    }
    private void swap(int i, int j) {
        T tmp = container[i];
        container[i] = container[j];
        container[j] = tmp;
    }


    public int getsize() {
        return this.position;
    }


    public Iterator iterator() {
        return new Itr();
    }



    private class Itr<T> implements Iterator<T> {
        int cursor = 0;
        int expectedModCount = modcount;

        @Override
        public boolean hasNext() {
            return cursor != position;
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
