package com.mattcarp12.test_data_structures.Tree;
import com.mattcarp12.data_structures.Tree.BinarySearchTree;
import com.mattcarp12.data_structures.Tree.Tree;
import org.junit.Test;

public class TestBST {

    //@Test
    public static void TestBSTPut(Tree bst) {

        bst.put(10, "Hello");
        bst.put(20, "World!");
        bst.put(5, "FooBar");
        bst.put(20,"Good night.");

    }

    @Test
    public static void main(String[] args) {
        Tree<Integer, String> bst = new BinarySearchTree();
        TestBSTPut(bst);
    }


}
