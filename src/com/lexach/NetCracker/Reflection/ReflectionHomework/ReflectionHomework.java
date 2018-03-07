package com.lexach.NetCracker.Reflection.ReflectionHomework;

import com.lexach.NetCracker.Reflection.Circle;

import javax.xml.bind.SchemaOutputResolver;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ReflectionHomework {
    /**
     * Метод, который принимает класс и выводит в консоль методы этого класса и всех его предков.
     * @param clazz Класс, который принимает данный метод.
     */
    private static Class methodHighlighter(Class clazz){
            // Вывод шапки.
            System.out.println("\nМетоды класса " + clazz.getName() + ":");
            // Создание массива из методов класса clazz.
            Method[] methodz = clazz.getMethods();
            // Перебор всех методов класса clazz, их вывод в читаемом виде.
            for (Method varMethod : methodz) {
                // Методы, помеченные моей аннотацией будут подсвечиваться " * "
                if((MyFirstAnnotation)varMethod.getAnnotation(MyFirstAnnotation.class) != null)
                    System.out.print(" * ");

                System.out.print(varMethod.getReturnType() + " ");
                System.out.print(varMethod.getName() + "( ");

                // Создание массива из типов параметров метода.
                Type[] typez = varMethod.getParameterTypes();

                // Перебор всех птипов араметров метода, вывод в читаемом виде.
                for (Type varThype : typez) {
                    System.out.print(varThype.getTypeName() + " ");
                }

                System.out.println(")");
            }

            if(clazz.getSuperclass() == null) {
                // Возвращаем данный метод, если у него нет потомка.
                return clazz;
            }
            else {
                // Рекурсивный запуск метода. В качестве параметра передаем родитель класса clazz.
                return methodHighlighter(clazz.getSuperclass());
            }
        }

    public static void main(String[] args) {
        Class clazz = Circle.class;

        methodHighlighter(clazz);
    }
}
