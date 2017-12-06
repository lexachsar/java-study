package com.lexach.NetCracker.zan2;

import java.util.ArrayList;

class Not extends BooleanSingleOperation{
    Not(char inObj){
        super(inObj);
    }

    public boolean getResult(boolean a){
        return ( !a );
    }
/*
    @Override
    public ArrayList<BooleanObject> operationSimplifying(ArrayList<BooleanObject> wholeOperation) {

    }*/
}