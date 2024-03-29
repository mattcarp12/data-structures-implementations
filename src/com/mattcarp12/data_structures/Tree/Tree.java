package com.mattcarp12.data_structures.Tree;

import java.util.Iterator;

public interface Tree<K, V> {

    void put(K key, V value);

    V get(K key);

    boolean contains(K key);

    void delete(K key);

    int size();

    boolean isEmpty();

    V floor(K key);

    V ceil(K key);

    void invertTree();

    Iterator keys(TraversalType type);

    int height();
}

enum TraversalType {
    INORDER, PREORDER, POSTORDER, LEVELORDER
}