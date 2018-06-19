package com.lexach.netcracker.projects.pet.shop.animals;

import java.io.PrintStream;
import java.util.*;

import static com.lexach.netcracker.projects.pet.shop.DummyStrings.*;
import static com.lexach.netcracker.projects.pet.shop.Consts.*;

public abstract class AbstractAnimal implements Animal {
    //порода животного
    protected String breed;
    protected String name;
    protected Integer cost;
    protected HashSet<String> character = new HashSet<>();

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
        scanner.nextLine();

        Boolean characterInputIsEnded = false;
        do {
            System.out.print("Input the new character trait: ");

            String var = scanner.nextLine();
            this.character.add(var);

            System.out.println("Do you want to finish character input? y/n");
            characterInputIsEnded = yesNo(scanner, System.out);

        } while (characterInputIsEnded == true);
    }

    AbstractAnimal(Random random) {
        while (this.name == null) {
            this.name = hashSetGetRandom(names, random);
        }

        this.cost = random.nextInt(99999);

        String[] varCharacters = characters.toArray(new String[characters.size()]);

        Integer randBound = random.nextInt(varCharacters.length);
        for (int i = 0; i < randBound; i++) {
            //Записываем черту из массива всех черт характера в массив характера животного
            this.character.add(varCharacters[i]);
        }

        this.breed = hashSetGetRandom(breeds);
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
