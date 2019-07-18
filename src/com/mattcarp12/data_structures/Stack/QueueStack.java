package com.mattcarp12.data_structures.Stack;

import com.mattcarp12.data_structures.Queue.ListQueue;
import com.mattcarp12.data_structures.Queue.Queue;

public class QueueStack<T> implements Stack<T> {

    Queue<T> q1;
    Queue<T> q2;

    public QueueStack() {
        q1 = new ListQueue<>();
        q2 = new ListQueue<>();
    }

    @Override
    public void push(T x) {

    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
