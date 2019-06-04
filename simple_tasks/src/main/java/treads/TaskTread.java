package treads;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TaskTread {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args)  {
        float[] arr = new float[size];
        fillArr(arr);

        long timeSingleTread = System.currentTimeMillis();
        calculateArray(arr);
       showTime(timeSingleTread);

//----------------------------------------------------------------------------
        fillArr(arr);
        final long timeMultiTread = System.currentTimeMillis();
        float[] firstHalf = new float[h];
        float[] secondHalf = new float[h];
        System.arraycopy(arr, 0, firstHalf, 0, h);
        System.arraycopy(arr, h, secondHalf, 0, h);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                calculateArray(firstHalf);
                showTime(timeMultiTread);
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                calculateArray(secondHalf);
                showTime(timeMultiTread);
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(firstHalf, 0, arr, 0, h);
        System.arraycopy(secondHalf, 0, arr, h, h);
        showTime(timeMultiTread);

    }

    public static void calculateArray(float[] arr) {
        for (int i = 0; i < arr.length; i++)
        arr[i] = (float)(arr[i] * Math.sin(0.2f + arr[i] / 5) * Math.cos(0.2f + arr[i]/ 5) * Math.cos(0.4f + arr[i]  / 2));
    }

    static void fillArr(float[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = 1;
    }

    public static void calculateList(float[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }

    static void fillList(float[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = 1;
    }
    static void showTime(long time) {
        System.out.println(System.currentTimeMillis() - time);
    }
}



