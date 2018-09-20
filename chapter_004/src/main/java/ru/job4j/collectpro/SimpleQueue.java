package ru.job4j.collectpro;

public class SimpleQueue<T> {
    private SimpleStack<T> stack = new SimpleStack<>();
    private int size;

    public void push(T value) {
        stack.push(value);
        this.size++;
    }

    public T pull() {
        SimpleStack<T> queue = convert(this.stack);
        T result = queue.poll();
        this.stack = convert(queue);
        return result;
    }
    private SimpleStack<T> convert(SimpleStack<T> list) {
        SimpleStack<T> result = new SimpleStack<>();
        for (int i = 0; i < this.size; i++) {
            result.push(list.poll());
        }
        return result;
    }
}
