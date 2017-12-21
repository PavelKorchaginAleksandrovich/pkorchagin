package ru.job4j.array;
/**
 *@class BubbleSort задача 5.3.
 *@author Pavel Korchagin.
 *@since 21.12.2017.
 *@version 1.0.
 */

public class BubbleSort {
    /**
     * Сортировка массива пузырьком.
     * @param array
     * @return
     */
    public int[] sort(int[] array) {
        int temp;
        for (int count = array.length - 1; count >= 0; count--) {
            for (int countInner = 0; countInner != count; countInner++) {
                if (array[countInner] > array[countInner + 1]) {
                    temp = array[countInner];
                    array[countInner] = array[countInner + 1];
                    array[countInner + 1] = temp;
                }
            }
        }
        return array;
    }
}
