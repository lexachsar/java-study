package com.lexach.NetCracker.PetShop;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.lexach.NetCracker.PetShop.Consts.*;

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
        StdOut.println("List of finded animals:");

        for (int i = 0; i < searchResult.size(); i++) {
            StdOut.println("Animal number is " + i + '.');
            searchResult.get(i).print(StdOut);
        }
        return searchResult;
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

        ArrayList<AbstractAnimal> searchResult = storage.searchName(breed, StdOut);

        printSearchResult(searchResult, StdOut);

        return searchResult;
    }

    private ArrayList<AbstractAnimal> searchCost(PetShopStorage storage, Scanner scanner, PrintStream StdOut) {
        try {
            System.out.println("Input the left border? y/n");


            System.out.println("Input the right border? y/n");
            char isThereRB = scanner.next().charAt(0);

            if(isThereLB == Consts.yes && isThereRB == Consts.yes) {

                storage.searchCost()
            }

        }
    }

}
