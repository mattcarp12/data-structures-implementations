package com.mattcarp12.data_structures.Tree;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Trie {

    HashMap<Character, Trie> node;
    boolean isWord;

    public Trie() {
        node = new HashMap<Character, Trie>();
        isWord = false;
    }

    public void insert(String s) {
        Trie t = this;
        for (Character c : s.toCharArray()) {
            if (!t.node.containsKey(c)) {
                t.node.put(c, new Trie());
            }
            t = t.node.get(c);
        }
        t.isWord = true;
    }

    public boolean search(String s) {
        Trie t = this;
        for (Character c: s.toCharArray()) {
            if (!t.node.containsKey(c)) return false;
            t = t.node.get(c);
        }
        return t.isWord;
    }

    public boolean startsWith(String s) {
        Trie t = this;
        for (Character c: s.toCharArray()) {
            if (!t.node.containsKey(c)) return false;
            t = t.node.get(c);
        }
        return true;
    }

    @Test
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("foo");
        trie.insert("bar");
        trie.insert("nuts");
        assertTrue(trie.search("foo"));
        assertFalse(trie.search("apple"));
        assertTrue(trie.startsWith("nu"));

    }


}
