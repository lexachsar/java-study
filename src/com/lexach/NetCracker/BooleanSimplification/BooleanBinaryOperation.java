package com.lexach.NetCracker.BooleanSimplification;

import com.lexach.NetCracker.BooleanSimplification.BooleanOperation;

abstract class BooleanBinaryOperation extends BooleanOperation {
    BooleanBinaryOperation(char inObj) {
        super(inObj);
    }

    public abstract boolean getResult(boolean a, boolean b);
}
