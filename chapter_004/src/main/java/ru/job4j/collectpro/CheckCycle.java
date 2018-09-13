package ru.job4j.collectpro;

public class CheckCycle {

    public boolean hasCycle(SimpleNode node) {
        boolean result = false;
//        этот алгоритм в корне неверен, так как если замыкание
//        произойдет в середине, то будет вечный цикл.
//        Произошло это из-за неверного представления коллекции в уме.
        SimpleNode cursor = node.next;
        SimpleNode tempNode = node;
        int count = 1;
//        while (!result && count != null) {
//            SimpleNode nextItem = count.next;
//            while (nextItem != null) {
//                if (count == nextItem) {
//                    result = true;
//                    break;
//                } else {
//                    nextItem = nextItem.next;
//                }
//            }
//            count = count.next;
//        }
//        меняем алгоритм
//        алгоритм работы: cursor будет предвигаться на следующий элемент, пока он не станет равным null.
//        на каждой итерации цикла будет проводиться сравнение элемента cursor со всеми предыдущими элементами:
//        например курсор находится на 5-м элементе, то сравнение будет с элементами 1 - 4.

            for (int i = 1; cursor != null; i++) {

                if (tempNode == cursor) {
                    result = true;
                    break;
                } else if (i == count) {
                        cursor = cursor.next;
                        tempNode = node;
                        i = 0;
                        count++;
                } else {
                        tempNode = tempNode.next;
                    }
                }
        return result;
    }
}

