package com.mattcarp12.data_structures.Tree;
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
    private K[] preorder = null;
    private K[] inorder = null;
    private V[] values_preorder = null;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    public BinarySearchTree(K[] keys, V[] vals) {
        if (keys.length != vals.length) throw new IllegalArgumentException("Arguments must be equal length");
        if (keys.length == 0) {this.root = null; this.size = 0;}
        else {
            this.root = sortedArraysToBST(keys, vals, 0, keys.length - 1);
            this.size = keys.length;
        }
    }

    public BinarySearchTree(K[] preorder, K[] inorder, V[] values_preorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        this.values_preorder = values_preorder;
        if (preorder.length == 0) this.root = null;
        else this.root = buildTree(0, preorder.length - 1, 0, inorder.length - 1);
    }

    private Node buildTree(int pl, int pr, int il, int ir) {
        Node node = new Node(preorder[pl], values_preorder[pl]);
        if (pl == pr) return node;
        int index = indexOf(inorder, preorder[pl]);
        if (index > il){
            node.left = buildTree(pl + 1, pl + index - il, il, index - 1);
        }
        if (pl + index - il + 1 < pr + 1) {
            node.right = buildTree(pl + index - il + 1, pr, index + 1, ir);
        }
        return node;
    }

    private int indexOf(K[] keys, K k) {
        int i;
        for(i = 0; i < keys.length; i++) {
            if (keys[i].compareTo(k) == 0) return i;
        }
        return -1;
    }

    private Node sortedArraysToBST(K[] keys, V[] vals, int left, int right) {
        if (left == right) return new Node(keys[left], vals[left]);
        if (right - left == 1) {
            Node root = new Node(keys[right], vals[right]);
            root.left = new Node(keys[left], vals[right]);
            return root;
        }
        int med = (left + right + 1) / 2;
        Node root = new Node(keys[med], vals[med]);
        root.left = sortedArraysToBST(keys, vals, left, med - 1);
        root.right = sortedArraysToBST(keys, vals, med + 1, right);
        return root;
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

    /*
    public K kthSmallest(int k) {
        int count = 0;
        return kthSmallest(root, k);
    }


    private K kthSmallest(Node node, int k) {
        K t;
        if (node != null) {
            t = kthSmallest(node.left, k);
            if (t < K.MAX_VALUE) return t;
            if (++count == k) return node.key;
            t = kthSmallest(node.right, k);
            if (t < K.MAX_VALUE) return t;
        }
        return K.MAX_VALUE;
    }

     */

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

        Integer[] keys = {0,1,2,3,4,5,6};
        String[] vals = {"Matt", "Ryan", "Carpenter", "is", "an", "awesome", "coder."};
        Tree<Integer, String> bst2 = new BinarySearchTree(keys, vals);
    }
}
