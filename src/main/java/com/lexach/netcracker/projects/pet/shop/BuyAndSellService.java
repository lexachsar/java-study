package com.lexach.netcracker.projects.pet.shop;

import com.lexach.netcracker.projects.pet.shop.animals.AbstractAnimal;

import java.util.Random;

public class BuyAndSellService {
    private static BuyAndSellService instance = null;

    private BuyAndSellService() {

    }

    public static BuyAndSellService getInstance() {
        if (instance == null) {
            instance = new BuyAndSellService();
        }

        return instance;
    }

    public AbstractAnimal buy(AbstractAnimal animal) {
        if (animal != null) {

            return UserInterface.storage.add(animal);
        } else {
            return null;
        }
    }

    public AbstractAnimal sell(Random rnd) {
        if (UserInterface.storage.size().equals(0)) {
            return null;
        } else {
            Integer animalNumber = rnd.nextInt(UserInterface.storage.size());
            return UserInterface.storage.remove(animalNumber);
        }
    }

    public AbstractAnimal sell(Integer index) {
        if (UserInterface.storage.size().equals(0)) {
            return null;
        } else {
            return UserInterface.storage.remove(index);
        }
    }

    public AbstractAnimal runAway(PetShopStorage storage, Random rnd) {
        if (storage.size().equals(0)) {
            return null;
        } else {
            Integer animalNumber = rnd.nextInt(storage.size());
            return storage.remove(animalNumber);
        }
    }

}
