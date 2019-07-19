package com.mattcarp12.test_data_structures.DisjointSet;

import com.mattcarp12.data_structures.DisjointSet.DisjointSet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDisjointSet {

    DisjointSet ds = new DisjointSet(10);

    @Test
    public void TestDisjointSetUnion() {
        ds.merge(0,1);
        ds.merge(2,1);
        ds.merge(9,8);
        ds.merge(5,8);
        ds.merge(2,5);
    }

    @Test
    public void TestDisjointSetFind() {
        for(int i = 0; i < 10; i++)
            System.out.println(ds.find(i));
    }
}
