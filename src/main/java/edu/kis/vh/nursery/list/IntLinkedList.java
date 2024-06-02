package edu.kis.vh.nursery.list;

/**
 * Represents a simple linked list of integers.
 */
public class IntLinkedList {

    /**
     * Constant indicating an empty list.
     */
    public static final int EMPTY = -1;

    private Node last;

    /**
     * Adds a new integer to the end of the list.
     *
     * @param i The integer to be added to the list.
     */
    public void push(int i) {
        if (last == null)
            last = new Node(i);
        else {
            last.next = new Node(i);
            last.next.prev = last;
            last = last.next;
        }
    }

    /**
     * Checks if the list is empty.
     *
     * @return True if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return last == null;
    }

    /**
     * Checks if the list is full.
     *
     * @return Always returns false, indicating that the list can grow indefinitely.
     */
    public boolean isFull() {
        return false;
    }

    /**
     * Retrieves the value of the last element in the list without removing it.
     *
     * @return The value of the last element in the list, or EMPTY if the list is empty.
     */
    public int top() {
        if (isEmpty())
            return EMPTY;
        return last.value;
    }

    /**
     * Removes and retrieves the value of the last element in the list.
     *
     * @return The value of the last element in the list, or EMPTY if the list is empty.
     */
    public int pop() {
        if (isEmpty())
            return EMPTY;
        final int ret = last.value;
        last = last.prev;
        return ret;
    }

    private static class Node {

        private final int value;
        private Node prev, next;

        private Node(int i) {
            value = i;
        }
    }
}
