package com.lexach.NetCracker.Generics;

import java.util.ArrayList;

//Написать корзинку для яблок
public class Main {
    private static ArrayList<? super Fruit> createTrashBucket() {
        ArrayList<? super Fruit> result = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            result.add( new Apple("Apple") );

            if(i % 2 == 0) {
                result.add( new Orange("Orange") );
            }
        }

        result.add( new Coconut("Coconut") );

        return result;
    }

    public static void main(String[] args) {
        ArrayList<? super Fruit> myTrashBucket = createTrashBucket();

        Bucket myBucket = new Bucket(myTrashBucket);

        myBucket.print();

    }
}
