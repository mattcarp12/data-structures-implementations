package com.mattcarp12.data_structures;

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
    private int size = 0;
    private final int default_size = 4;

    public HashMap() {
        array = new LinkedList[default_size];
    }


    @Override
    public V put(K key, V value) {
        return null;
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

    }

    @Override
    public boolean contains(K key) {
        return !(array[hash(key)] == null);
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
