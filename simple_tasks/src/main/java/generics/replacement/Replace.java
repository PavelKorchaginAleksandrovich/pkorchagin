package generics.replacement;

public class Replace {

    public static <T> void replace(T[] arr, int ind1, int ind2) {
        T temp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = temp;
    }
}
