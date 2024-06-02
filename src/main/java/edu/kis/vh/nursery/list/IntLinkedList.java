package edu.kis.vh.nursery.list;

public class IntLinkedList {
    public static final int EMPTY = -1;
    private Node last;
    private int i;

    public void push(int i) {
        if (last == null)
            last = new Node(i);
        else {
            last.next = new Node(i);
            last.next.prev = last;
            last = last.next;
        }
    }

    public boolean isEmpty() {
        return last == null;
    }

    public boolean isFull() {
        return false;
    }

    public int top() {
        if (isEmpty())
            return EMPTY;
        return last.value;
    }

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
