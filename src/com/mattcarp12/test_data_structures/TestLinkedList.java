package com.mattcarp12.test_data_structures;

import com.mattcarp12.data_structures.List.LinkedList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestLinkedList {

    @Test
    public void TestLinkedListFunctions() {
        LinkedList<Integer> t = new LinkedList<>();
        t.add(5);
        t.add(10);
        t.add(2);
        t.add(20);
        t.add(7);

        LinkedList.Node temp_node = t.find(5);
        temp_node = t.find(2);
        temp_node = t.find(7);

        t.remove(5);
        t.remove(2);
        t.remove(7);

    }
}
