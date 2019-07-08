package com.mattcarp12.data_structures.HashTable;

public interface MapI<K, V> {

    public void put(K key, V value);

    public V get(K key);

    public void remove(K key);

    public void clear();

    public boolean contains(K key);

    public int size();

    public boolean isEmpty();

    //public K[] keys();

}
