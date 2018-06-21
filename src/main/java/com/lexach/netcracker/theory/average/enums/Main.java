/*
SOURCE : http://www.quizful.net/post/java_enums
 */

package com.lexach.netcracker.theory.average.enums;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // Примитивное использование Enum
        Season season = Season.SPRING;

        if (season == Season.SPRING)
            season = Season.SUMMER;

        System.out.println(season);

        // Наш Enum класс наследуется от java.lang.Enum
        System.out.println(Season.class.getSuperclass());

        // Название и порядковый номер элемента enum
        season = Season.WINTER;
        System.out.println("season.name()=" + season.name() + " season.toString()=" + season.toString() + " season.ordinal()=" + season.ordinal());

        // Получение элемента enum по строковому представлению его имени
        String name = "WINTER";
        season = Season.valueOf(name);
        /*
        В результате выполнения кода переменная season будет равна Season.WINTER.
        Cледует обратить внимание, что если элемент не будет найден, то будет выброшен IllegalArgumentException,
        а в случае, если name равен null - NullPointerException.
         */

        // Получение всех элементов перечисления
        System.out.println(Arrays.toString(Season.values()));

        // Добавляем свои методы в enum-класс (выведет DOWN)
        Direction direction = Direction.UP;
        System.out.println(direction.opposite());

        // Наследование в enum
        System.out.println(Type.class);
        System.out.println(Type.INT.getClass() + " " + Type.INT.getClass().getSuperclass());
        System.out.println(Type.INTEGER.getClass() + " " + Type.INTEGER.getClass().getSuperclass());
        System.out.println(Type.STRING.getClass()  + " " + Type.STRING.getClass().getSuperclass());



    }

}
