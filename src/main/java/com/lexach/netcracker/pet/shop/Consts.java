package com.lexach.netcracker.pet.shop;

import java.io.PrintStream;
import java.util.Scanner;

public interface Consts {
    static Boolean yesNo(Scanner scanner, PrintStream StdOut) {
        while (true) {

            char answer = scanner.nextLine().charAt(0);

            switch (answer) {
                case yes:
                    return true;
                case no:
                    return false;
                default:
                    StdOut.println("Specified input is incorrect.");
            }
        }
    }

    public static final char yes = 'y';
    public static final char no = 'n';

    public static final String petConst = "Домашний";
    public static final String predatorConst = "Хищник";
}
