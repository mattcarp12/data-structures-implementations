package com.mattcarp12.data_structures.Graph;

import java.util.HashSet;
import java.util.Set;

public class DigraphAdjList {

    private final int V;           // number of vertices in this digraph
    private int E;                 // number of edges in this digraph
    private Set<Integer>[] adj;    // adj[v] = adjacency list for vertex v
    private int[] indegree;        // indegree[v] = indegree of vertex v

    public DigraphAdjList(int V) {
        if (V < 0) throw new IllegalArgumentException("Graph must have nonnegative number of verticies.");
        this.V = V;
        this.E = 0;
        this.indegree = new int[V];
        adj = (Set<Integer>[]) new HashSet[V];
        for (int v = 0; v < V; v++)
            adj[v] = new HashSet<Integer>();
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        indegree[w]++;
        E++;
    }

    public boolean hasCycle() {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        for(int v = 0; v < V; v++) {
            if(!visited[v] && hasCycleDFS(visited,recStack,v))
                 return true;
        }
        return false;
    }

    private boolean hasCycleDFS(boolean[] visited, boolean[] recStack, int v) {
        if (visited[v]) return false;
        visited[v] = true;
        if (recStack[v]) return true;
        recStack[v] = true;
        for(int child : adj[v])
            if(hasCycleDFS(visited, recStack, child)) return true;
        recStack[v] = false;
        return false;
    }
}
