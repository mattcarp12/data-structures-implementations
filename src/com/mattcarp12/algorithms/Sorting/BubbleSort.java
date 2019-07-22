package com.mattcarp12.algorithms.Sorting;

import java.util.Random;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int swaps = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swaps++;
                }
            }
            if (swaps == 0) return;
            swaps = 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[20];
        Random random = new Random();
        for (int i = 0; i < 20; i++) arr[i] = random.nextInt(100);
        bubbleSort(arr);
        for (int num : arr) System.out.print(num + " ");
    }
}
