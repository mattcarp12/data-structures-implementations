package com.mattcarp12.data_structures;

import java.util.List;

public class GraphAdjacencyMatrix implements Graph {

    boolean[][] G;
    int V;
    int E;
    GraphAdjacencyMatrix(int V) {
        this.V = V;
        G = new boolean[V][V];
    }

    @Override
    public void addEdge(int i, int j) {
        G[i][j] = true;
    }

    @Override
    public void removeEdge(int i, int j) {

    }

    @Override
    public boolean hasEdge(int i, int j) {
        return false;
    }

    @Override
    public List outEdges(int i) {
        return null;
    }

    @Override
    public List inEdges(int i) {
        return null;
    }
}
