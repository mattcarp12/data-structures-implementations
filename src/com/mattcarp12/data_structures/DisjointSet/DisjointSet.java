package com.mattcarp12.data_structures.DisjointSet;

/**
 * Implements a disjoint set data structure with
 * weighted find (to keep tree height low) and
 * path compression (to keep tree height low).
 */
public class DisjointSet {
    private int[] parent;
    private int[] weight;

    /**
     * Creates a new disjoint union object. Initially
     * all objects are disjoint and thus each has
     * weight 1.
     * @param size - total number of items.
     */
    public DisjointSet(int size) {
        parent = new int[size];
        weight = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = -1;
            weight[i] = 1;
        }
    }

    /**
     * Find the parent node of the given node.
     * Implements path compression by setting the
     * parent of each node on the path to the ultimate
     * root node.
     * @param i - the node to find the root of
     * @return index of the root in the parent array
     */
    public int find(int i) {
        if (parent[i] == -1) return i;
        parent[i] = find(parent[i]);
        return parent[i];
    }

    /**
     * Merge two disjoint sets using weighted join.
     * The set with the smaller weight is merged
     * to the set with larger weight, which minimizes
     * tree height.
     * @param i - first node
     * @param j - second node
     */
    public void merge(int i, int j) {
        int root1 = find(i);
        int root2 = find(j);
        if (root1 != root2) {
            if (weight[root1] > weight[root2]) {
                parent[root2] = root1;
                weight[root1] += weight[root2];
            } else {
                parent[root1] = root2;
                weight[root2] += weight[root1];
            }
        }
    }
}
