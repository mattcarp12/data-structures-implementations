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

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(T x) {
        Node t = new Node(x);
        t.next = head;
        head = t;
    }


    @Override
    public void remove(T x) {
        for (Node t = head; t != null; t = t.next) {
            if (t.next.x.equals(x)) {
                t.next = t.next.next;
            }
        }
    }

    Node find(T x) {
        for (Node t = head; t != null; t = t.next) {
            if (t.x.equals(x)) {
                return t;
            }
        }
        return null;
    }
}
