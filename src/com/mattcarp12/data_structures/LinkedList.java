package com.mattcarp12.data_structures;

public class LinkedList<T> implements ListI<T> {

    public static class Node<T> {
        T x;
        Node next;
        public Node(T x) {
            this.x = x;
        }
    }

    Node head; //front of the queue

    public LinkedList() {
        head = new Node(null);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void add(T x) {
        Node t = new Node(x);
        t.next = head.next;
        head.next = t;
    }


    @Override
    public void remove(T x) {
        for (Node t = head; t != null; t = t.next) {
            if (t.next.x.equals(x)) {
                t.next = t.next.next;
                return;
            }
        }
    }

    public Node find(T x) {
        for (Node t = head; t.next != null; t = t.next) {
            if (t.next.x.equals(x)) {
                return t.next;
            }
        }
        return null;
    }
}
