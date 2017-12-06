package com.lexach.NetCracker.zan2;

class Variable extends BooleanObject{
    Variable(char inObj){
        super(inObj);
    }

    private boolean statement;

    public boolean setStatement(boolean inStatement){
        return statement = inStatement;
    }
}
