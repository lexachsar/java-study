package com.lexach.NetCracker.zan2;

class And extends BooleanBinaryOperation{
    And(char inObj) {
        super(inObj);
    }

    public boolean getResult(boolean a, boolean b){
        if(a == true && b == true)
            return true;
        else
            return false;
    }
}
