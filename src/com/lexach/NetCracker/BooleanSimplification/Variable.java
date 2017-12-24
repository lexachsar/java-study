package com.lexach.NetCracker.BooleanSimplification;

import com.lexach.NetCracker.BooleanSimplification.BooleanObject;

class Variable extends BooleanObject {
    /*
    private boolean isNot;

    public boolean getIsNot(){
        return isNot;
    }
    */

    Variable(char inObj/*, int numberOfNots*/) {
        super(inObj);
        /*if(numberOfNots % 2 == 0)
            isNot = true;
        else
            isNot = false;*/
    }

    private boolean statement;

    public boolean setStatement(boolean inStatement){
        return statement = inStatement;
    }
}
