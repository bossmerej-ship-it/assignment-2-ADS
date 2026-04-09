package com.carrental;

public class MyQueue<T> {

    private final MyLinkedList<T> list;

    public MyQueue() {
        list = new MyLinkedList<>();
    }

    public void enqueue(T item) {
        list.addLast(item);
    }

    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        T front = list.getFirst();
        list.removeFirst();
        return front;
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }

    @Override
    public String toString() {
        return "Queue: " + list;
    }
}
