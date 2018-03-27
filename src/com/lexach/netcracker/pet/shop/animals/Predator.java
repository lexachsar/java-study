package com.lexach.netcracker.pet.shop.animals;

import java.util.HashSet;
import java.util.Random;

import static com.lexach.netcracker.pet.shop.Consts.predatorConst;

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
