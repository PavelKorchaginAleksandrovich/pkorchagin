package ru.job4j.array;
import java.util.Arrays;

public class ArrayDuplicate {

    public String[] remove(String[] array) {
        int length = array.length - 1;
        int count = 0;
        String temp;
        boolean noMatch = false;
        while (count < length) {
            for (int countInner = count + 1; countInner <= length; countInner++) {
                if (array[count].equals(array[countInner])) {
                    temp = array[length];
                    array[length] = array[countInner];
                    array[countInner] = temp;
                    length--;
                    noMatch = false;
                    break;
                } else {
                    noMatch = true;
                }
            }
            if (noMatch) {
                count++;
            }
        }
        return Arrays.copyOf(array, length + 1);
    }
}
