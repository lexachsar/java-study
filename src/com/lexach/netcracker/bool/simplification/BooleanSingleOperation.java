package com.lexach.netcracker.bool.simplification;

abstract class BooleanSingleOperation extends BooleanOperation {
    BooleanSingleOperation(char inObj){
        super(inObj);
    }

    public abstract boolean getResult(boolean a);
}