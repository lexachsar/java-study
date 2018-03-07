package com.lexach.NetCracker.Reflection;

import com.lexach.NetCracker.Reflection.ReflectionHomework.MyFirstAnnotation;

public abstract class Shape {
    public void draw() {
        System.out.println(this);
    }


    @Override
    @MyFirstAnnotation(message = "Привет! Это моя первая собственная аннотация!", value = 100)
    public String toString() {
        return "Shape";
    }
}
