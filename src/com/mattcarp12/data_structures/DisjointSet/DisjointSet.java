package com.mattcarp12.data_structures.DisjointSet;

public class DisjointSet {
    int[] parent;
    int[] weight;

    public DisjointSet(int size) {
        parent = new int[size];
        weight = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = -1;
            weight[i] = 1;
        }
    }

    public int find(int i) {
        if (parent[i] == -1) return i;
        parent[i] = find(parent[i]);
        return parent[i];
    }

    public void merge(int i, int j) {
        int root1 = find(i);
        int root2 = find(j);
        if (weight[root1] < weight[root2]) {
            parent[root1] = root2;
            weight[root2] += weight[root1];
        } else {
            parent[root2] = root1;
            weight[root1] += weight[root2];
        }
    }
}
