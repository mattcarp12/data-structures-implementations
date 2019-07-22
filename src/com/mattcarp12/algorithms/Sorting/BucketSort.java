package com.mattcarp12.algorithms.Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class BucketSort {

    public static int[] bucketSort(int[] arr, int k) {
        ArrayList[] buckets = new ArrayList[k];
        for (int i = 0; i < k; i++) buckets[i] = new ArrayList<Integer>();
        int M = Integer.MIN_VALUE;
        int key;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] > M) M = arr[i];
        }
        for (int i = 0; i < n; i++) {
            key = arr[i];
            buckets[Math.floor(k * (double)key / M)].add(key);
        }
        ArrayList<Integer> result1 = new ArrayList<Integer>();
        int[] result = new int[n];
        for (int i = 0; i < k; i++) {
            Collections.sort(buckets[k]);
            result1.addAll(buckets[k]);
        }
        for (int i = 0; i < n; i++)
            result[i] = result1.get(i);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[20];
        Random random = new Random();
        for (int i = 0; i < 20; i++) arr[i] = random.nextInt(100);
        int[] res = bucketSort(arr, 5);
        for (int num : res) System.out.print(num + " ");
    }
}
