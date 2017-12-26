package com.lexach.NetCracker.PetShop;

import java.util.ArrayList;
import java.util.Random;

public class Pet extends AbstractAnimal {


    Pet(String breed, String name, Integer cost, ArrayList<String> character) {
        super(breed, name, cost, character);
        this.character.add("Домашний");
    }
    Pet() {
        super();
        this.character.contains("Домашний")
    }

    Pet(Random random) {

    }
}
