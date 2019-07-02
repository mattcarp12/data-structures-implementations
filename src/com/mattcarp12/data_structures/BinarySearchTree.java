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
        int comp = key.compareTo(node.key);
        if (comp == 0) {
            node.value = value;
        }
        else if (comp < 0) {
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
        if (node == null || node.value == null) {
            throw new NoSuchElementException("Key does not exist in this BST. Use put() to add a key-value pair.");
        }
        int comp = key.compareTo(node.key);
        if (comp == 0) {
            return node.value;
        }
        else if (comp < 0) {
            return get(node.left, key);
        }
        else {
            return get(node.right, key);
        }
    }

    @Override
    public boolean contains(K key) {
        return contains(root, key);
    }

    private boolean contains(Node node, K key) {
        if (node == null) return false;
        int comp = key.compareTo(node.key);
        if (comp == 0) return true;
        else if (comp < 0) return contains(node.left, key);
        else return contains(node.right, key);
    }

    @Override
    public void delete(K key) {
        root = put(root, key, null);
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
        if (isEmpty()) throw new NoSuchElementException("Tree is empty!");
        else if (key == null) throw new IllegalArgumentException("Can't search for null key!");
        Node t = floor(root, key);
        if (t == null) return null;
        return t.value;
    }

    private Node floor(Node node, K key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0) return node;
        else if (cmp < 0) return floor(node.left, key);
        Node t = floor(node.right, key);
        if (t != null) return t;
        return node;
    }

    @Override
    public V ceil(K key) {
        return null;
    }

    @Override
    public void invertTree() {
        root = invertTree(root);
    }

    private Node invertTree(Node node) {
        if (node == null) return null;
        Node right = invertTree(node.right);
        Node left = invertTree(node.left);
        node.left = right;
        node.right = left;
        return node;
    }

    @Override
    public Iterator keys(TraversalType type) {
        return null;
    }




    public static void main(String[] args) {
        Tree<Integer, String> bst = new BinarySearchTree<>();
        bst.put(10, "Hello");
        bst.put(20, "World!");
        bst.put(5, "FooBar");
        System.out.println(bst.get(20));
        System.out.println(bst.size());
        bst.put(20,"Good night.");
        System.out.println(bst.get(20));
        System.out.println(bst.size());
        bst.put(0, "Matt");
        bst.put(7, "Ryan");
        bst.put(14, "Carpenter");
        bst.invertTree();

    }
}
