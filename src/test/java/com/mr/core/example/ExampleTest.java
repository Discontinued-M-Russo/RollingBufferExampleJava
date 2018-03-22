package com.mr.core.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Random;

/**
 * Unit test for simple Example.
 */
public class ExampleTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ExampleTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ExampleTest.class );
    }

    /**
     * Test Constructor
     */
    public void testConstruct()
    {
        ModifiedDoubleBuffer testModBuf = new ModifiedDoubleBuffer(1);

        assertTrue(testModBuf.maxBufSize == 1);
    }

    /**
     * Test Growth
     */
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
    public void testAverage()
    {
        ModifiedDoubleBuffer testModBuf = new ModifiedDoubleBuffer(2);

        Random rnd = new Random();

        double dataIn1 = rnd.nextDouble();

        testModBuf.insertBufElement(dataIn1);

        // buf = [dataIn1]
        assertTrue(testModBuf.calcBufAverage() == dataIn1);

        double dataIn2 = rnd.nextDouble();

        // buf = [dataIn1 dataIn2]
        testModBuf.insertBufElement(dataIn2);

        assertTrue(testModBuf.calcBufAverage() == ((dataIn1 + dataIn2)/2));

        double dataIn3 = rnd.nextDouble();

        // buf = [dataIn3 dataIn2]
        testModBuf.insertBufElement(dataIn3);

        assertTrue(testModBuf.calcBufAverage() == ((dataIn3 + dataIn2)/2));

    }
}
