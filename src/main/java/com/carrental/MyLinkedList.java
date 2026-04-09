package com.carrental;

import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {

    private class MyNode {
        T element;
        MyNode next;
        MyNode prev;
        MyNode(T element) { this.element = element; }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    private MyNode nodeAt(int index) {
        MyNode current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.prev;
        }
        return current;
    }

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void addFirst(T item) {
        MyNode node = new MyNode(item);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        MyNode node = new MyNode(item);
        if (tail == null) {
            head = tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        if (index == 0) { addFirst(item); return; }
        if (index == size) { addLast(item); return; }
        MyNode successor = nodeAt(index);
        MyNode predecessor = successor.prev;
        MyNode node = new MyNode(item);
        node.next = successor;
        node.prev = predecessor;
        predecessor.next = node;
        successor.prev = node;
        size++;
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        nodeAt(index).element = item;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return nodeAt(index).element;
    }

    @Override
    public T getFirst() {
        if (head == null) throw new RuntimeException("List is empty");
        return head.element;
    }

    @Override
    public T getLast() {
        if (tail == null) throw new RuntimeException("List is empty");
        return tail.element;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        if (index == 0) { removeFirst(); return; }
        if (index == size - 1) { removeLast(); return; }
        MyNode node = nodeAt(index);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
        size--;
    }

    @Override
    public void removeFirst() {
        if (head == null) throw new RuntimeException("List is empty");
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev.next = null;
            head.prev = null;
        }
        size--;
    }

    @Override
    public void removeLast() {
        if (tail == null) throw new RuntimeException("List is empty");
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next.prev = null;
            tail.next = null;
        }
        size--;
    }

    @Override
    public void sort() {
        if (size <= 1) return;
        head = mergeSort(head);
        MyNode current = head;
        current.prev = null;
        while (current.next != null) {
            current.next.prev = current;
            current = current.next;
        }
        tail = current;
    }

    @SuppressWarnings("unchecked")
    private MyNode mergeSort(MyNode start) {
        if (start == null || start.next == null) return start;
        MyNode mid = getMiddle(start);
        MyNode secondHalf = mid.next;
        mid.next = null;
        MyNode left = mergeSort(start);
        MyNode right = mergeSort(secondHalf);
        return merge(left, right);
    }

    private MyNode getMiddle(MyNode start) {
        MyNode slow = start, fast = start;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    @SuppressWarnings("unchecked")
    private MyNode merge(MyNode a, MyNode b) {
        if (a == null) return b;
        if (b == null) return a;
        if (((Comparable<T>) a.element).compareTo(b.element) <= 0) {
            a.next = merge(a.next, b);
            return a;
        } else {
            b.next = merge(a, b.next);
            return b;
        }
    }

    @Override
    public int indexOf(Object object) {
        MyNode current = head;
        for (int i = 0; i < size; i++) {
            if (object == null ? current.element == null : object.equals(current.element))
                return i;
            current = current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode current = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (object == null ? current.element == null : object.equals(current.element))
                return i;
            current = current.prev;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        MyNode current = head;
        for (int i = 0; i < size; i++) {
            result[i] = current.element;
            current = current.next;
        }
        return result;
    }

    @Override
    public void clear() {
        MyNode current = head;
        while (current != null) {
            MyNode next = current.next;
            current.next = null;
            current.prev = null;
            current = next;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode current = head;
            public boolean hasNext() { return current != null; }
            public T next() {
                T element = current.element;
                current = current.next;
                return element;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        MyNode current = head;
        while (current != null) {
            sb.append(current.element);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        return sb.append("]").toString();
    }
}