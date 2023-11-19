package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Iterable<T>, Deque<T> {
    private class Node<T> {
        private T item;
        private Node<T> prev;
        private Node<T> next;

        Node(T i, Node<T> prevNode, Node<T> nextNode) {
            item = i;
            prev = prevNode;
            next = nextNode;
        }
    }

    private final Node<T> sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node<>(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        Node<T> sNext = sentinel.next;
        Node<T> node = new Node(item, sentinel, sNext);
        sNext.prev = node;
        sentinel.next = node;
        size++;
    }

    public void addLast(T item) {
        Node<T> sPrev = sentinel.prev;
        Node<T> node = new Node(item, sPrev, sentinel);
        sPrev.next = node;
        sentinel.prev = node;
        size++;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node<T> n = sentinel.next;
        while (n != sentinel) {
            System.out.print(n.item + " ");
            n = n.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node<T> n = sentinel.next;
        T item = n.item;
        n.next.prev = sentinel;
        sentinel.next = n.next;

        n = null;
        size--;
        return item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        Node<T> n = sentinel.prev;
        T item = n.item;
        n.prev.next = sentinel;
        sentinel.prev = n.prev;

        n = null;
        size--;
        return item;
    }

    public T get(int index) {
        if (isEmpty()) {
            return null;
        }

        Node<T> n = sentinel.next;
        int cur = 0;
        while (cur < index) {
            n = n.next;
            if (n == sentinel) {
                return null;
            }
            cur++;
        }

        return n.item;
    }

    public T getRecursive(int index) {
        return getRecursive(index, sentinel.next);
    }

    private T getRecursive(int index, Node<T> n) {
        if (n == sentinel) {
            return null;
        }

        if (index == 0) {
            return n.item;
        }

        return getRecursive(index - 1, n.next);
    }

    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }

    private class LinkedListDequeIterator implements Iterator<T> {
        private Node<T> s;

        LinkedListDequeIterator() {
            s = sentinel;
        }

        public boolean hasNext() {
            return s.next != sentinel;
        }

        public T next() {
            T item = s.next.item;
            s = s.next;
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
