package ru.job4j;

/**
 *@class MergeTwoArray доп задание.
 *@author Pavel Korchagin.
 *@since 23.12.2017.
 *@version 1.0.
 */

public class MergeTwoArray {

    /**
     * Объединение 2-х сортированных массивов в один, так же сортированный.
     * @param first
     * @param second
     * @return
     */
    public int[] merge(int[] first, int[] second) {
        int length = first.length + second.length;
        int[] result = new int[length];
        int count = 0, countFirst = 0, countSecond = 0;
        // сравниваем пока не закончится один из массивов
        while (countFirst != first.length && countSecond != second.length) {
            if (countFirst < first.length && first[countFirst] < second[countSecond]) {
                result[count] = first[countFirst];
                countFirst++;
                count++;
            } else {
                result[count] = second[countSecond];
                countSecond++;
                count++;
            }
        }
        // добиваем требуемый массив оставшимся массивом
        if (countFirst == first.length) {
            while (count != length) {
                result[count] = second[countSecond];
                countSecond++;
                count++;
            }
        } else {
            result[count] = first[countFirst];
            countFirst++;
            count++;
        }

        return result;
    }
}
