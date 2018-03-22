package com.mr.core.example;


import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;

/**
 * Unit test for simple Example.
 */
public class ExampleTest
    //extends TestCase
{


    /**
     * Test Constructor
     */
    @Test
    public void testConstruct()
    {
        ModifiedDoubleBuffer testModBuf = new ModifiedDoubleBuffer(1);

        assertTrue(testModBuf.maxBufSize == 1);
    }

    /**
     * Test Growth
     */
    @Test
    public void testSizeGrowth()
    {
        ModifiedDoubleBuffer testModBuf = new ModifiedDoubleBuffer(2);

        assertTrue(testModBuf.getCurrentSize() == 0);

        double dataIn1 = 9.9;

        testModBuf.insertBufElement(dataIn1);

        assertTrue(testModBuf.getCurrentSize() == 1);

        testModBuf.insertBufElement(dataIn1);

        assertTrue(testModBuf.getCurrentSize() == 2);
    }

    /**
     * Test Rolling
     */
    @Test
    public void testRollingBuf()
    {
        ModifiedDoubleBuffer testModBuf = new ModifiedDoubleBuffer(2);

        double dataIn1 = 9.9;
        double dataIn2 = 2.2;


        testModBuf.insertBufElement(dataIn1);
        testModBuf.insertBufElement(dataIn1);

        assertTrue(testModBuf.getCurrentSize() == 2);

        testModBuf.insertBufElement(dataIn2);

        assertTrue(testModBuf.getCurrentSize() == 2);

    }

    /**
     * Test Average
     */
    @Test
    public void testAverage()
    {
        ModifiedDoubleBuffer testModBuf = new ModifiedDoubleBuffer(2);

        Random rnd = new Random();

        double dataIn1 = rnd.nextDouble();

        testModBuf.insertBufElement(dataIn1);

        // buf = [dataIn1]
        assertEquals(testModBuf.calcBufAverage(),dataIn1, 1e-9);

        double dataIn2 = rnd.nextDouble();

        // buf = [dataIn1 dataIn2]
        testModBuf.insertBufElement(dataIn2);

        assertEquals(testModBuf.calcBufAverage(),((dataIn1 + dataIn2)/2),1e-9);

        double dataIn3 = rnd.nextDouble();

        // buf = [dataIn3 dataIn2]
        testModBuf.insertBufElement(dataIn3);

        assertEquals(testModBuf.calcBufAverage(),((dataIn3 + dataIn2)/2),1e-9);
    }
}
