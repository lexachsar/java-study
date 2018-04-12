package com.lexach.netcracker.bool.simplification;

abstract class BooleanBinaryOperation extends BooleanOperation {
    BooleanBinaryOperation(char inObj) {
        super(inObj);
    }

    public abstract boolean getResult(boolean a, boolean b);
}
