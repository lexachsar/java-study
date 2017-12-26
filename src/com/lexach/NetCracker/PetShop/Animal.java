package com.lexach.NetCracker.PetShop;

import java.util.List;

public interface Animal {
    //???Следует ли объявлять здесь гетеры и сетеры, не лучше ли это сделать в абстрактном классе???
    String getBreed();

    String getName();

    Integer getCost();

    List<String> getCharacter();
}