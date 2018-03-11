package com.lexach.NetCracker.Reflection.ReflectionHomework;

import com.lexach.NetCracker.Reflection.Circle;

import javax.xml.bind.SchemaOutputResolver;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ReflectionHomework {
    /**
     * @param varMethod Метод.
     * @param myAnnotation Аннотация.
     * @return true, если данный метод имеет данную аннотацию, false, в противном случае.
     */
    private static boolean doesMethodHaveAnnotation(Method varMethod, Class myAnnotation) {
        if (null != (Annotation) varMethod.getAnnotation(myAnnotation)) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * Метод, который принимает класс и выводит в консоль паблик методы этого класса и всех его предков.
     * @param clazz Класс, который принимает данный метод.
     */
    private static Class methodHighlighter(Class clazz){
            // Вывод шапки.
            System.out.println("\nМетоды класса " + clazz.getName() + ":");
            // Создание массива из методов класса clazz.
            Method[] methodz = clazz.getMethods();
            // Перебор всех методов класса clazz, их вывод в читаемом виде.
            for (Method varMethod : methodz) {
                // Выводим методы, только если они являются публичными.
                if(Modifier.isPublic(varMethod.getModifiers())) {
                    // Методы, помеченные моей аннотацией будут подсвечиваться " * "
                    if (doesMethodHaveAnnotation(varMethod, MyFirstAnnotation.class)) {
                        System.out.print(" * ");
                    }

                    System.out.print(varMethod.getReturnType() + " ");
                    System.out.print(varMethod.getName() + "( ");

                    // Создание массива из типов параметров метода.
                    Type[] types = varMethod.getParameterTypes();

                    // Перебор всех типов параметров метода, вывод в читаемом виде.
                    for (Type varType : types) {
                        System.out.print(varType.getTypeName() + " ");
                    }

                    System.out.println(")");
                }
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
