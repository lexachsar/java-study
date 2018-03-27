package com.lexach.netcracker.threads;

import java.util.concurrent.Callable;

public class MyTaskWithResult implements Callable<String> {
    private static int count = 0;
    private int id = count++;

    @Override
    public String call() throws Exception {
        return "Result=" + id;
    }
}
