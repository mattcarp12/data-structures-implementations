package com.mattcarp12.data_structures.Stack;

public class kStacks {

    int[] arr;
    int[] head;
    int[] next;
    int capacity;
    int size;

    public kStacks(int k, int size) {
        arr = new int[size];

        head = new int[k+1];
        head[0] = 0;
        for (int i = 1; i < k + 1; i++) head[i] = -1;

        next = new int[size];
        for (int i = 0; i < size; i++) next[i] = i + 1;

        capacity = size;
        this.size = 0;
    }

    public void push(int x, int k) {
        int index = head[0];
        arr[index] = x;
        int nextIndex = next[index];
    }



}
