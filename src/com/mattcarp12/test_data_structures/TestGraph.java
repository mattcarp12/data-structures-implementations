package com.mattcarp12.test_data_structures;

import com.mattcarp12.data_structures.Graph.Graph;
import com.mattcarp12.data_structures.Graph.GraphAdjacencyMatrix;
import org.junit.Test;

public class TestGraph {

    static Graph G = new GraphAdjacencyMatrix(10);

    @Test
    public void testAddEdge(){
        G.addEdge(0,1);
        G.addEdge(1,2);
    }

}
