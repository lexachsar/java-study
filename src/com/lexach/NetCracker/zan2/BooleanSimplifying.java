package com.lexach.NetCracker.zan2;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.lexach.NetCracker.zan2.Consts.*;

public class BooleanSimplifying {

    private static ArrayList<BooleanObject> fromStringToBooleanFunction(String booleanFunction){
        ArrayList<BooleanObject> booleanFunctionResult= new ArrayList();

        for(int i = 0; i < booleanFunction.length(); i++){
            switch(booleanFunction.charAt(i)){
                case lBracket: {
                    LBracket var = new LBracket( lBracket );
                    booleanFunctionResult.add(var);
                    break;
                }

                case rBracket: {
                    RBracket var = new RBracket( rBracket );
                    booleanFunctionResult.add(var);
                    break;
                }

                case plus: {
                    Or var = new Or( plus );
                    booleanFunctionResult.add(var);
                    break;
                }

                case mult: {
                    And var = new And( mult );
                    booleanFunctionResult.add(var);
                    break;
                }

                case not: {
                    Not var = new Not( not );
                    booleanFunctionResult.add(var);
                    break;
                }

                default: {
                    //Не следует ли объявлять pattern за пределами цикла
                    Pattern pattern = Pattern.compile( "[a-zA-z]" );
                    Matcher matcher = pattern.matcher( booleanFunction.substring(i) );

                    if ( matcher.find() ){
                        Variable var = new Variable(booleanFunction.charAt(i));
                        booleanFunctionResult.add(var);
                        break;
                    }
                }

                case space: {
                    break;
                }
            }
        }

        return booleanFunctionResult;
    }

    private static ArrayList<BooleanObject> booleanSimplifying(){

    }

    private static ArrayList<BooleanObject> booleanFunctionPrint(ArrayList<BooleanObject> function){
        for (int i = 0; i < function.size(); i++)
            function.get(i).print();
        return function;
    }

    public static void main(String args[]){
        String booleanFunction = new String( "(x + !x)" );

        booleanFunctionPrint( fromStringToBooleanFunction(booleanFunction) );
    }
}
