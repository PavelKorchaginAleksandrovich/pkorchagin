package generics.arrToList;

import java.util.*;

public class ArrToList {
    public static <T> ArrayList<T> arrtolist(T[] arr) {
        ArrayList<T> result = new ArrayList<>(arr.length);
        //тут можно использовать уже готовые методы
        //но по идее они еще не написаны, раз я сам делают такой метод.

        for (int i = 0; i < arr.length; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
