package ru.job4j.collections;
import java.util.*;
/**
 *@class ConvertList .
 *@author Pavel Korchagin.
 *@since 01.02.2018.
 *@version 1.0.
 */
public class ConvertList {
    /**
     * Метод преобразовывает двумерный массив в одномерную коллекцию List
     * @param array - входящий двумерный массив
     * @return коллекцию List
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> result = new ArrayList<>();
        for (int[] firsArrary: array) {
            for (int number : firsArrary) {
                result.add(number);
            }
        }
        return result;
    }

    /**
     * Преобразоввает коллекцию в двумерный массив
     * @param list - входящая коллекция
     * @param rows - количество строк массива
     * @return двумерный массив
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int col = (int) Math.ceil((double) list.size() / rows);
        int[][] result = new int[col][rows];
        int colIndex = 0, rowsIndex = 0;
        for (Integer number : list) {
            result[colIndex][rowsIndex++] = number;
            if (rowsIndex == rows) {
                colIndex++;
                rowsIndex = 0;
            }
        }
        return result;
    }

    /**
     * преобразовывает коллекцию с одномерными массивами в коллецкцию
     * @param list - входящая коллекция с массивами
     * @return - одномерная коллекция
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList();
        Iterator<int[]> iterator = list.iterator();
        while (iterator.hasNext()) {
          for (int num : iterator.next()) {
              result.add(num);
          }
        }
        return result;
    }

}



