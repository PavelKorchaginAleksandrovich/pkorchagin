package ru.job4j.collectpro;

import java.util.Iterator;

public class DynamicSet<T> implements  Iterable {

    private DynamicArray<T> dynSet;
    public DynamicSet() {
        this.dynSet = new DynamicArray<>();
    }

    public void add(T value) {
        boolean hasDuplicate = false;
        for (int i = 0; i < dynSet.getPosition(); i++) {
            if (dynSet.get(i).equals(value)) {
                hasDuplicate = true;
                break;
            }
        }
        if (!hasDuplicate) {
            dynSet.add(value);
        }
    }
    public T get(int index) {
        return this.dynSet.get(index);
    }

    public int getsize() {
        return this.dynSet.getsize();
    }
    @Override
    public Iterator iterator() {
        return dynSet.iterator();
    }
}
