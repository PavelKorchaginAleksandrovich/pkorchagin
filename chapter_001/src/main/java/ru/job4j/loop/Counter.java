package ru.job4j.loop;
/**
 *@class Loop задача 4.1.
 *@author Pavel Korchagin.
 *@since 15.12.2017.
 *@version 1.0.
 */
public class Counter {

    /**
     * Расчет суммы четных чисел,
     * чтобы уменьшить количество циклов, сразу приводим первое число
     * к четному, затем вцикле увеличиваем на 2.
     * @param first
     * @param second
     * @return Сумма четных чисел между параметрами
     */
    public int add(int first, int second) {
        int result = 0;
        if (first % 2 != 0) {
           first++;
        }
        while (first <= second) {
            result = result + first;
            first = first + 2;
        }
        return result;
    }

}
