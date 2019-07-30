package com.mattcarp12.data_structures.HashTable;

import java.util.ArrayList;
import java.util.List;

public class HashTableLinearProbing<K,V> {
    public List<Pair<K,V>> hashtable;
    final int INITIAL_CAPACITY = 10;
    int fill;
    public HashTableLinearProbing() {
        hashtable = new ArrayList<Pair<K,V>>();
        for (int i = 0; i < INITIAL_CAPACITY; i++)
            hashtable.add(null);
        fill = 0;
    }

    public void put(K key, V val) {
        if ((float)fill / hashtable.size() > 0.7)
            resize();

        int index = index(key);

        while (hashtable.get(index) != null)
            index = (index + 1) % hashtable.size();

        hashtable.set(index, new Pair(key, val));
    }

    public V get(K key) {
        int index = index(key);
        if (hashtable.get(index) == null) return null;
        while (!hashtable.get(index).equals(new Pair(key, null)))
            index = (index + 1) % hashtable.size();
        return hashtable.get(index).val;
    }

    public int index(K key) {
        return (key.hashCode() & 0x7FFFFFFF) % hashtable.size();
    }

    private void resize() {

    }

}

class Pair<K,V> {
    K key;
    V val;
    Pair(K key, V val) {
        this.key = key;
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Pair) {
            Pair p = (Pair) o;
            return this.key.equals(p.key);
        }
        return false;
    }
}
