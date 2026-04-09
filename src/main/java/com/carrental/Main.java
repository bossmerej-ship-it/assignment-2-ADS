package com.carrental;

public class Main {

    public static void main(String[] args) {
        testMyArrayList();
        testMyLinkedList();
        testMyStack();
        testMyQueue();
        testMyMinHeap();
    }

    static void testMyArrayList() {
        System.out.println("=== MyArrayList ===");
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(3);
        list.add(5);
        list.addFirst(1);
        list.addLast(7);
        list.add(2, 4);
        System.out.println("After adds: " + list);
        System.out.println("get(2): " + list.get(2));
        System.out.println("getFirst: " + list.getFirst());
        System.out.println("getLast: " + list.getLast());
        list.set(1, 99);
        System.out.println("After set(1,99): " + list);
        list.set(1, 3);
        list.remove(2);
        System.out.println("After remove(2): " + list);
        list.removeFirst();
        System.out.println("After removeFirst: " + list);
        list.removeLast();
        System.out.println("After removeLast: " + list);
        list.add(3);
        System.out.println("indexOf(3): " + list.indexOf(3));
        System.out.println("lastIndexOf(3): " + list.lastIndexOf(3));
        System.out.println("exists(5): " + list.exists(5));
        System.out.println("exists(99): " + list.exists(99));
        MyArrayList<Integer> s = new MyArrayList<>();
        s.add(5); s.add(2); s.add(8); s.add(1); s.add(3);
        System.out.println("Before sort: " + s);
        s.sort();
        System.out.println("After sort: " + s);
        s.clear();
        System.out.println("After clear: " + s);
        System.out.println();
    }

    static void testMyLinkedList() {
        System.out.println("=== MyLinkedList ===");
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(3);
        list.add(5);
        list.addFirst(1);
        list.addLast(7);
        list.add(2, 4);
        System.out.println("After adds: " + list);
        System.out.println("get(2): " + list.get(2));
        System.out.println("getFirst: " + list.getFirst());
        System.out.println("getLast: " + list.getLast());
        list.remove(2);
        System.out.println("After remove(2): " + list);
        list.removeFirst();
        System.out.println("After removeFirst: " + list);
        list.removeLast();
        System.out.println("After removeLast: " + list);
        MyLinkedList<Integer> s = new MyLinkedList<>();
        s.add(5); s.add(2); s.add(8); s.add(1); s.add(3);
        System.out.println("Before sort: " + s);
        s.sort();
        System.out.println("After sort: " + s);
        s.clear();
        System.out.println("After clear: " + s);
        System.out.println();
    }

    static void testMyStack() {
        System.out.println("=== MyStack ===");
        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("peek: " + stack.peek());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.println("size: " + stack.size());
        System.out.println("isEmpty: " + stack.isEmpty());
        System.out.println();
    }

    static void testMyQueue() {
        System.out.println("=== MyQueue ===");
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("Alice");
        queue.enqueue("Bob");
        queue.enqueue("Charlie");
        System.out.println("peek: " + queue.peek());
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("size: " + queue.size());
        System.out.println();
    }

    static void testMyMinHeap() {
        System.out.println("=== MyMinHeap ===");
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.insert(15);
        heap.insert(3);
        heap.insert(9);
        heap.insert(1);
        heap.insert(7);
        System.out.println("getMin: " + heap.getMin());
        System.out.println("extractMin: " + heap.extractMin());
        System.out.println("extractMin: " + heap.extractMin());
        System.out.println("extractMin: " + heap.extractMin());
        System.out.println("size: " + heap.size());
        System.out.println();
    }
}
