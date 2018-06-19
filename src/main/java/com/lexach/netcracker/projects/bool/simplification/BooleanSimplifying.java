package com.lexach.netcracker.projects.bool.simplification;

//import BooleanObject;

public class BooleanSimplifying {
    public static void main(String args[]) {
        String str = "(x + !!!!x)";

        BooleanFunction func = new BooleanFunction(str);

        func.print();
        //booleanFunctionPrint(booleanSimplifying(fromStringToBooleanFunction(booleanFunction)));
    }
}
