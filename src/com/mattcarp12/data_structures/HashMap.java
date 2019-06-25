package com.mattcarp12.data_structures;

//@SuppressWarnings("unchecked")
public class HashMap<K, V> implements MapI<K, V> {

    private class Pair {
        K key;
        V value;
        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        boolean equals(Pair p) {
            if (hash(key) != hash(p.key)) return false;
            return key.equals(p.key);
        }
    }

    private LinkedList<Pair>[] array = null;
    private int size;
    private final int default_size = 4;

    public HashMap() {
        array = new LinkedList[default_size];
        size = 0;
    }


    @Override
    public void put(K key, V value) {
        array[hash(key)].add(new Pair(key, value));
        size++;
    }

    @Override
    public V get(K key) {
        if (array[hash(key)] == null) return null;  //Throw an exception
        else {
            LinkedList<Pair> t = array[hash(key)];
            t.find(new Pair(key, null));
        }


    }

    @Override
    public void remove(K key) {
        //return null;
    }

    @Override
    public void clear() {
        this.array = new LinkedList[default_size];
    }

    @Override
    public boolean contains(K key) {
        return get(key) != null;
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
        return (key.hashCode() & 0x7FFFFFFF) % array.length ;
    }

    private void resize() {

    }
}
