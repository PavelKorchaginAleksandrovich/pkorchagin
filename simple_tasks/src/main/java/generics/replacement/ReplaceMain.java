package generics.replacement;

import java.util.Arrays;

public class ReplaceMain {
    public static void main(String[] args) {
        Integer[] arrInt = {1, 2, 7, 8, 9};
        System.out.println(Arrays.toString(arrInt));
        Replace.replace(arrInt, 2, 4);
        System.out.println(Arrays.toString(arrInt));
        String[] arrSTR = {"one", "two", "three", "four", "five"};
        System.out.println(Arrays.toString(arrSTR));
        Replace.replace(arrSTR, 1, 3);
        System.out.println(Arrays.toString(arrSTR));
     }

}
