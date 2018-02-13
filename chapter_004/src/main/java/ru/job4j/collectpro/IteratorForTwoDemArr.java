package ru.job4j.collectpro;

import java.util.Iterator;

public class IteratorForTwoDemArr implements Iterator {
    private final int[][] array;
    int positoinOut = 0;
    int positionIn = 0;

    public IteratorForTwoDemArr(int[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return positoinOut < (array.length - 1) ? true : positionIn < array[positoinOut].length;

    }

    @Override
    public Object next() {
        Integer result;
        if (positionIn < array[positoinOut].length) {
            result = this.array[positoinOut][positionIn++];
        } else {
            positionIn = 0;
            result = this.array[++positoinOut][positionIn++];
        }
        return result;
    }

}
