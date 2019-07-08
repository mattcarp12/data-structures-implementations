package com.mattcarp12.data_structures.List;

public interface ListI<T> {

    /**
     * Add a node with item x to
     * the back of the queue,
     * i.e. this becomes the tail.
     * @param x
     */
    void add(T x);

    /**
     * Remove an item from the linked list
     * if data is equal to x
     * @param x
     */
    void remove(T x);

}
