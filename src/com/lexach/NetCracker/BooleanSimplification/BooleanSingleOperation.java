package com.lexach.NetCracker.BooleanSimplification;

import com.lexach.NetCracker.BooleanSimplification.BooleanOperation;

abstract class BooleanSingleOperation extends BooleanOperation {
    BooleanSingleOperation(char inObj){
        super(inObj);
    }

    public abstract boolean getResult(boolean a);
}