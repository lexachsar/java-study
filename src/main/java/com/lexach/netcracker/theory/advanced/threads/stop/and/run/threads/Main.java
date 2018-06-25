package com.lexach.netcracker.theory.advanced.threads.stop.and.run.threads;

public class Main {

    public static void main(String[] args) {

        Runnable r = new Threada("AAAAAAAAAAAAAAAAAAAAAAAAAA");
        Thread t = new Thread(r);

        t.setDaemon(true);

        t.start();

        Runnable r2 = new Threada("aaaaaaaaaaaaaaaaaaaaaaaaaaa");
        Thread t2 = new Thread(r2);

        t2.start();


    }

}
