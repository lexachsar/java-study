package com.lexach.netcracker.pet.shop;

import com.lexach.netcracker.pet.shop.animals.AbstractAnimal;

import java.io.PrintStream;
import java.util.ArrayList;

public class PetShopStorage {
    private static PetShopStorage instance = null;
    private ArrayList<AbstractAnimal> storage;

    private PetShopStorage() {
        storage = new ArrayList<>();
    }

    public static PetShopStorage getInstance() {
        if (instance == null) {
            instance = new PetShopStorage();
        }

        return instance;
    }

    /**
     * @return animals storage
     */
    public ArrayList<AbstractAnimal> getStorage() {
        return this.storage;
    }

    /**
     * @return Storage size
     */
    public Integer size() {
        return this.storage.size();
    }

    /**
     * @param StdOut
     * @return Pet shop storage print and return
     */
    public PetShopStorage print(PrintStream StdOut) {
        StdOut.println("List of all animals:");

        //Вывод списка всех животных
        for (int i = 0; i < storage.size(); i++) {
            StdOut.println("Animal number is " + i + '.');
            this.storage.get(i).print(StdOut);
        }

        return this;
    }

    /**
     * @param animal
     * @return Add animal and it
     */
    public AbstractAnimal add(AbstractAnimal animal) {
        storage.add(animal);

        return animal;
    }

    /**
     * @param number
     * @return Remove animal and return in
     */
    public AbstractAnimal remove(Integer number) {
        AbstractAnimal result = storage.get(number);

        storage.remove(number);

        return result;
    }

    /**
     * @param name
     * @param StdOut
     * @return animals search by name
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
     * @return animals search by breed
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
     * @return animals search by left bound cost
     */

    public ArrayList<AbstractAnimal> searchLBCost(PrintStream StdOut, Integer lbCost) {
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

    /**
     * @param StdOut
     * @param rbCost
     * @return animals search by right bound cost
     */

    public ArrayList<AbstractAnimal> searchRBCost(PrintStream StdOut, Integer rbCost) {
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

    /**
     * @param StdOut
     * @param lbCost
     * @param rbCost
     * @return animals search by left and right bound cost
     */
    public ArrayList<AbstractAnimal> searchLBRBCost(PrintStream StdOut, Integer lbCost, Integer rbCost) {
        if (lbCost > rbCost) {
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
     * @param StdOut
     * @param lbCost
     * @param rbCost
     * @return search by any set of lbCost and rbCost
     */
    public ArrayList<AbstractAnimal> searchCost(PrintStream StdOut, Integer lbCost, Integer rbCost) {
        if (lbCost == null && !(rbCost == null)) {
            return searchRBCost(StdOut, rbCost);
        }

        if (!(lbCost == null) && rbCost == null) {
            return searchLBCost(StdOut, lbCost);
        }

        if (!(lbCost == null) && !(rbCost == null)) {
            return searchLBRBCost(StdOut, lbCost, rbCost);
        } else {
            return null;
        }
    }

    /**
     * @param characterTrait
     * @param StdOut
     * @return animals search by character trait
     */
    public ArrayList<AbstractAnimal> searchCharacter(String characterTrait, PrintStream StdOut) {
        ArrayList<AbstractAnimal> searchResult = new ArrayList();

        try {


            for (AbstractAnimal animal : this.storage) {
                if (animal.getCharacter().contains(characterTrait)) {
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
}
