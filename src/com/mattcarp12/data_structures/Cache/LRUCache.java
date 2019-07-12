package com.mattcarp12.data_structures.Cache;

import java.util.HashMap;
import java.util.ArrayList;

public class LRUCache {

    private class Node {
        int key;
        int val;
        Node prev, next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int capacity, size;
    HashMap<Integer, Node> hash;
    Node start, end;


    public LRUCache(int capacity) {
        hash = new HashMap();
        this.capacity = capacity;
        this.size = 0;

    }

    public int get(int key) {
        if (hash.containsKey(key)) {
            Node node = hash.get(key);
            remove(node);
            addToTop(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (hash.containsKey(key)) {
            Node node = hash.get(key);
            node.val = value;
            remove(node);
            addToTop(node);
        } else {
            Node node = new Node(key, value);
            if (size < capacity) {
                hash.put(key, node);
                addToTop(node);
                size++;
            } else {
                hash.remove(end.key);
                remove(end);
                hash.put(key, node);
                addToTop(node);
            }
        }

    }

    private void remove(Node node) {
        if (node.prev != null) node.prev.next = node.next;
        else start = node.next;

        if (node.next != null) node.next.prev = node.prev;
        else end = node.prev;
    }

    private void addToTop(Node node) {
        node.next = start;
        node.prev = null;
        if (start != null) start.prev = node;
        start = node;
        if (end == null) end = node;
    }

}
