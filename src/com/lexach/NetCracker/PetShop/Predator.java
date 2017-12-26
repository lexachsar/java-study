package com.lexach.NetCracker.PetShop;

import java.util.ArrayList;
import java.util.Random;

import static com.lexach.NetCracker.PetShop.Consts.predatorConst;

public class Predator extends AbstractAnimal {
    Predator(String breed, String name, Integer cost, ArrayList<String> character) {
        super(breed, name, cost, character);

        if(!this.character.contains(predatorConst))
            this.character.add(predatorConst);
    }
    Predator() {
        super();
        if(!this.character.contains(predatorConst))
            this.character.add(predatorConst);
    }

    Predator(Random random) {
        super(random);
        if(!this.character.contains(predatorConst))
            this.character.add(predatorConst);
    }
}
