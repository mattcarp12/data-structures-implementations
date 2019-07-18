package com.mattcarp12.data_structures.Queue;

public interface Queue<T> {
    void enqueue(T x);
    T dequeue();
    T peekFront();
    T peekRear();
    int size();
    boolean isEmpty();
}
