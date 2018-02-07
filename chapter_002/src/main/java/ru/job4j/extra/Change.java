package ru.job4j.extra;


import java.util.Arrays;

public class Change {
    private final static int[] CHANGE = {1, 2, 5, 10};

    public int[] changes(int value, int price) {
        int count = 0;
        int index = CHANGE.length - 1;
        int total = value - price;
        int[] result = new int[total];
        while (total != 0) {
           int numbers = total / CHANGE[index];
            total -= CHANGE[index] * numbers;
            for (int i = 0; i != numbers; i++) {
                result[count++] = CHANGE[index];
            }
            index--;
        }
        return Arrays.copyOf(result, count);
    }
}
