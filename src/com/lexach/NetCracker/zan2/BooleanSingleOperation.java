package com.lexach.NetCracker.zan2;

abstract class BooleanSingleOperation extends BooleanOperation{
    BooleanSingleOperation(char inObj){
        super(inObj);
    }

    public abstract boolean getResult(boolean a);
}