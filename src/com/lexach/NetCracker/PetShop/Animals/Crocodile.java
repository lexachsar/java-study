package com.lexach.NetCracker.PetShop.Animals;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.Random;

import static com.lexach.NetCracker.PetShop.DummyStrings.*;

public class Crocodile extends Predator {
    public Crocodile(Random random) {
        super(random);

        while (this.name == null) {
            Iterator<String> i = names.iterator();
            while (i.hasNext())
                System.out.println(i.next());

            this.name = hashSetGetRandom(names, random);
        }

        this.cost = random.nextInt(99999);

        String[] varCharacters = characters.toArray(new String[characters.size()]);

        Integer randBound = random.nextInt(varCharacters.length);
        for (int i = 0; i < randBound; i++) {
            //Записываем черту из массива всех черт характера в массив характера животного
            this.character.add(varCharacters[i]);
        }

        this.breed = hashSetGetRandom(breedsCrocodiles);
    }

    public Crocodile() {
        super();
    }

    public Crocodile print(PrintStream StdOut) {
        StdOut.println("Type: Crocodile");
        super.print(StdOut);

        return this;
    }
}
