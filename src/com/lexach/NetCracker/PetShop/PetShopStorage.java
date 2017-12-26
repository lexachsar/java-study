package com.lexach.NetCracker.PetShop;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.util.ArrayList;

public class PetShopStorage {
    private static PetShopStorage instance = null;
    private ArrayList<AbstractAnimal> storage;

    private PetShopStorage() {
        storage = new ArrayList<AbstractAnimal>();
    }

    public static PetShopStorage getPetShopStorage() {
        if(instance == null) {
            instance = new PetShopStorage();
        }

        return instance;
    }
}
