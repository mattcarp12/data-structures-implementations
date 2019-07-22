package com.mattcarp12.algorithms.Sorting;

import java.util.ArrayList;
import java.util.Random;

public class InsertionSort {

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int key = arr[i];
            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void insertionSort(ArrayList arr) {

    }

    public static void main(String[] args) {
        int[] arr = new int[20];
        Random random = new Random();
        for (int i = 0; i < 20; i++) arr[i] = random.nextInt(100);
        insertionSort(arr);
        for (int num : arr) System.out.print(num + " ");
    }
}
