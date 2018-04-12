package com.lexach.netcracker.spring.ripper.quoters;

public class TerminatorQuoter implements Quoter {

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public void sayQuote() {
        System.out.println("Message:" + this.message);
    }

}

