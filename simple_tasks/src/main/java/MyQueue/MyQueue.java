package MyQueue;

public class MyQueue<T> {
    private Node<T> first;
    private Node<T> last;



    public T get() {
        return this.first.date;
    }

    public T poll() {
        Node<T> delItem = this.first;
        this.first = delItem.next;
        return delItem.date;
    }

    public void push(T value) {
        Node<T> newLink = new Node<>(value);
        if (first != null) {
            this.last.next = newLink;
            this.last = newLink;
            } else {
            this.first = newLink;
            this.last = newLink;
        }
    }

    private static class Node<T> {
        T date;
        Node<T> next;
        Node(T date) {
            this.date = date;
        }
    }
}
