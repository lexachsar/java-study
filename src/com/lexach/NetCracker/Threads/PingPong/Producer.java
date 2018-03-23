package com.lexach.NetCracker.Threads.PingPong;

import java.io.IOException;

public class Producer implements Runnable {
    @Override
    public void run() {
        byte i = 0;
        while(true) {
            try {
                Main.pos.write((byte)i);
                Main.pos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
