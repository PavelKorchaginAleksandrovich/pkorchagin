package ru.job4j.collectpro;

import java.util.Iterator;

public class DynamicSet<T> extends DynamicArraySet<T> {

    public DynamicSet() {
        super();
    }
//
    @Override
    public void add(T value) {
       int pos = duplicatePosition(value);
        if (pos == -1) {
           super.add(value);
        }
    }



    private int duplicatePosition(T value) {
        int result = -1;
        for (int i = 0; i < getPosition(); i++) {
            if (get(i).equals(value)) {
                result = i;
                break;
            }
        }
        return result;
    }
}
