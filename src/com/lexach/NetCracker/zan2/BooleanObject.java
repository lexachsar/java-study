package com.lexach.NetCracker.zan2;

import java.util.ArrayList;

public abstract class BooleanObject {
    protected char object;

    public char setObject(char inObj){
        object =  inObj;
        return object;
    }

    public char getObject(){
        return object;
    }

    BooleanObject(char inObj){
        setObject(inObj);
    }

    //вывод BooleanObject
    public void print(){
        System.out.print(object);
    }

    //Метод упрощение по дефолту возвращает первоначальную функцию, не производя изменений
    public ArrayList<BooleanObject> simplify(ArrayList<BooleanObject> function, int i) {
        return function;
    }
}
