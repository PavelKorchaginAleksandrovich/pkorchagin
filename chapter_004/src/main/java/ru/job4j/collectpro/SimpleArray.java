package ru.job4j.collectpro;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private int position = 0;
    private Object[] array;

    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    public void add(T element) {
        this.array[position++] = element;
    }

    public void set(int pos, T element) {
        this.array[pos] = element;
    }

    public void delete(int pos) {
        System.arraycopy(this.array, pos + 1, this.array, pos, this.position - pos - 1);
        this.array[--position] = null;
    }

    public T get(int pos) {
        return (T) this.array[pos];
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr<T> implements Iterator<T> {
        int cursor = 0;

        private boolean notNull(int index) {
            return SimpleArray.this.array[index] != null;
        }
        /**
         * return возвращает истину, только в случае наличия элемента не равного null
         */
        @Override
        public boolean hasNext() {
            boolean result = false;
                for (int i = cursor; i < SimpleArray.this.array.length; i++) {
                    if (notNull(i)) {
                        result = true;
                        break;
                    }
                }
            return result;
        }
        /**
         * return возвращает следующий не null элемент
         */
        @Override
        public T next() {
            T result;
            int pos = nextPosNotNull();
            if (pos == -1) {
                throw new NoSuchElementException();
            } else {
                result = (T) SimpleArray.this.array[pos];
            }

            return result;
        }
        int nextPosNotNull() {
            int result = -1;
            while (result == -1 && this.cursor != SimpleArray.this.array.length) {
                if (notNull(this.cursor)) {
                    result = this.cursor;
                }
                this.cursor++;
            }
            return  result;
        }
    }
}
