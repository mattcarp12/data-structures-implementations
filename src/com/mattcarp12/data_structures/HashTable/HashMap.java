package com.mattcarp12.data_structures.HashTable;

import com.mattcarp12.data_structures.List.LinkedList;

//@SuppressWarnings("unchecked")
public class HashMap<K, V> implements MapI<K, V> {

    private class Pair {
        K key;
        V value;
        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            Pair p = (Pair) o;
            if (hash(key) != hash(p.key)) return false;
            return key.equals(p.key);
        }
    }

    private LinkedList<Pair>[] array = null;
    private int size, capacity;
    private final int default_capacity = 4;

    public HashMap() {
        array = new LinkedList[default_capacity];
        size = 0;
        capacity = default_capacity;
    }


    @Override
    public void put(K key, V value) {
        if (array[hash(key)] == null) array[hash(key)] = new LinkedList();
        array[hash(key)].add(new Pair(key, value));
        size++;
        resize();
    }

    @Override
    public V get(K key) {
        if (array[hash(key)] == null) return null;  //Throw an exception
        else {
            LinkedList<Pair> t = array[hash(key)];
            if (t.find(new Pair(key, null)) == null) return null;
            else {
                Pair p = (Pair) t.find(new Pair(key, null)).x;
                return p.value;
            }

        }
    }

    @Override
    public void remove(K key) {
        array[hash(key)].remove(new Pair(key, null));
        size--;
        resize();
    }

    @Override
    public void clear() {
        this.array = new LinkedList[default_capacity];
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
        return (key.hashCode() & 0x7FFFFFFF) % capacity ;
    }

    private void resize() {
        if (size / capacity > 10) capacity *= 2;
        else if (size / capacity < 2 && capacity > default_capacity) capacity /= 2;
        else return;
        capacity *= 2;
        LinkedList<Pair>[] temp = new LinkedList[capacity];
        for (int i = 0; i < array.length; i++) {
            while(array[i].head.next != null) {
                Pair t = (Pair) array[i].head.next.x;
                temp[hash(t.key)].add(t);
                array[i].remove(t);
            }
        }
        array = temp;
    }
}
