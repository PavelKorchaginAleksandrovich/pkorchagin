package ru.job4j.collectpro;

public class CheckCycle {

    public boolean hasCycle(SimpleNode node) {
        boolean result = false;
        SimpleNode count = node;
        while (!result && count != null) {
            SimpleNode nextItem = count.next;
            while (nextItem != null) {
                if (count == nextItem) {
                    result = true;
                    break;
                } else {
                    nextItem = nextItem.next;
                }
            }
            count = count.next;
        }
        return result;
    }
}

