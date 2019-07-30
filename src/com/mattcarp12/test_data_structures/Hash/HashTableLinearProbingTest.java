package com.mattcarp12.test_data_structures.Hash;

import com.mattcarp12.data_structures.HashTable.HashTableLinearProbing;


public class HashTableLinearProbingTest {
    public static void main(String[] args) {
        HashTableLinearProbing<String, Dog> hash = new HashTableLinearProbing<String, Dog>();
        hash.put("Rover", new Dog(20));
        hash.put("Sasha", new Dog(15));
        hash.put("Tucker", new Dog(25));
        hash.put("Riley", new Dog(25));
        hash.get("Rover").woof();
    }
}

class Dog {
    int weight;
    Dog(int weight) {
        this.weight = weight;
    }

    public void woof() {
        System.out.println("Woof!");
    }
}
