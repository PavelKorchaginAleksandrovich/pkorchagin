package ru.job4j;

/**
 *@class ChekString задача 5.3.
 *@author Pavel Korchagin.
 *@since 23.12.2017.
 *@version 1.0.
 */


public class ChekString {
    /**
     * Проверка входения одной строки в другую
     * @param origin
     * @param sub
     * @return
     */
    public boolean contains(String origin, String sub) {
        char[] originArray = origin.toCharArray();
        char[] subArray = sub.toCharArray();
        int lenght = originArray.length - subArray.length;
        int count = 0;
        boolean result = false;
        while (count <= lenght && !result) {
            if (originArray[count] == subArray[0]) {
                int countInner = 1;
                while (countInner < subArray.length && originArray[count + countInner] == subArray[countInner]) {
                    countInner++;
                }
                result = countInner == subArray.length;
            }

            count++;
        }
        return result;
    }
}
