package com.mattcarp12.test_data_structures.Stack;

import com.mattcarp12.data_structures.Stack.ArrayStack;
import com.mattcarp12.data_structures.Stack.Stack;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestStack {

    @Test
    public void testArrayStack() {
        Stack<Integer> s = new ArrayStack<>();
        assertTrue(s.isEmpty());
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        assertFalse(s.isEmpty());
        System.out.println(s.peek());
    }

}
