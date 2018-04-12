package com.lexach.netcracker.generics;

import java.util.ArrayList;

public class Bucket <T> {
    private ArrayList<Apple> myApples;
    private ArrayList<Coconut> myCoconuts;
    private ArrayList<Orange> myOranges;

    Bucket(ArrayList<T> trashBucket) {
        myApples = new ArrayList<Apple>();
        myOranges = new ArrayList<Orange>();
        myCoconuts = new ArrayList<Coconut>();

        for (T trash: trashBucket) {
            switch (trash.getClass().getSimpleName()){
                case "Apple":
                    myApples.add((Apple)trash);
                    break;
                case "Orange":
                    myOranges.add((Orange)trash);
                    break;
                case "Coconut":
                    myCoconuts.add((Coconut)trash);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * @return Array list of apples
     */
    public ArrayList<Apple> getMyApples() {
        return myApples;
    }

    /**
     * @return Array list of oranges
     */
    public ArrayList<Orange> getMyOranges() {
        return myOranges;
    }

    /**
     * @return Array list of coconuts
     */
    public ArrayList<Coconut> getMyCoconuts() {
        return myCoconuts;
    }

    private void printApples() {
        System.out.println("My apples:");
            for (Apple apple : this.myApples) {
                apple.print();
            }
    }

    private void printCoconuts() {
        System.out.println("My coconuts:");
        for (Coconut coconut : this.myCoconuts) {
            coconut.print();
        }
    }

    private void printOranges() {
        System.out.println("My oranges:");
        for (Orange orange : this.myOranges) {
            orange.print();
        }
    }

    public void print() {
        System.out.println("My bucket: \n");

        printApples();
        printOranges();
        printCoconuts();
    }
}
