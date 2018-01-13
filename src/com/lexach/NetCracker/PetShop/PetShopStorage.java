package com.lexach.NetCracker.PetShop;

import java.io.PrintStream;
import java.util.ArrayList;

public class PetShopStorage {
    private static PetShopStorage instance = null;
    private ArrayList<AbstractAnimal> storage;

    private PetShopStorage() {
        storage = new ArrayList<AbstractAnimal>();
    }

    public static PetShopStorage getInstance() {
        if (instance == null) {
            instance = new PetShopStorage();
        }

        return instance;
    }

    /**
     * @return Animals storage
     */
    public ArrayList<AbstractAnimal> getStorage() {
        return storage;
    }

    /**
     * Вывод хранилища животных
     */
    public PetShopStorage printPetShopStorage(PrintStream StdOut) {
        StdOut.println("List of all animals:");

        //Вывод списка всех животных
        for (int i = 0; i < storage.size(); i++) {
            StdOut.println("Animal number is " + i + '.');
            this.storage.get(i).print(StdOut);
        }

        return this;
    }

    /**
     * @param name
     * @param StdOut
     * @return Animals search by name
     */
    public ArrayList<AbstractAnimal> searchName(String name, PrintStream StdOut) {
        ArrayList<AbstractAnimal> searchResult = new ArrayList();

        try {
            for (AbstractAnimal animal : this.storage) {
                if (animal.getName().equals(name)) {
                    searchResult.add(animal);
                }
            }

            if (searchResult.isEmpty()) {
                throw new Exception("Search result is empty");
            }

        } catch (Exception exep) {
            StdOut.println(exep.getMessage());
            return null;
        }

        return searchResult;
    }

    /**
     * @param breed
     * @param StdOut
     * @return Animals search by breed
     */
    public ArrayList<AbstractAnimal> searchBreed(String breed, PrintStream StdOut) {
        ArrayList<AbstractAnimal> searchResult = new ArrayList();

        try {
            for (AbstractAnimal animal : this.storage) {
                if (animal.getBreed().equals(breed)) {
                    searchResult.add(animal);
                }
            }

            if (searchResult.isEmpty()) {
                throw new Exception("Search result is empty");
            }

        } catch (Exception exep) {
            StdOut.println(exep.getMessage());
            return null;
        }

        return searchResult;
    }

    /**
     * @param StdOut
     * @param lbCost
     * @return Animals search by left bound cost
     */
    /*
    public ArrayList<AbstractAnimal> searchCost(PrintStream StdOut, Integer lbCost) {
        ArrayList<AbstractAnimal> searchResult = new ArrayList();

        try {
            for (AbstractAnimal animal : this.storage) {
                if (animal.getCost() >= lbCost) {
                    searchResult.add(animal);
                }
            }

            if (searchResult.isEmpty()) {
                throw new Exception("Search result is empty");
            }

        } catch (Exception exep) {
            StdOut.println(exep.getMessage());
        }

        return searchResult;
    }
*/
    /**
     * @param StdOut
     * @param rbCost
     * @return Animals search by right bound cost
     */
 /*
    public ArrayList<AbstractAnimal> searchCost(PrintStream StdOut, Integer rbCost) {
        ArrayList<AbstractAnimal> searchResult = new ArrayList();

        try {
            for (AbstractAnimal animal : this.storage) {
                if (animal.getCost() <= rbCost) {
                    searchResult.add(animal);
                }
            }

            if (searchResult.isEmpty()) {
                throw new Exception("Search result is empty");
            }

        } catch (Exception exep) {
            StdOut.println(exep.getMessage());
        }

        return searchResult;
    }
*/
    /**
     * @param StdOut
     * @param lbCost
     * @param rbCost
     * @return Animals search by left and right bound cost
     */
    public ArrayList<AbstractAnimal> searchCost(PrintStream StdOut, Integer lbCost, Integer rbCost) {
        if(lbCost > rbCost){
            Integer buff = rbCost;
            rbCost = lbCost;
            lbCost = buff;
        }

        ArrayList<AbstractAnimal> searchResult = new ArrayList();

        try {
            for (AbstractAnimal animal : this.storage) {

                if (animal.getCost() >= lbCost && animal.getCost() <= rbCost) {
                    searchResult.add(animal);
                }
            }

            if (searchResult.isEmpty()) {
                throw new Exception("Search result is empty");
            }

        } catch (Exception exep) {
            StdOut.println(exep.getMessage());
        }

        return searchResult;
    }

    /**
     * @param characterTraits
     * @param StdOut
     * @return Animals search by character traits
     */
    public ArrayList<AbstractAnimal> searchCharacter(ArrayList<String> characterTraits, PrintStream StdOut) {
        ArrayList<AbstractAnimal> searchResult = new ArrayList();

        try {


            for (AbstractAnimal animal : this.storage) {
                if (animal.getCharacter().containsAll(characterTraits)) {
                    searchResult.add(animal);
                }
            }

            if (searchResult.isEmpty()) {
                throw new Exception("Search result is empty");
            }

        } catch (Exception exep) {
            StdOut.println(exep.getMessage());
        }

        return searchResult;
    }

    public PetShopStorage print(PrintStream StdOut) {

    }

}
