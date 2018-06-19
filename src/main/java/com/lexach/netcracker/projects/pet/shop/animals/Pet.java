package com.lexach.netcracker.projects.pet.shop.animals;

import java.util.HashSet;
import java.util.Random;

import static com.lexach.netcracker.projects.pet.shop.Consts.petConst;

public class Pet extends AbstractAnimal {
    Pet(String breed, String name, Integer cost, HashSet<String> character) {
        super(breed, name, cost, character);

        if (!this.character.contains(petConst))
            this.character.add(petConst);
    }

    Pet() {
        super();
        if (!this.character.contains(petConst))
            this.character.add(petConst);
    }

    Pet(Random random) {
        super(random);
        if (!this.character.contains(petConst))
            this.character.add(petConst);
    }
}
