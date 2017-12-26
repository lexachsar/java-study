package com.lexach.NetCracker.PetShop;

import java.util.ArrayList;
import java.util.Random;

import static com.lexach.NetCracker.PetShop.Consts.petConst;

public class Pet extends AbstractAnimal {


    Pet(String breed, String name, Integer cost, ArrayList<String> character) {
        super(breed, name, cost, character);

        if(!this.character.contains(petConst))
            this.character.add(petConst);
    }
    Pet() {
        super();
        if(!this.character.contains(petConst))
            this.character.add(petConst);
    }

    Pet(Random random) {
        super(random);
        if(!this.character.contains(petConst))
            this.character.add(petConst);
    }
}
