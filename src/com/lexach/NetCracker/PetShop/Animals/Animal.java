package com.lexach.NetCracker.PetShop.Animals;

import java.io.PrintStream;
import java.util.HashSet;

public interface Animal {
    String getBreed();

    String getName();

    Integer getCost();

    HashSet<String> getCharacter();

    String printBreed(PrintStream StdOut);

    String printName(PrintStream StdOut);

    Integer printCost(PrintStream StdOut);

    HashSet<String> printCharacter(PrintStream StdOut);

    Animal print(PrintStream StdOut);
}