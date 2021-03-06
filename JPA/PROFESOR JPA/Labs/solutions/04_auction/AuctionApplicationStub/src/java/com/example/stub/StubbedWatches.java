package com.example.stub;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author tmcginn
 */
public class StubbedWatches
{
    private static CopyOnWriteArrayList<Watch> watches;
    private static final StubbedWatches instance = new StubbedWatches();

    private StubbedWatches()
    {
        watches = new CopyOnWriteArrayList<>();
    }

    public static CopyOnWriteArrayList<Watch> getWatches()
    {
        return watches;
    }
}
