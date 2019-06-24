package com.mattcarp12.data_structures;

public class LinkedList<T> implements ListI<T> {



    private static class Node<T> {
        T x;
        Node next;
        Node(T x) {
            this.x = x;
        }
    }

    Node head; //front of the queue
    Node tail; //end of the queue


    /**
     * {@inheritDoc}
     */
    @Override
    public void add(T x) {
        tail.next = new Node(x);
        tail = tail.next;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void push(T x) {
        Node t = new Node(x);
        t.next = head;
        head = t;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T remove() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T pop() {
        return null;
    }

}
