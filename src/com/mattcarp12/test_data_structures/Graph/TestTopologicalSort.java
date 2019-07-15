package com.mattcarp12.test_data_structures.Graph;

import org.junit.Test;
import com.mattcarp12.data_structures.Graph.DigraphAdjList;

public class TestTopologicalSort {

    @Test
    public void testTopoSort() {
        DigraphAdjList G = new DigraphAdjList(6);
        G.addEdge(2,3);
        G.addEdge(3,1);
        G.addEdge(4,0);
        G.addEdge(4,1);
        G.addEdge(5,0);
        G.addEdge(5,2);
        for (int i : G.topologicalSort()) System.out.print(i + " ");
    }
}
