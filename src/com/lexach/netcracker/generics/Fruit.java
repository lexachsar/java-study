package com.lexach.netcracker.generics;

public class Fruit {
    protected String name;

    Fruit() {
        this.name = "Fruit";
    }

    Fruit(String name) {
        this.name = name;
    }

    public String getName () {
       return this.name;
    }

    public void print() {
        System.out.println(name);
    }
}
