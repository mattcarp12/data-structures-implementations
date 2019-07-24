package com.mattcarp12.data_structures.Queue;

public class ListQueue<T> implements Queue<T> {

    Node front;
    Node back;
    int size;

    @Override
    public void enqueue(T x) {
        Node t = new Node(x);
        t.next = back;
        if (!isEmpty()) {
            back.prev = t;
        }
        if (isEmpty()) {
            front = t;
        }
        back = t;
        size++;
    }

    @Override
    public T dequeue() {
        T t = (T) front.val;
        if (size == 1) {
            back = front = null;
        } else {
            Node n = front.prev;
            front.prev = null;
            n.next = null;
            front = n;
        }
        size--;
        return t;
    }

    @Override
    public T peekFront() {
        return (T) front.val;
    }

    @Override
    public T peekRear() {
        return (T) back.val;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}

class Node<T> {
    T val;
    Node next;
    Node prev;
    public Node(T x) {
        val = x;
    }
}
