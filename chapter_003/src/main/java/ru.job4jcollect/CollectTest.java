package ru.job4jcollect;
import java.util.*;


public class CollectTest {

    public long add(Collection<String> collection, int amount) {
        String[] testArray = new String[amount];
        for (int count = 0; count != amount; count++) {
            testArray[count] = new StringBuilder().append("testString").append((int) (Math.random() * 1000000)).toString();
        }
        long timeStart = System.nanoTime();
        for (String string : testArray) {
            collection.add(string);
        }
        long timeStop = System.nanoTime();
        return (timeStop - timeStart) / 1000;
    }

    public long del(Collection<String> collection, int amount) {
        String[] forDel = new String[amount];

        Iterator<String> iterator = collection.iterator();
        for (int count = 0; count != amount; count++) {
            forDel[count] = iterator.next();
        }
        long timeStart = System.nanoTime();
        for (String string : forDel) {
            collection.remove(string);
        }
        long timeStop = System.nanoTime();
        return (timeStop - timeStart) / 1000;
    }

    public static void main(String[] args) {
        CollectTest test = new CollectTest();
        Collection<String> testArrayList = new ArrayList();
        Collection<String> testLinkedList = new LinkedList();
        Collection<String> testTreeSet = new TreeSet();

        long timeAddLinkedList = test.add(testLinkedList, 100000);
        long timeAddArrayList = test.add(testArrayList, 100000);
        long timeAddtestTreeSet = test.add(testTreeSet, 100000);

        long timeDelLinkedList = test.del(testLinkedList, 10000);
       long timeDelArrayList = test.del(testArrayList, 10000);
        long timeDeltestTreeSet = test.del(testTreeSet, 10000);




        System.out.println("Время ArrayList: add:" + timeAddArrayList + " del " + timeDelArrayList);
        System.out.println("Время LinkedList: add " + timeAddLinkedList + " del " + timeDelLinkedList);
        System.out.println("Время TreeSet: add: " + timeAddtestTreeSet + " del " + timeDeltestTreeSet);


    }
}
