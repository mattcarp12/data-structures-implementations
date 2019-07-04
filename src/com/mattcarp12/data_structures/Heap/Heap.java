package com.mattcarp12.data_structures.Heap;

public interface Heap<T extends Comparable<T>> {

    void heapify();

    void heapify(int i);

    void bubbleUp(int i);

    void add(T x);

    void remove(int i);

    T peek();

    T pop();

    T[] sortedArray();
}
