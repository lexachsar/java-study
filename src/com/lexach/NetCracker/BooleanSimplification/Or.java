package com.lexach.NetCracker.BooleanSimplification;

import com.lexach.NetCracker.BooleanSimplification.BooleanBinaryOperation;

class Or extends BooleanBinaryOperation {

    Or(char inObj) {
        super(inObj);
    }

    public boolean getResult(boolean a, boolean b){
        if(a == false && b == false)
            return false;
        else
            return true;
    }
}
