package com.lexach.netcracker.projects.bool.simplification;

abstract class BooleanBinaryOperation extends BooleanOperation {
    BooleanBinaryOperation(char inObj) {
        super(inObj);
    }

    public abstract boolean getResult(boolean a, boolean b);
}
