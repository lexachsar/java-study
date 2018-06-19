package com.lexach.netcracker.theory.basics.instructions;

public class Main {

    public static void main(String[] args) {

        // Instruction continue with label.
        outer: for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j > i) {
                    System.out.println("\n");
                    continue outer;
                }
                System.out.println(" " + (i * j));
            }
        }
        System.out.println("\n");

    }

}
