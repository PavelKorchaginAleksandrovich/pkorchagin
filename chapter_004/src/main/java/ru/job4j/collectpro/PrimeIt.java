package ru.job4j.collectpro;
import java.util.*;
import java.math.*;
public class PrimeIt implements Iterator  {
    private final int[] array;
    int positoin = 0;


    public PrimeIt(int[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;

        for (int pos = this.positoin; pos < this.array.length; pos++) {
            if (isPrime(pos)) {
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
    boolean isPrime(int pos) {
        boolean result = true;
        if (this.array[pos] != 2 && (this.array[pos] % 2 == 0 | this.array[pos] == 1)) {
            result = false;
        } else {
            for (int count = 3; count <= Math.sqrt(this.array[pos]); count += 2) {
                if (this.array[pos] % count == 0) {
                    result = false;
                    break;
                }
            }

        }

        return result;
    }
    int posEven() {
        int result = -1;
        while (result == -1 && this.positoin != this.array.length) {
            if (isPrime(this.positoin)) {
                result = this.positoin;
            }
            this.positoin++;
        }
        return  result;
    }
}
