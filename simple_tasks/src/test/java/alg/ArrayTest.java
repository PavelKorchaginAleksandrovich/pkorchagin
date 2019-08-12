package alg;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class ArrayTest {
    long startTime, endTime;
    Array<Integer> arrayBub, arrayIns, arraySel;
    @Before
    public void init() {
        arrayBub = new Array<>(400000);
        for (int i = 0; i < 400000; i++) {
            int el = (int)(Math.random() * 10000000);
            arrayBub.add(el);
        }
        arrayIns = arrayBub.copy();
        arraySel = arrayBub.copy();
    }

    @Test
    public void sortTest() {
        startTime = System.currentTimeMillis();
        arrayBub.sortBubble();
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);

        startTime = System.currentTimeMillis();
        arrayIns.sortInsert();
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);

        startTime = System.currentTimeMillis();
        arraySel.sortSelect();
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);





    }


}