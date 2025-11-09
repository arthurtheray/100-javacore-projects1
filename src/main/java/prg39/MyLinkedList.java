package prg39;

import java.util.*;

public class MyLinkedList<T> implements Iterable<T>, MyList<T> {
    private int size = 0;
    private Node firstElem;
    private Node lastElem;

    public MyLinkedList() {
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node next = firstElem;
            int count = 0;

            @Override
            public boolean hasNext() {
                return  (count < size);
            }

            @Override
            public T next() {
                if (size == 0 || next == null)
                    throw new NoSuchElementException("List is empty");
                T thisElem = next.obj;
                next = next.nextNode;
                count++;
                return thisElem;
            }
        };
    }

    @Override
    public void add(T element) {
        if (size == 0) {
            firstElem = new Node(null, element, null);
            lastElem = firstElem;
        } else {
            lastElem = new Node(lastElem, element, null);
            lastElem.prevNode.nextNode = lastElem;
        }
        size++;
    }

    @Override
    public void add(T element, int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node byIndex = firstElem;
        for (int i = 0; i < index; i++) {
            byIndex = byIndex.nextNode;
        }

        Node newNode = new Node(byIndex.prevNode, element, byIndex);
        if (byIndex.prevNode != null) {
            byIndex.prevNode.nextNode = newNode;
        }

        byIndex.prevNode = newNode;
        size++;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException{
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node res = firstElem;
        while (index-- != 0) {
            res = res.nextNode;
        }

        Iterator<T> iterator = iterator();
        while (index-- != 0) {
            iterator.next();
        }

        return iterator.next();
    }

    @Override
    public T getFirst() {
        if (size == 0) throw new IllegalStateException("List is empty");
        return firstElem.obj;
    }

    @Override
    public T getLast() throws IllegalStateException{
        if (size == 0) throw new IllegalStateException("List is empty");
        return lastElem.obj;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringJoiner res = new StringJoiner("\n", "{", "}");
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            res.add("{ " + iterator.next().toString() + " }");
        }
        return res.toString();
    }

    private class Node {
        private Node prevNode;
        private T obj;
        private Node nextNode;

        public Node(Node prevNode, T obj, Node nextNode) {
            this.prevNode = prevNode;
            this.obj = obj;
            this.nextNode = nextNode;
        }
    }
}
