package ru.job4j.collections;

import java.util.*;

public class ListCompare implements Comparator<List<Integer>>  {

    @Override
    public int compare(List<Integer> o1, List<Integer> o2) {
        int compareElements = 0;
        int compareLenght = o1.size() == o2.size() ? 0 : o1.size() > o2.size() ? 1 : -1;
        Iterator<Integer> itO1 = o1.iterator();
        Iterator<Integer> itO2 = o2.iterator();
        while (itO1.hasNext() && itO2.hasNext() && compareElements == 0) {
            compareElements = itO1.next().compareTo(itO2.next());
        }

        return compareElements == 0 ? compareLenght : compareElements;

    }
}
