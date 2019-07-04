package com.mattcarp12.data_structures.Heap;

public class MaxHeap<T extends Comparable<T>> implements Heap<T> {
    T[] heap;
    int n;

    public MaxHeap(T[] arr) {
        heap = arr;
        n = heap.length;
        heapify();
    }

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
            swap(largest, i);
            heapify(largest);
        }
    }

    @Override
    public void bubbleUp(int i) {
        int parent = (i - 1) / 2;
        while (parent >= 0 && heap[parent].compareTo(heap[i]) < 0){
            swap(parent, i);
            i = parent;
            parent = (i - 1) / 2;
        }

    }

    @Override
    public void add(T x) {
        if (n + 1 > heap.length) resize();
        heap[n++] = x;
        bubbleUp(n - 1);
    }

    @Override
    public void remove(int i) {
        heap[i] = heap[--n];
        heapify(i);
    }

    @Override
    public T peek() {
        return heap[0];
    }

    @Override
    public T pop() {
        T temp = heap[0];
        remove(0);
        return temp;
    }

    private void swap(int i, int j){
        T swap = heap[i];
        heap[i] = heap[j];
        heap[j] = swap;
    }

    private void resize() {
        T[] arr = (T[]) new Object[n * 2];
        for (int i = 0; i < n; i++) {
            arr[i] = heap[i];
        }
        heap = arr;
    }

    public T[] sortedArray() {
        T[] temp = heap.clone();
        T[] arr = (T[]) new Comparable[n];
        int i = n;
        while (i > 0) {
            arr[--i] = pop();
        }
        heap = temp;
        return arr;
    }

    public static void main(String[] args) {
        Integer[] x = {1, 3, 36, 2, 19, 25, 100, 17, 7};
        MaxHeap<Integer> heap = new MaxHeap(x);
        Integer[] y = heap.sortedArray();

    }

}
