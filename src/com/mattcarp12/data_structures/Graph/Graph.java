package com.mattcarp12.data_structures.Graph;

import java.util.List;

public interface Graph {
    void addEdge(int i, int j);
    void removeEdge(int i, int j);
    boolean hasEdge(int i, int j);
    List outEdges(int i);
    List inEdges(int i);
    int numVerticies();

}
