package com.mattcarp12.data_structures.Stack;

public class ListStack<T> implements Stack<T>{

    Node head;

    public ListStack() {
        head = null;
    }


    @Override
    public void push(T x) {
        Node t = new Node(x);
        t.next = head;
        head = t;
    }

    @Override
    public T pop() {
        T t = (T) head.val;
        head = head.next;
        return t;
    }

    @Override
    public T peek() {
        return (T) head.val;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
}

class Node<T> {
    T val;
    Node next;
    public Node(T x) {
        val = x;
    }
}
