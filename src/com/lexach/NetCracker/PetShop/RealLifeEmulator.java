package com.lexach.NetCracker.PetShop;

import com.lexach.NetCracker.PetShop.Animals.*;

import javax.jws.soap.SOAPBinding;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Random;

public class RealLifeEmulator extends Thread {
    private static AbstractAnimal createAnimal(Random rnd) {
        int code = new Random().nextInt(4);
        switch (code) {
            case 0:
                return new Dog(rnd);
            case 1:
                return new Cat(rnd);
            case 2:
                return new Crocodile(rnd);
            case 3:
                return new Tiger(rnd);
            default:
                return null;
        }
    }

    public void run() {
        Random rnd = new Random();

        while (true) {
            System.out.println("A");

            int code = rnd.nextInt(10);


            switch (code) {
                case 1:
                case 2:
                case 3:
                case 4:
                    UserInterface.serviceBS.buy(createAnimal(rnd));
                    break;
                case 5:
                case 6:
                    UserInterface.serviceBS.sell(rnd);
                    break;
                case 7:
                    UserInterface.serviceBS.runAway(UserInterface.storage, rnd);
                    break;
            }
        }
    }
}
