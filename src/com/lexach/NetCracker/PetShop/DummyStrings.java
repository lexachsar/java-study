package com.lexach.NetCracker.PetShop;

import java.util.*;

public interface DummyStrings {

    static String arrayListGetRandom(ArrayList<String> array) {
        Random rnd = new Random();
        Integer number = rnd.nextInt(array.size() - 1);

        return array.get(number);
    }

    static String arrayListGetRandom(ArrayList<String> array, Random random) {
        Integer number = random.nextInt(array.size() - 1);

        return array.get(number);
    }

    static String hashSetGetRandom(HashSet<String> set) {
        Iterator<String> iterator = set.iterator();
        iterator.next();
            iterator.next()
        }

    public static final ArrayList<String> askForNewAnimal = new ArrayList<String>(Arrays.asList(
            "Подозрительный незнакомец в пальто принес вам странное животное. Вас завтра увольняют, поэтому нет смысла разбираться, что это такое. Введите любые данные."));

    public static final HashSet<String> names = new HashSet<String>(Arrays.asList("Барсик", "Буся", "Джим", "Брида"));

    public static final HashSet<String> characters = new HashSet<String>(Arrays.asList("Добрый", "Веселый", "Хитрый", "Прожорливый"));
}
