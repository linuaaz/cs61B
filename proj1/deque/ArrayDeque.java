package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Iterable<T>, Deque<T> {
    private T[] items;
    private int size;
    private int nextFirst = 4;
    private int nextLast = 5;
    private final double factor = 0.25;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
    }

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        int startIndex = nextFirst + 1;
        for (int i = 0; i < size; i++) {
            a[(i + startIndex) % a.length] = items[(i + startIndex) % items.length];
        }
        nextFirst = nextFirst % a.length;
        nextLast = (startIndex + size) % a.length;
        items = a;
    }

    public void addFirst(T item) {
        if (items[nextFirst] != null) {
            resize(items.length * 2);
        }
        items[nextFirst] = item;
        size++;
        nextFirst = (nextFirst - 1 + items.length) % items.length;
    }

    public void addLast(T item) {
        if (items[nextLast] != null) {
            resize(items.length * 2);
        }
        items[nextLast] = item;
        size++;
        nextLast = (nextLast + 1) % items.length;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int startIndex = nextFirst + 1;
        for (int i = 0; i < size; i++) {
            System.out.print(items[startIndex + i] + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        int newNextFirst = (nextFirst + 1) % items.length;
        T item = items[newNextFirst];
        if (item == null) {
            return null;
        }
        nextFirst = newNextFirst;
        items[newNextFirst] = null;
        size--;

        if (items.length >= 16 && (double) size / items.length < factor) {
            resize((int) (items.length * factor));
        }
        return item;
    }

    public T removeLast() {
        int newNextLast = (nextLast - 1 + items.length) % items.length;
        T item = items[newNextLast];
        if (item == null) {
            return null;
        }
        nextLast = newNextLast;
        items[newNextLast] = null;
        size--;

        if (items.length >= 16 && (double) size / items.length < factor) {
            resize((int) (items.length * factor));
        }
        return item;
    }

    public T get(int index) {
        if (index + 1 > size) {
            return null;
        }

        int startIndex = nextFirst + 1;
        return items[(startIndex + index) % items.length];
    }

    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int pos;

        ArrayDequeIterator() {
            pos = 0;
        }

        public boolean hasNext() {
            return pos < size;
        }

        public T next() {
            T item = get(pos);
            pos++;
            return item;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof Deque)) {
            return false;
        }

        Deque<T> other = (Deque<T>) o;
        if (other.size() != this.size()) {
            return false;
        }

        for (int i = 0; i < this.size(); i++) {
            T thisItem = this.get(i);
            T otherItem = other.get(i);

            if (otherItem.getClass() != thisItem.getClass()) {
                return false;
            }

            if (!thisItem.equals(otherItem)) {
                return false;
            }
        }

        return true;
    }

}
