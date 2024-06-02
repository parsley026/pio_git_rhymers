package edu.kis.vh.nursery;

import org.junit.Assert;
import org.junit.Test;

public class FIFORhymerJUnitTest {

    @Test
    public void testCountOut() {
        FIFORhymer fifoRhymer = new FIFORhymer();
        int testValue = 0;

        fifoRhymer.countIn(testValue);
        Assert.assertEquals(testValue, fifoRhymer.countOut());
    }

    @Test
    public void testCountOutMultipleValues() {
        FIFORhymer fifoRhymer = new FIFORhymer();
        int[] testValues = {1, 2, 3, 4};

        for (int value : testValues) {
            fifoRhymer.countIn(value);
        }

        for (int value : testValues) {
            Assert.assertEquals(value, fifoRhymer.countOut());
        }
    }

    @Test
    public void testCountOutWithEmpty() {
        FIFORhymer fifoRhymer = new FIFORhymer();

        Assert.assertEquals(-1, fifoRhymer.countOut());
    }

    @Test
    public void testCountInAndCountOutOrder() {
        FIFORhymer fifoRhymer = new FIFORhymer();
        fifoRhymer.countIn(1);
        fifoRhymer.countIn(2);
        fifoRhymer.countIn(3);

        Assert.assertEquals(1, fifoRhymer.countOut());
        Assert.assertEquals(2, fifoRhymer.countOut());
        Assert.assertEquals(3, fifoRhymer.countOut());
    }

    @Test
    public void testCountOutAfterReinsert() {
        FIFORhymer fifoRhymer = new FIFORhymer();
        int[] testValues = {1, 2, 3, 4};

        for (int value : testValues) {
            fifoRhymer.countIn(value);
        }

        Assert.assertEquals(1, fifoRhymer.countOut());

        fifoRhymer.countIn(5);

        Assert.assertEquals(2, fifoRhymer.countOut());
        Assert.assertEquals(3, fifoRhymer.countOut());
        Assert.assertEquals(4, fifoRhymer.countOut());
        Assert.assertEquals(5, fifoRhymer.countOut());
    }

    @Test
    public void testIsEmptyAfterCountOutAll() {
        FIFORhymer fifoRhymer = new FIFORhymer();
        int[] testValues = {1, 2, 3};

        for (int value : testValues) {
            fifoRhymer.countIn(value);
        }

        for (int value : testValues) {
            fifoRhymer.countOut();
        }

        // TODO: needs refactoring - 'assertEquals()' can be simplified to 'assertTrue()'
        Assert.assertEquals(true, fifoRhymer.callCheck());
    }
}
