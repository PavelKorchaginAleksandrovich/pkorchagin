package ru.job4j.array;

/**
 *@class Square задача 5.0.
 *@author Pavel Korchagin.
 *@since 15.12.2017.
 *@version 1.0.
 */
public class Square {

    /**
     * Массив квадратов целых чисел.
     * P.S. нет проверки на параметр меньший 0
     * @param bound
     * @return
     */
    public int[] calculate(int bound) {

        int[] rst = new int[bound];

        for (int count = 1; count <= bound; count++) {
            rst[count - 1] = count * count;
        }
        return rst;
    }
}
