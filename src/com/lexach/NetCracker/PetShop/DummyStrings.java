package com.lexach.NetCracker.PetShop;

import java.lang.reflect.Array;
import java.util.*;

public interface DummyStrings {

    static String arrayListGetRandom(ArrayList<String> array) {
        Random rnd = new Random();
        Integer number = rnd.nextInt(array.size());

        return array.get(number);
    }

    static String arrayListGetRandom(ArrayList<String> array, Random random) {
        Integer number = random.nextInt(array.size());

        return array.get(number);
    }

    static String hashSetGetRandom(HashSet<String> set) {
        String[] setArray = set.toArray(new String[set.size()]);

        Random rnd = new Random();
        Integer number = rnd.nextInt(setArray.length);

        return setArray[number];
    }

    static String hashSetGetRandom(HashSet<String> set, Random random) {
        String[] setArray = set.toArray(new String[set.size()]);

        Integer number = random.nextInt(setArray.length);

        return setArray[number];
    }

    public static final ArrayList<String> askForNewAnimal = new ArrayList<String>(Arrays.asList(
            "Подозрительный незнакомец в пальто принес вам странное животное. Вас завтра увольняют, поэтому нет смысла разбираться, что это такое. Введите любые данные."));

    public static final HashSet<String> names = new HashSet<String>(Arrays.asList("Барсик", "Буся", "Джим", "Брида"));

    public static final HashSet<String> characters = new HashSet<String>(Arrays.asList("Добрый", "Веселый", "Хитрый", "Прожорливый"));

    public static final HashSet<String> breeds = new HashSet<>(Arrays.asList("что-то неведомое", "что-то непонятное"));

    public static final HashSet<String> breedsDogs = new HashSet<>(Arrays.asList("Хаски", "Пудель", "Такса", "Бульдог"));

    public static final HashSet<String> breedsCats = new HashSet<>(Arrays.asList("Персидский", "Чеширский", "Сфинкс"));

    public static final HashSet<String> breedsCrocodiles = new HashSet<>(Arrays.asList("Морской", "Нильский", "Болотный", "Африканский"));

    public static final HashSet<String> breedsTigers = new HashSet<>(Arrays.asList("Амурский", "Бенгальский", "Закавказкий"));
}
