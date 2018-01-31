package ru.job4j.collections;
import java.util.*;

public class ConvertList {

    public List<Integer> toList (int[][] array) {
        List<Integer> result = new ArrayList<>();
        for (int[] firsArrary: array) {
            for (int number : firsArrary) {
                result.add(number);
            }
        }return  result;
    }
    public int[][] toArray (List<Integer> list, int rows) {
        int col = (int) Math.ceil(list.size() / rows);
        int[][] result = new int [col][rows];
        int colIndex = 0, rowsIndex = 0;
        for (Integer number : list) {
            result[colIndex][rowsIndex] = number;
            if (rowsIndex != rows) {
                rowsIndex++;
            } else {
                colIndex++;
                rowsIndex =0;
            }
        }
        return result;
    }
}



