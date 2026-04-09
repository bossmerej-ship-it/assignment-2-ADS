package com.carrental;

public class MyMinHeap<T extends Comparable<T>> {

    private final MyArrayList<T> list;

    public MyMinHeap() {
        list = new MyArrayList<>();
    }

    private int parent(int i)     { return (i - 1) / 2; }
    private int leftChild(int i)  { return 2 * i + 1; }
    private int rightChild(int i) { return 2 * i + 2; }

    private void swap(int i, int j) {
        T tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

    private void heapifyUp(int i) {
        while (i > 0 && list.get(i).compareTo(list.get(parent(i))) < 0) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void heapifyDown(int i) {
        int size = list.size();
        while (true) {
            int smallest = i;
            int left  = leftChild(i);
            int right = rightChild(i);
            if (left < size && list.get(left).compareTo(list.get(smallest)) < 0) smallest = left;
            if (right < size && list.get(right).compareTo(list.get(smallest)) < 0) smallest = right;
            if (smallest == i) break;
            swap(i, smallest);
            i = smallest;
        }
    }

    public void insert(T item) {
        list.addLast(item);
        heapifyUp(list.size() - 1);
    }

    public T extractMin() {
        if (isEmpty()) throw new RuntimeException("Heap is empty");
        T min = list.getFirst();
        list.set(0, list.getLast());
        list.removeLast();
        if (!isEmpty()) heapifyDown(0);
        return min;
    }

    public T getMin() {
        if (isEmpty()) throw new RuntimeException("Heap is empty");
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
        return "MinHeap: " + list;
    }
}