package MyQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CountQueue {
    public static void main(String[] args) {
        MyQueue<Object> queue = new MyQueue<Object>();
        queue.push(new ArrayList<>());
        queue.push(new Object());
        queue.push(new Object());
        queue.push(new Object());
        queue.push(new Object());
        queue.push(new Object());
        queue.push(new Object());
        queue.push(new Object());
        queue.push(new LinkedList<>());
        System.out.println(count(queue));
        System.out.println(countAdv(queue));
    }
    private static int count(MyQueue queue) {
        int count = 0;
        Object first = queue.get();
        do {
            queue.push(queue.poll());
            count++;
        }
        while (first != queue.get());
        return count;
    }
//    если нет метода получения без выдергивания
    private static int countAdv(MyQueue queue) {
       int count = 1;
       Object tmp;
       Object wasFirt = queue.poll();
       queue.push(wasFirt);
       while (wasFirt != (tmp = queue.poll())) {
           queue.push(tmp);
           count++;
        }
//       как ни крути метод poll выдергивает объект из массива и сейчас массив остался без первого элемента
//       так как мы умеем  добавлять только в конец очереди мы это должны сделать это count раз
//       сначала вернем первый элемент в массив
        queue.push(wasFirt);

        for (int i = count; i != 1; i--) {
            queue.push(queue.poll());
        }
        return count;
    }


}
