package ru.job4j.max;

/**
 *@class MAX задача 3.2.
 *@author Pavel Korchagin.
 *@since 14.12.2017.
 *@version 1.0.
 */

public class Max {

    /**
     * вычисляет максимальное число.
     * @param first, second  числа пользователя.
     * @return максимальное число.
     */

    public int max(int first, int second) {
        return (first > second ? first : second);
    }

    /**
     * вычисляет максимальное число.
     * @param first, second, third числа пользователя.
     * @return максимальное число.
     */
    public int maxThree(int first, int second, int third) {
        int maxOfTwo = max(first, second);
        return max(maxOfTwo, third);
    }
}
