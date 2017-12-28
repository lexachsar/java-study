package com.lexach.NetCracker.PetShop;

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

            this.name = arrayListGetRandom(names);
        }

        this.cost = random.nextInt(99999);

        HashSet<String> varCharacters = characters;

        for (int i = 0; i < random.nextInt(varCharacters.size() - 1); i++) {
            //Удаляем из массива черт характера одну черту (чтобы исключить повторения) и записываем её в массив характера животного
            String varCharacter = varCharacters.remove(random.nextInt(varCharacters.size() - 1));
            this.character.add(varCharacter);
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


}
