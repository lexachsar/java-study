package com.lexach.NetCracker.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //RTTI -- Object во время выполнения преобразуется в класс Shape
        List<Shape> list = Arrays.asList(new Circle(), new Square());
        list.forEach(System.out::println);

        //Class clazz = Circle.class;
        Class clazz = Shape.class;
        // Выводит полное имя класса
        System.out.println(clazz.getName().toString());
        // Выводит интерфейсы
        System.out.println(clazz.getInterfaces().toString());
        // Выводит простое имя
        System.out.println(clazz.getSimpleName().toString());
        // Выводит каноничное имя (если класс анонимный, то null и.т.д.)
        System.out.println(clazz.getCanonicalName().toString());
        // Выводит суперкласс
        System.out.println(clazz.getSuperclass().toString());

        // Выводит методы класса.
        System.out.println(clazz.getMethods().toString());
        // Выводит декларированные методы класса.
        System.out.println(clazz.getDeclaredMethods().toString());
        // Выводит поля класса.
        System.out.println(clazz.getFields().toString());
        // Выводит конструкторы класса.
        System.out.println(clazz.getConstructors().toString());
        // Выводит декларированные конструкторы класса.
        System.out.println(clazz.getDeclaredConstructors().toString());

        // Create instance of clazz
        Constructor c = clazz.getConstructor();
        Object o = c.newInstance();
        // Invoke method
        Method m = clazz.getMethods()[0];
        Object[] arr = {"pref", 6};
        m.invoke(o);


    }
}
