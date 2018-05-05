package com.lexach.netcracker.spring.ripper.quoters;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.awt.windows.ThemeReader;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        while (true) {
            Thread.sleep(1000);

            context.getBean(Quoter.class).sayQuote();
        }
    }
}