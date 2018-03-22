package com.mr.core.example;

import java.util.Vector;

/**
 * Implementation of IDoubleBuffer interface, extended to include an average calculation
 *
 * Created by 105051313 on 3/20/18.
 */
public class ModifiedDoubleBuffer
        implements IDoubleBuffer {

    Vector<Double> rolBuffer = new Vector<Double>();

    // Iterator index when rolling
    int bufIndex = 0;

    // Maximum buffer size
    int maxBufSize;

    // constructor
    public ModifiedDoubleBuffer(int rolBufSize) {
        maxBufSize = rolBufSize;
    }

    // Implementation of getCurrentSize
    public int getCurrentSize() {
        return rolBuffer.size();
    }

    // Implementation of insertBufElement
    public void insertBufElement(double bufElem) {

        if (rolBuffer.size() < maxBufSize) {
            // vector yet to be filled - keep adding
            rolBuffer.addElement(bufElem);
        }
        else{
            // vector filled - implement the rolling buffer
            // reset iterator every time max cap is reached
            if (bufIndex == maxBufSize) bufIndex = 0;

            // just insert and increment
            rolBuffer.setElementAt(bufElem, bufIndex);
            bufIndex++;
        }
    }

    // Calculate Average
    public double calcBufAverage() {
        double sum = 0.0;

        for (int i=0; i<rolBuffer.size(); i++)
            sum=sum + rolBuffer.get(i);

        return (sum/rolBuffer.size());
    }

}
