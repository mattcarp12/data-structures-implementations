package com.mattcarp12.data_structures.Heap;

public class MaxHeap<T extends Comparable<T>> implements Heap<T> {
    T[] heap;
    int n;

    @Override
    public void heapify() {
        int start = (heap.length / 2) - 1;
        for (int j = start; j > -1; j--) heapify(j);
    }

    @Override
    public void heapify(int i) {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if (l < n && heap[l].compareTo(heap[i]) > 0) largest = l;
        if (r < n && heap[r].compareTo(heap[largest]) > 0) largest = r;

        if (largest != i) {
            T swap = heap[i];
            heap[i] = heap[largest];
            heap[largest] = swap;
            heapify(largest);
        }
    }

    @Override
    public void bubbleUp(int i) {

    }

    @Override
    public void trickleDown(int i) {

    }

    @Override
    public void add(T x) {

    }

    @Override
    public void remove(T x) {

    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public T pop() {
        return null;
    }
}
