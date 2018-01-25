package ru.job4j.extra;


import java.util.Arrays;

public class Change {

    int[] change = {1, 2, 5, 10};
    int index = 3;
    int[] result;
    int count = 0;
    public int[] changes(int value, int price) {
        int total = value - price;
        this.result = new int[total];
        while (total != 0) {
           int numbers = total / change[index];
            total -= change[index] * numbers;
            addChanges(index--, numbers);
        }

        return Arrays.copyOf(result, count);
    }
    public void  addChanges(int index, int numbers) {
        for (int i = 0; i != numbers; i++) {
            this.result[this.count++] = change[index];
        }
    }
}
