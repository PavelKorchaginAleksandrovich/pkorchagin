package ru.job4j.loop;

/**
 *@class Factorial задача 4.2.
 *@author Pavel Korchagin.
 *@since 17.12.2017.
 *@version 1.0.
 */

public class Factorial {

    /**
     * Вычислеие факториала положительного числа,
     * в случае отрицательного входящего параметра
     * возращаем 0, иначе будет ошибка.
     * @param n
     * @return факториал числа n
     */
    public int calc(int  n) {
        int factorial = 1;
        for (int count = 1; count <= n; count++) {
            factorial = count * factorial;
        }
        return factorial;
    }
}




