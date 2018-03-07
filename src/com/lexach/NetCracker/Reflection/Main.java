package com.lexach.NetCracker.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class Main {
    /**
     * Koд с лекции 02.03.18
     */
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //RTTI -- Object во время выполнения преобразуется в класс Shape
        List<Shape> list = Arrays.asList(new Circle(), new Square());
        list.forEach(System.out::println);

        //Class clazz = Circle.class;
        Class clazz = Shape.class;
        // Выводит полное имя класса
        System.out.println(" .getName() " + clazz.getName().toString());
        // Выводит интерфейсы
        System.out.println(" .getInterfaces() " + clazz.getInterfaces().toString());
        // Выводит простое имя
        System.out.println(" .getSimpleName() " + clazz.getSimpleName().toString());
        // Выводит каноничное имя (если класс анонимный, то null и.т.д.)
        System.out.println(" .getCanonicalName() " + clazz.getCanonicalName().toString());
        // Выводит суперкласс
        System.out.println(" .getSuperclass() " + clazz.getSuperclass().toString());

        // Выводит методы класса.
        System.out.println(" .getMethods() " + clazz.getMethods().toString());
        // Выводит декларированные методы класса.
        System.out.println(" .getDeclaredMethods() " + clazz.getDeclaredMethods().toString());
        // Выводит поля класса.
        System.out.println(" .getFields() " + clazz.getFields().toString());
        // Выводит конструкторы класса.
        System.out.println(" .getConstructors() " + clazz.getConstructors().toString());
        // Выводит декларированные конструкторы класса.
        System.out.println(" getDeclaredConstructors() " + clazz.getDeclaredConstructors().toString());

        // Create instance of clazz
        Constructor c = clazz.getConstructor();
        // Invoke method
        Method m = clazz.getMethods()[0];
        Object[] arr = {"pref", 6};
        //m.invoke(o, arr);

    }
}
