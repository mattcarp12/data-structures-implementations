package com.mattcarp12.data_structures;

//@SuppressWarnings("unchecked")
public class HashMap<K, V> implements MapI<K, V> {

    private static class Pair<K, V> {
        K key;
        V value;
        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private ListI<Pair<K, V>>[] array = null;
    private int size;
    private final int default_size = 4;

    public HashMap() {
        array = new LinkedList[default_size];
        size = 0;
    }


    @Override
    public void put(K key, V value) {
        array[hash(key) % array.length].add(new Pair(key, value));
        size++;
        //return value;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public void clear() {
        this.array = new LinkedList[default_size];
    }

    @Override
    public boolean contains(K key) {
        return !(array[hash(key) % array.length] == null);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(K key) {
        return key.hashCode();
    }

    private void resize() {

    }
}
