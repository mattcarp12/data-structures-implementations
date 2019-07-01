package com.mattcarp12.data_structures;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinarySearchTree<K extends Comparable<K>, V> implements Tree<K, V> {

    private class Node {
        K key;
        V value;
        Node left;
        Node right;
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    @Override
    public void put(K key, V value) {
        put(root, key, value);
    }

    private void put(Node node, K key, V value) {
        if (node.key.compareTo(key) == 0) {
            node.value = value;
        }
        else if (node == null) {
            node = new Node(key, value);
        }
        else if (node.key.compareTo(key) < 0) {
            put(node.left, key, value);
        }
        else {
            put(node.right, key, value);
        }
    }

    @Override
    public V get(K key) {
        return get(root, key);
    }

    private V get(Node node, K key) {
        if (node == null) {
            throw new NoSuchElementException("Key does not exist in this BST. Use put() to add a key-value pair.");
        }
        if (node.key.compareTo(key) == 0) {
            return node.value;
        }
        else if (node.key.compareTo(key) < 0) {
            return get(node.left, key);
        }
        else {
            return get(node.right, key);
        }
    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public void delete(K key) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public V floor(K key) {
        return null;
    }

    @Override
    public V ceil(K key) {
        return null;
    }

    @Override
    public V min() {
        return null;
    }

    @Override
    public V max() {
        return null;
    }

    @Override
    public Iterator keys() {
        return null;
    }
}
