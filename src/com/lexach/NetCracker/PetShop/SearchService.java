package com.lexach.NetCracker.PetShop;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.lexach.NetCracker.PetShop.Animals.AbstractAnimal;

public class SearchService {
    private static SearchService instance = null;

    private SearchService() {

    }

    public static SearchService getInstance() {
        if (instance == null) {
            instance = new SearchService();
        }

        return instance;
    }

    /**
     * @param searchResult
     * @param StdOut
     * @return Search result output
     */
    private ArrayList<AbstractAnimal> printSearchResult(ArrayList<AbstractAnimal> searchResult, PrintStream StdOut) {
        if (searchResult == null) {
            StdOut.println("List of finded animals is empty.");
            return null;
        } else {
            StdOut.println("List of finded animals:");

            for (int i = 0; i < searchResult.size(); i++) {
                StdOut.println("Animal number is " + i + '.');
                searchResult.get(i).print(StdOut);
            }
            return searchResult;
        }
    }

    /**
     * @param storage
     * @param StdOut
     * @param scanner
     * @return Animals with specified name
     */
    private ArrayList<AbstractAnimal> searchName(PetShopStorage storage, PrintStream StdOut, Scanner scanner) {
        StdOut.print("Input the name of animal you want to find: ");
        String name = scanner.nextLine();

        ArrayList<AbstractAnimal> searchResult = storage.searchName(name, StdOut);

        printSearchResult(searchResult, StdOut);

        return searchResult;
    }

    /**
     * @param storage
     * @param StdOut
     * @param scanner
     * @return Animals with specified breed
     */
    private ArrayList<AbstractAnimal> searchBreed(PetShopStorage storage, PrintStream StdOut, Scanner scanner) {
        StdOut.print("Input the breed of animal you want to find: ");
        String breed = scanner.nextLine();

        ArrayList<AbstractAnimal> searchResult = storage.searchBreed(breed, StdOut);

        printSearchResult(searchResult, StdOut);

        return searchResult;
    }

    /**
     * @param storage
     * @param scanner
     * @param StdOut
     * @return Animals with specified cost
     */
    private ArrayList<AbstractAnimal> searchCost(PetShopStorage storage, Scanner scanner, PrintStream StdOut) {
        System.out.println("Input the left border? y/n");
        boolean isThereLB = Consts.yesNo(scanner, StdOut);

        ArrayList<AbstractAnimal> result = new ArrayList<>();

        System.out.println("Input the right border? y/n");
        boolean isThereRB = Consts.yesNo(scanner, StdOut);

        if (isThereLB && isThereRB) {
            StdOut.print("Input the left border: ");
            Integer lb = scanner.nextInt();

            StdOut.print("Input the right border: ");
            Integer rb = scanner.nextInt();

            result = storage.searchCost(StdOut, lb, rb);
        }

        if (isThereLB && !isThereRB) {
            StdOut.print("Input the left border: ");
            Integer lb = scanner.nextInt();

            result = storage.searchCost(StdOut, lb, null);
        }

        if (!isThereLB && isThereRB) {
            StdOut.print("Input the right border: ");
            Integer rb = scanner.nextInt();

            result = storage.searchCost(StdOut, null, rb);
        }

        printSearchResult(result, StdOut);

        return result;
    }

    /**
     * @param storage
     * @param scanner
     * @param StdOut
     * @return Animals with specified character breed
     */
    private ArrayList<AbstractAnimal> searchCharacter(PetShopStorage storage, Scanner scanner, PrintStream StdOut) {
        StdOut.println("Input the character trait: ");
        String characterTrait = scanner.nextLine();

        ArrayList<AbstractAnimal> result = storage.searchCharacter(characterTrait, StdOut);

        printSearchResult(result, StdOut);

        return result;
    }

    /**
     * @param storage
     * @param scanner
     * @param StdOut
     * @return Main search function
     */
    public ArrayList<AbstractAnimal> search(PetShopStorage storage, Scanner scanner, PrintStream StdOut) {
        StdOut.println("Input:");
        StdOut.println("1) If you want to find animal by name;");
        StdOut.println("2) If you want to find animal by breed;");
        StdOut.println("3) If you want to find animal by cost;");
        StdOut.println("4) If you want to find animal by character trait;");
        Integer choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1: {
                return searchName(storage, StdOut, scanner);
            }
            case 2: {
                return searchBreed(storage, StdOut, scanner);
            }
            case 3: {
                return searchCost(storage, scanner, StdOut);
            }
            case 4: {
                return searchCharacter(storage, scanner, StdOut);
            }
            default: {
                return null;
            }
        }

    }
}