package com.lexach.NetCracker.PetShop;

import java.util.List;

public abstract class AbstractAnimal implements Animal {
    //порода животного
    protected String breed;
    protected String name;
    protected Integer cost;
    protected String character;

    public String getBreed() {
        return this.breed;
    }
    public String getName() {
        return this.name;
    }
    public Integer getCost() {
        return this.cost;
    }
    public String getCharacter() {
        return this.character;
    }
}
