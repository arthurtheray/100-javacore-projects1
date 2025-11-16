package prg39;

import java.util.*;

public class MyLinkedList<T> implements MyList<T> {
    private int size = 0;
    private Node firstElem;
    private Node lastElem;

    public MyLinkedList() {
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node next = firstElem;

            @Override
            public boolean hasNext() {
                return  (next != null);
            }

            @Override
            public T next() {
                if (size == 0 || next == null) {
                    throw new NoSuchElementException("No more elements");
                }

                T thisElem = next.obj;
                next = next.nextNode;
                return thisElem;
            }
        };
    }

    @Override
    public void add(T element) {
        lastElem = new Node(lastElem, element, null);
        if (size++ == 0) {
            firstElem = lastElem;
        }
    }

    @Override
    public void add(T element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 0) {
            firstElem = new Node(null, element, firstElem);
            size++;
            return;
        }

        if (index == size) {
            add(element);
            return;
        }

        Node byIndex = firstElem;
        for (int i = 0; i < index; i++) {
            byIndex = byIndex.nextNode;
        }

        new Node(byIndex.prevNode, element, byIndex);
        size++;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException{
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Iterator<T> iterator = iterator();
        while (index-- != 0) {
            iterator.next();
        }

        return iterator.next();
    }

    @Override
    public T getFirst() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }

        return firstElem.obj;
    }

    @Override
    public T getLast() throws IllegalStateException{
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
        return lastElem.obj;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringJoiner res = new StringJoiner("\n");
        for (T t : this) {
            res.add("{ " + t + " },");
        }
        return res.toString();
    }

    private class Node {
        private Node prevNode;
        private final T obj;
        private Node nextNode;

        public Node(Node prevNode, T obj, Node nextNode) {
            this.prevNode = prevNode;
            this.obj = obj;
            this.nextNode = nextNode;

            if (prevNode != null) {
                prevNode.nextNode = this;
            }

            if (nextNode != null) {
                nextNode.prevNode = this;
            }
        }
    }
}
