package ru.job4j.array;
/**
 *@class Turn задача 5.0.
 *@author Pavel Korchagin.
 *@since 20.12.2017.
 *@version 1.0.
 */

public class Turn {
    /**
     * Преобразование массива в обратном порядке
     * @param array
     * @return
     */
    public int[] back(int[] array) {
       int length = array.length;
       int halfLenght = length / 2;
       int temp, rightIndex;
       for (int leftIndex = 0; leftIndex != halfLenght; leftIndex++) {
           rightIndex = length - leftIndex - 1;
           temp = array[leftIndex];
           array[leftIndex] = array[rightIndex];
           array[rightIndex] = temp;
       }
       return array;
    }

}
