package com.mattcarp12.test_data_structures.Queue;

import com.mattcarp12.data_structures.Queue.ListQueue;
import com.mattcarp12.data_structures.Queue.Queue;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestQueue {

    @Test
    public void testListQueue() {
        Queue<Integer> q = new ListQueue<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(10);
        q.dequeue();
        assertEquals(q.peekFront(),(Integer) 2);
        assertEquals(q.peekRear(),(Integer) 10);
        assertEquals(q.size(), 4);

    }
}
