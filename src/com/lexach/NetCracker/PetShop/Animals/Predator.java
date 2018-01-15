package com.lexach.NetCracker.PetShop.Animals;

import com.lexach.NetCracker.PetShop.Animals.AbstractAnimal;

import java.util.HashSet;
import java.util.Random;

import static com.lexach.NetCracker.PetShop.Consts.predatorConst;

public class Predator extends AbstractAnimal {
    Predator(String breed, String name, Integer cost, HashSet<String> character) {
        super(breed, name, cost, character);

        if (!this.character.contains(predatorConst))
            this.character.add(predatorConst);
    }

    Predator() {
        super();
        if (!this.character.contains(predatorConst))
            this.character.add(predatorConst);
    }

    Predator(Random random) {
        super(random);
        if (!this.character.contains(predatorConst))
            this.character.add(predatorConst);
    }
}
