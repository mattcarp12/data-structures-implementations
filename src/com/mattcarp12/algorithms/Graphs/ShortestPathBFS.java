package com.mattcarp12.algorithms.Graphs;

import com.mattcarp12.data_structures.Graph.DigraphAdjList;
import com.mattcarp12.data_structures.Graph.Graph;
import com.mattcarp12.data_structures.Queue.ListQueue;
import com.mattcarp12.data_structures.Queue.Queue;

import java.util.ArrayList;

public class ShortestPathBFS {

    public static void shortestPath(DigraphAdjList G, int s, int w) {
        boolean[] visited = new boolean[G.numVerticies()];
        int[] prev = new int[G.numVerticies()];
        for (int i = 0; i < prev.length; i++) prev[i] = -1;
        Queue<Integer> queue = new ListQueue<Integer>();
        queue.enqueue(s);
        visited[s] = true;
        int v;

        while(!queue.isEmpty()) {
            v = queue.dequeue();
            for(Integer u : G.adjVerticies(v)) {
                if (!visited[u]) {
                    visited[u] = true;
                    prev[u] = v;
                    queue.enqueue(u);
                }
            }
        }
        int counter = 0;
        ArrayList<Integer> path = new ArrayList<Integer>();
        v = w;
        while (v != -1) {
            path.add(v);
            v = prev[v];
            counter++;
        }
        System.out.print("The shortest path from node " + s + " to node " + w + " is: ");
        while (!path.isEmpty()) {
            System.out.print(path.remove(path.size() - 1) + " ");
        }
        System.out.print(", with length " + counter + ".");
    }

    public static void main(String[] args) {
        DigraphAdjList G = new DigraphAdjList(4);
        G.addEdge(0,1);
        G.addEdge(1,2);
        G.addEdge(2,3);
        G.addEdge(0,2);
        G.addEdge(1,3);
        shortestPath(G, 0, 3);
    }

}
