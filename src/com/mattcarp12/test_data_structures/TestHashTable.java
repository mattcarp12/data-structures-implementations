package com.mattcarp12.test_data_structures;

import com.mattcarp12.data_structures.HashTable;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestHashTable {

    @Test
    public void TestHashTableFunctions() {
        HashTable<String, String> test = new HashTable();
        test.put("Foo", "Bar");
        test.put("Word", "Association");
        test.put("Key", "Value");
        test.put("I Love", "Melania");

        assertTrue(test.contains("Foo"));
        assertFalse(test.contains("Bar"));

        String test_get = test.get("Foo");
    }

}
