package com.lexach.netcracker.threads.ping.pong;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Main {

    public static PipedInputStream pis = new PipedInputStream();
    public static PipedOutputStream pos = new PipedOutputStream();

    public static void main(String[] args) throws IOException {

        pis.connect(pos);

        Producer prod = new Producer();
        Catcher catc = new Catcher();

        prod.run();
        catc.run();
    }
}