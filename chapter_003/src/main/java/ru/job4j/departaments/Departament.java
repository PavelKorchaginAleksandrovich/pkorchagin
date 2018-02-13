package ru.job4j.departaments;

import java.util.*;

public class Departament {
    private final static  char SLASH = '\\';
    private List<String> deps = new ArrayList<>();

    public Departament(List<String> deps) {
        this.deps = deps;
    }

    private List<Integer> indexesOfSlash(String string) {
        char[] arrayString = string.toCharArray();
        List<Integer> indexArrary = new ArrayList<>();
        for (int index = 0; index != arrayString.length; index++) {
            if (arrayString[index] == SLASH) {
                indexArrary.add(index);
            }
        }
        return indexArrary;
    }

    public void fillDeps() {
        List<String> neededDeps = new ArrayList<>();
        for (String dep : this.deps) {
            List<Integer> indexArrary = this.indexesOfSlash(dep);
            for (Integer index : indexArrary) {
                String str = dep.substring(0, index);
                if (!this.deps.contains(str) && !neededDeps.contains(str)) {
                    neededDeps.add(str);
                }
            }
        }
        this.deps.addAll(neededDeps);
    }

    public void directSort() {
        this.deps.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
               return o1.compareTo(o2);
            }
        });
    }
    public void reverseSort() {
        this.deps.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result;
                List<Integer> indexesO1 = indexesOfSlash(o1);
                List<Integer> indexesO2 = indexesOfSlash(o2);
                int size1 =  indexesO1.size();
                int size2 =  indexesO2.size();
                if (size1 == size2) {
                   result = o2.compareTo(o1);
                } else {

                    if (size1 == 0) {
                        indexesO1.add(o1.length());
                    }
                    if (size2 == 0) {
                        indexesO2.add(o2.length());
                    }
                    int min = indexesO1.size() < indexesO2.size() ? indexesO1.size()  : indexesO2.size();
                    if (o1.substring(0, indexesO1.get(min - 1)).equals(o2.substring(0, indexesO2.get(min - 1)))) {
                        result = size1 - size2;
                    } else {
                        result = o2.substring(0,  indexesO1.get(min - 1)).compareTo(o1.substring(0,  indexesO2.get(min - 1)));
                    }
                }
                return result;
            }
        });
    }

}