package edu.kis.vh.nursery;

public class FIFORhymer extends DefaultCountingOutRhymer {

    // TODO: needs refactoring - 'temp' can be 'final'
    private DefaultCountingOutRhymer temp = new DefaultCountingOutRhymer();

    @Override
    protected int countOut() {
        while (!callCheck())
            temp.countIn(super.countOut());

        final int ret = temp.countOut();

        while (!temp.callCheck())
            countIn(temp.countOut());

        return ret;
    }
}
