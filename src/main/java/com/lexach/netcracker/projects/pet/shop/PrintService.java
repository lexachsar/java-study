package com.lexach.netcracker.projects.pet.shop;

import com.lexach.netcracker.projects.pet.shop.animals.AbstractAnimal;

import java.io.PrintStream;

public class PrintService {
    private static PrintService instance = null;

    private PrintStream StdOut;

    private PrintService() {
        this.StdOut = new PrintStream(System.out);
    }

    public static PrintService getInstance() {
        if (instance == null) {
            instance = new PrintService();
        }

        return instance;
    }

    //print animal
    //Перегружать функции или давать им всем разные имена?
    public AbstractAnimal print(AbstractAnimal animal) {
        return animal.print(this.StdOut);
    }

    public PetShopStorage print(PetShopStorage storage) {
        return storage.print(this.StdOut);
    }
}