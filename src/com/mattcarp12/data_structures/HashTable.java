package com.mattcarp12.data_structures;

import java.util.LinkedList;

public class HashTable<K, V> {

    class Pair {
        K key;
        V val;
        Pair(K key, V val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            Pair p = (Pair) o;
            if (hash(this.key) != hash(p.key)) return false;
            return this.key.equals(p.key);
        }
    }

    private LinkedList<Pair>[] array;
    private int capacity, size;
    private final int default_capacity = 4;


    public HashTable() {
        this.array = new LinkedList[default_capacity];
        this.size = 0;
        this.capacity = default_capacity;
    }


    public void put(K key, V value) {
        if (array[hash(key)] == null) array[hash(key)] = new LinkedList();
        array[hash(key)].add(new Pair(key, value));
        size++;
        resize();
    }

    public V get(K key) {
        if (array[hash(key)] == null) return null;
        else {
            LinkedList<Pair> t = array[hash(key)];
            int index = t.indexOf(new Pair(key, null));
            if (index == -1) return null;
            else {
                return t.get(index).val;
            }
        }
    }

    public void remove(K key) {
        array[hash(key)].remove(new Pair(key, null));
        size--;
        resize();
    }

    public void clear() {
        this.array = new LinkedList[default_capacity];
    }

    public boolean contains(K key) {
        return get(key) != null;
    }

    public int size() {
        return this.size;
    }

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
            while(array[i].size() != 0) {
                Pair t = array[i].remove();
                temp[hash(t.key)].add(t);
            }
        }
        array = temp;
    }



}
