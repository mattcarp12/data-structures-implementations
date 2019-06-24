package com.mattcarp12.data_structures;

public interface ListI<T> {

    /**
     * Add a node with item x to
     * the back of the queue,
     * i.e. this becomes the tail.
     * @param x
     */
    void add(T x);

    /**
     * Add a node with item x to
     * the front of the queue,
     * i.e. this becomes the head.
     * @param x
     */
    void push(T x);

    /**
     * Remove an item from front of
     * the list. Identical to pop();
     * @return the item at front of list
     */
    T remove();

    /**
     * Identical to remove()
     * @return
     */
    T pop();


}
