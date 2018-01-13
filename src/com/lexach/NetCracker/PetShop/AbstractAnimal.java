package com.lexach.NetCracker.PetShop;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import static com.lexach.NetCracker.PetShop.DummyStrings.*;
import static com.lexach.NetCracker.PetShop.Consts.*;

public abstract class AbstractAnimal implements Animal {
    //порода животного
    protected String breed;
    protected String name;
    protected Integer cost;
    protected HashSet<String> character;

    AbstractAnimal(String breed, String name, Integer cost, HashSet<String> character) {
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
    }


    AbstractAnimal() {
        System.out.println(arrayListGetRandom(askForNewAnimal));

        Scanner scanner = new Scanner(System.in);

        System.out.print("Input the animal breed: ");
        this.breed = scanner.nextLine();

        System.out.print("Input the animal name: ");
        this.name = scanner.nextLine();

        System.out.print("Input the price: ");
        this.cost = scanner.nextInt();

        Boolean characterInputIsEnded = false;
        do {
            System.out.print("Input the new character trait: ");
            character.add(scanner.nextLine());

            try {
                System.out.println("Do you want to finish character input? y/n");
                char choice = scanner.next().charAt(0);
                switch (choice) {
                    case yes:
                        characterInputIsEnded = true;

                    case no:
                        characterInputIsEnded = false;

                    default:
                        throw new Exception("Your answer is not y or n. Aborting character input.");
                }
            } catch (Exception excep) {
                System.out.println(excep.toString());
                characterInputIsEnded = true;
            }

        } while (characterInputIsEnded == false);
    }

    AbstractAnimal(Random random) {
        while (this.name == null) {
            Iterator<String> i = names.iterator();
            while (i.hasNext())
                System.out.println(i.next());

            this.name = hashSetGetRandom(names, random);
        }

        this.cost = random.nextInt(99999);

        String[] varCharacters = characters.toArray(new String[characters.size()]);

        for (int i = 0; i < random.nextInt(varCharacters.length - 1); i++) {
            //Записываем черту из массива всех черт характера в массив характера животного
            this.character.add(varCharacters[i]);
        }

    }

    public String getBreed() {
        return this.breed;
    }

    public String getName() {
        return this.name;
    }

    public Integer getCost() {
        return this.cost;
    }

    public HashSet<String> getCharacter() {
        return this.character;
    }


    //Вывод породы животного
    public String printBreed(PrintStream StdOut) {
        StdOut.print("Breed of the animal: " + this.getBreed());

        return this.breed;
    }

    //вывод имени животного
    public String printName(PrintStream StdOut) {
        StdOut.print("Name of the animal: " + this.getName());

        return this.name;
    }

    //Вывод цены животного
    public Integer printCost(PrintStream StdOut) {
        StdOut.print("Cost of the animal: " + this.getCost());

        return this.cost;
    }

    //Вывод черт характера животного
    public HashSet<String> printCharacter(PrintStream StdOut) {
        //Перевод хеш сета характеров животного в массив характеров животного
        String[] varCharacters = this.getCharacter().toArray(new String[this.getCharacter().size()]);

        //Вывод черт характера животного
        System.out.println("Animal character traits:");
        for (String character : varCharacters) {
            StdOut.println(character);
        }

        return this.character;
    }


    //вывод информации о животном
    public AbstractAnimal print(PrintStream StdOut){
        printName(StdOut);

        printBreed(StdOut);

        printCharacter(StdOut);

        printCost(StdOut);

        return this;
    }
}
