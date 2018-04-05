package ru.job4j.collectpro;

import java.util.*;

public class IteratorForEvenNum implements Iterator {
    private final int[] array;
    int positoin = 0;


    public IteratorForEvenNum(int[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;

        for (int pos = this.positoin; pos < this.array.length; pos++) {
            if (isEven(pos)) {
                result = true;
                break;
            }
        }
        return  result;
    }

    @Override
    public Object next() {
        Integer result;
        int pos = posEven();
        if (pos == -1) {
            throw new NoSuchElementException();
        } else {
            result = this.array[pos];
        }
        return result;
    }
    boolean isEven(int pos) {
        boolean result = false;
        if (this.array[pos] % 2 == 0) {
            result = true;
        }
        return result;
    }
    int posEven() {
        int result = -1;
        while (result == -1 && this.positoin != this.array.length) {
            if (isEven(this.positoin)) {
                result = this.positoin;
            }
            this.positoin++;
        }
        return  result;
    }
}
