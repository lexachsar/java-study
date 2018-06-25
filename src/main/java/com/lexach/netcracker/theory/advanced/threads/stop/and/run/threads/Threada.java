package com.lexach.netcracker.theory.advanced.threads.stop.and.run.threads;

public class Threada implements Runnable {

    String str;

    public Threada(String str) {
        this.str = str;
    }

    @Override
    public void run() {
        while(true) {
            System.out.println(this.str);
        }
    }
}
