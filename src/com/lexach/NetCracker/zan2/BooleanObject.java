package com.lexach.NetCracker.zan2;

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

    public void print(){
        System.out.print(object);
    }


}
