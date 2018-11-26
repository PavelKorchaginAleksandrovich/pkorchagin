package ru.job4j.collectpro;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyHashMap<K, V> implements Iterable {

    private Object[] container;
    private int size = 10;
    private int count = 0;

    public int getSize() {
        return this.size;
    }

    public MyHashMap() {
        container = new Object[size];
    }

    boolean insert(K key, V value) {
        boolean result = false;
        int position = Math.abs(key.hashCode()) % size;
        if (container[position] == null) {
            Element element = new Element(key, value);
            container[position] = element;
            result = true;
            count++;
        }
        // увеличим размер массива когда он будет заполнен наполовину
        if (count > size / 2) {
            increase();
        }
        return result;
    }

    V get(K key) {
        Element elem = (Element) container[key.hashCode() % size];

        return elem == null ? null : (elem.getKey().equals(key) ? elem.getValue() : null);
    }

    boolean delete(K key) {
        boolean result = false;
        int pos = key.hashCode() % size;
        Element elem = (Element) container[pos];
        if (elem != null && elem.getKey().equals(key)) {
            container[pos] = null;
            result = true;
        }
        return result;
    }


    void increase() {
        size *= 2;
        Object[] newContainer = new Object[size];
        for (Object elem : container) {
            if (elem != null) {
                Element el = (Element) elem;
                K key = el.getKey();
                newContainer[key.hashCode() % size] = elem;
            }
        }
        container = newContainer;
    }


    //класс для хранения данных,
    private class Element {
        private K key;
        private V value;

        Element(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public Iterator iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<V> {
        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public V next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Element elem = (Element) container[cursor++];
            return elem != null ? elem.getValue() : null;


        }
    }
}
