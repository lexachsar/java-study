package com.lexach.NetCracker.PetShop;

import com.lexach.NetCracker.PetShop.Animals.*;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class UserInterface {
    public static PetShopStorage storage = PetShopStorage.getInstance();

    public static BuyAndSellService serviceBS = BuyAndSellService.getInstance();
    public static PrintService servicePrint = PrintService.getInstance();
    public static SearchService serviceSearch = SearchService.getInstance();

    public static PrintStream StdOut = new PrintStream(System.out);
    public static Scanner scanner = new Scanner(System.in);

    private static AbstractAnimal createAnimal(Scanner scanner) {
        System.out.println("Input number to create: ");
        System.out.println("1) A dog;");
        System.out.println("2) A cat;");
        System.out.println("3) A crocodile;");
        System.out.println("4) A tiger;");
        Integer code = scanner.nextInt();
        scanner.nextLine();

        switch (code) {
            case 1:
                return new Dog();
            case 2:
                return new Cat();
            case 3:
                return new Crocodile();
            case 4:
                return new Tiger();
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        Thread realLifeEmulator = new RealLifeEmulator();
        realLifeEmulator.start();
        System.out.println("Real life emulator is started.");

        while (true) {
            System.out.println("Input number to:");
            System.out.println("1) Print pet shop storage;");
            System.out.println("2) Find animal;");
            System.out.println("3) Add(sell to pet shop) animal;");
            System.out.println("4) Remove(buy from pet shop) animal;");

            Integer choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    servicePrint.print(storage);
                    break;
                case 2:
                    serviceSearch.search(storage, scanner, StdOut);
                    break;
                case 3:
                    serviceBS.buy(createAnimal(scanner));
                case 4:
                    ArrayList<AbstractAnimal> animalsArr = serviceSearch.search(storage, scanner, StdOut);
                    System.out.println("Choose one animal from the search output: ");
                    Integer searchChoice = scanner.nextInt();
                    scanner.nextLine();

                    AbstractAnimal animalToSell = animalsArr.get(searchChoice);

                    serviceBS.sell(storage.getStorage().indexOf(animalToSell));
            }
        }
    }
}
