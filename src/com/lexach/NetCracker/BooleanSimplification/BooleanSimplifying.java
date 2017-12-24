package com.lexach.NetCracker.BooleanSimplification;

//import com.lexach.NetCracker.BooleanSimplification.BooleanObject;

import java.util.ArrayList;

public class BooleanSimplifying {
    public static void main(String args[]) {
        String str = "(x + !!!!x)";

        BooleanFunction func = new BooleanFunction(str);

        func.print();
        //booleanFunctionPrint(booleanSimplifying(fromStringToBooleanFunction(booleanFunction)));
    }
}
