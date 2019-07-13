package com.mattcarp12.test_data_structures.Graph;

import com.mattcarp12.data_structures.Graph.DigraphAdjList;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestDigraphHasCycle {

    @Test
    public void testHasCycle() {
        DigraphAdjList G = new DigraphAdjList(1);
        G.addEdge(0,0);
        assertTrue(G.hasCycle());

        G = new DigraphAdjList(4);
        G.addEdge(0,1);
        G.addEdge(1,2);
        G.addEdge(2,3);
        G.addEdge(3,0);
        assertTrue(G.hasCycle());

        G = new DigraphAdjList(1);
        assertFalse(G.hasCycle());

        G = new DigraphAdjList(2);
        G.addEdge(0,1);
        assertFalse(G.hasCycle());

        G = new DigraphAdjList(4);
        G.addEdge(0,1);
        G.addEdge(0,2);
        G.addEdge(1,2);
        G.addEdge(1,3);
        G.addEdge(2,3);
        assertFalse(G.hasCycle());

    }
}
