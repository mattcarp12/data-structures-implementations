package com.mattcarp12.data_structures;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinarySearchTree<K extends Comparable<K>, V> implements Tree<K, V> {

    private class Node {
        K key;
        V value;
        Node left;
        Node right;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) throw new IllegalArgumentException("Can't put null key into tree");
        this.root = put(root, key, value);
    }

    private Node put(Node node, K key, V value) {
        if (node == null) {
            this.size++;
            node = new Node(key, value);
        }
        else if (node.key.compareTo(key) == 0) {
            node.value = value;
        }
        else if (node.key.compareTo(key) < 0) {
            node.left = put(node.left, key, value);
        }
        else {
            node.right = put(node.right, key, value);
        }

        return node;
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
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
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



    public static void main(String[] args) {
        Tree<Integer, String> bst = new BinarySearchTree<>();
        bst.put(10, "Hello");
        bst.put(20, "World!");
        bst.put(5, "FooBar");
        System.out.println(bst.size());
        bst.put(20,"Good night.");
        System.out.println(bst.size());
    }
}
