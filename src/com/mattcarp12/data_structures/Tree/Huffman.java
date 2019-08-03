package com.mattcarp12.data_structures.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

class Node {
    int freq;
    char ch;
    Node left = null, right = null;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }

    Node(int freq, Node left, Node right) {
        this.freq = freq;
        this.left = left;
        this.right = right;
    }


}

public class Huffman {

    private Node huffTree;
    private Map<Character, String> huffMap = new HashMap<>();
    private String unencoded;
    private String encoded;

    public Huffman () { }

    private void buildHuffmanTree(String text) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            if (!freqMap.containsKey(c)){
                freqMap.put(c, 0);
            }
            freqMap.put(c, freqMap.get(c) + 1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((l,r) -> l.freq - r.freq);

        for (Character c : freqMap.keySet()) {
            pq.add(new Node(c, freqMap.get(c)));
        }

        while (pq.size() != 1) {
            Node n1 = pq.poll();
            Node n2 = pq.poll();
            pq.add(new Node(n1.freq + n2.freq, n1, n2));
        }

        this.huffTree = pq.poll();
    }

    private void buildHuffmanMap() {
        Stack<Node> stack = new Stack<>();
        Node curr = huffTree;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }else {
                curr = stack.pop();
                curr = curr.right;
            }

        }
    }

    public void encode(String text) {
        if (huffTree == null) buildHuffmanTree(text);
        if (huffMap == null) buildHuffmanMap();
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            sb.append(huffMap.get(c));
        }
    }



}
