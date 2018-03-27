package com.lexach.netcracker.pet.shop.animals;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.Random;

import static com.lexach.netcracker.pet.shop.DummyStrings.*;

public class Cat extends Pet {
    public Cat(Random random) {
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

        this.breed = hashSetGetRandom(breedsCats);
    }

    public Cat() {
        super();
    }

    public Cat print(PrintStream StdOut) {
        StdOut.println("Type: Cat");
        super.print(StdOut);

        return this;
    }
}
