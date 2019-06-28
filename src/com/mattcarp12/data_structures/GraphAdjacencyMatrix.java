package com.mattcarp12.data_structures;

import java.util.ArrayList;
import java.util.List;

public class GraphAdjacencyMatrix implements Graph {

    boolean[][] G;
    int V;
    int E;
    public GraphAdjacencyMatrix(int V) {
        this.V = V;
        G = new boolean[V][V];
    }

    @Override
    public void addEdge(int i, int j) {
        G[i][j] = true;
    }

    @Override
    public void removeEdge(int i, int j) {
        G[i][j] = false;
    }

    @Override
    public boolean hasEdge(int i, int j) {
        return G[i][j];
    }

    @Override
    public List outEdges(int i) {
        List e = new ArrayList();
        for (int j = 0; j < G[i].length; j++)
            if (G[i][j]) e.add(j);
        return e;
    }

    @Override
    public List inEdges(int i) {
        List e = new ArrayList();
        for (int j = 0; j < G[i].length; j++)
            if (G[j][i]) e.add(j);
        return e;
    }
}
