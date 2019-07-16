package com.mattcarp12.data_structures.Stack;

public interface Stack<T> {
    void push(T x);
    T pop();
    T peek();
    boolean isEmpty();
    int size();
}
