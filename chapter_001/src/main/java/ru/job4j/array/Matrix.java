package ru.job4j.array;
/**
 *@class Matrix задача 5.4.
 *@author Pavel Korchagin.
 *@since 21.12.2017.
 *@version 1.0.
 */

public class Matrix {
    /**
     * Расчет таблицы умножения для числа.
     * @param size
     * @return
     */
    int[][] multiple(int size) {
        int[][] result = new int[size][size];
        for (int count = 1; count <= size; count++) {
            for (int countInner = 1; countInner <= size; countInner++) {
                result[count - 1][countInner - 1] = count * countInner;
            }
        }
        return result;
    }

}
