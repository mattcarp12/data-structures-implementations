package com.mattcarp12.data_structures.Stack;

public class ArrayStack<T> implements Stack<T> {

    int DEFAULT_SIZE = 4;
    int head;
    T[] stack;
    int size;

    public ArrayStack() {
        stack = (T[]) new Object[DEFAULT_SIZE];
        head = DEFAULT_SIZE - 1;
    }

    @Override
    public void push(T x) {
        if (head == -1) resize();
        stack[head--] = x;
        size++;
    }

    @Override
    public T pop() {
        head++;
        size--;
        return stack[head];
    }

    @Override
    public T peek() {
        return stack[head + 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void resize() {
        int n = stack.length;
        T[] temp = (T[]) new Object[n * 2];
        int m = n * 2 - 1;
        for (int i = n - 1; i >= 0; i--) {
            temp[m--] = stack[i];
        }
        stack = temp;
        head = m;
    }

    @Override
    public int size() {
        return size;
    }
}
