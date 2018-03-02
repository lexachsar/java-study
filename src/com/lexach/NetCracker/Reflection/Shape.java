package com.lexach.NetCracker.Reflection;

public abstract class Shape {
    public void draw() {
        System.out.println(this);
    }

    public String toString() {
        return "Shape";
    }
}
