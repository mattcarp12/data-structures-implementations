package com.mattcarp12.test_data_structures;

import com.mattcarp12.data_structures.HashTable.HashMap;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestHashMap {

    @Test
    public void TestHashMapFunctions() {
        HashMap<String, String> test = new HashMap();
        test.put("Foo", "Bar");
        test.put("Word", "Association");
        test.put("Key", "Value");
        test.put("I Love", "Melania");

        assertTrue(test.contains("Foo"));
        assertFalse(test.contains("Bar"));

        String test_get = test.get("Foo");
    }

}
