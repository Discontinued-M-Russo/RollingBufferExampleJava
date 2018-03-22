package com.mr.core.example;

/**
 * Simple Buffer interface for doubles-
 * Every buffer must get current size, insert an element
 *
 * Created by 105051313 on 3/20/18.
 */
public interface IDoubleBuffer {

    int getCurrentSize();

    void insertBufElement(double bufElem);
}
