package ru.job4j.collectpro;

        import java.util.Iterator;

public class Converter<T> {
    Iterator<T> inner;

    public Iterator<T> convert(Iterator<Iterator<T>> iterator) {

        inner = iterator.next();
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                move();
                return inner.hasNext();
            }

            @Override
            public T next() {
                move();
                return inner.next();
            }

            private void move() {
                while (!inner.hasNext() && iterator.hasNext()) {
                    inner = iterator.next();
                }
            }
        };
    }
}