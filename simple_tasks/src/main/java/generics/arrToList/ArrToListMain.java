package generics.arrToList;


import java.util.ArrayList;

public class ArrToListMain {
    public static void main(String[] args) {
        Integer[] arr = {1, 3, 4, 89};
        ArrayList<Integer> res = ArrToList.arrtolist(arr);
        String[] arrStr = {"one", "two", "three"};
        ArrayList<String> resStr = ArrToList.arrtolist(arrStr);
        System.out.println(res);
        System.out.println(arrStr);

    }
}
