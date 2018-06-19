package com.lexach.netcracker.projects.bool.simplification;

//Операция и из булевского выражения
class And extends BooleanBinaryOperation {
    And(char inObj) {
        super(inObj);
    }

    //получить результат выполнения операции
    public boolean getResult(boolean a, boolean b){
        if(a == true && b == true)
            return true;
        else
            return false;
    }
/*
    public ArrayList<BooleanObject> simplify(ArrayList<BooleanObject> function, int i){
        if(function.get(i-1).getObject() == ) &&
    }*/
}
