package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {

    private static final int ARRAY_SIZE = 12;
    private static final int TOTAL = -1;

    private final int[] numbers = new int[ARRAY_SIZE];

    public int getTotal() {
        return total;
    }

    private int total = TOTAL;

    private static final int FULL = 11;

    protected void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    protected boolean callCheck() {
        return total == TOTAL;
    }

    protected boolean isFull() {
        return total == FULL;
    }

    protected int peekaboo() {
        if (callCheck())
            return TOTAL;
        return numbers[total];
    }

    protected int countOut() {
        if (callCheck())
            return TOTAL;
        return numbers[total--];
    }

}
