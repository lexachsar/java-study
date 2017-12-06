package com.lexach.NetCracker.zan2;

abstract class BooleanBinaryOperation extends BooleanOperation{
    BooleanBinaryOperation(char inObj) {
        super(inObj);
    }

    public abstract boolean getResult(boolean a, boolean b);
}
