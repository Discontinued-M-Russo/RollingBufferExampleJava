package com.mr.core.example;

import java.util.Random;
import org.apache.log4j.Logger;

/**
 * Sample example of a rolling buffer
 *
 */
public class Example
{
    private static final Logger logger = Logger.getLogger(Example.class);

    public static void main( String[] args )
    {
        // Max actual capacity
        int max_cap = 10;

        // Random numbergenerator
        Random rnd = new Random();
        double randomElement;
        double average;

        ModifiedDoubleBuffer rollBuff = new ModifiedDoubleBuffer(max_cap);

        for (int i = 0; i<21; i++){

            randomElement = rnd.nextDouble()*100;
            logger.info("Next element = " +randomElement);

            rollBuff.insertBufElement(randomElement);

            average = rollBuff.calcBufAverage();
            logger.info("Average = " +average);
        }
    }
}
