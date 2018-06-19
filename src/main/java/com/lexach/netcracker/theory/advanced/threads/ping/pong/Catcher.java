package com.lexach.netcracker.theory.advanced.threads.ping.pong;

import java.io.IOException;

public class Catcher implements Runnable{
    @Override
    public void run() {
        try {
            Main.pis.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
