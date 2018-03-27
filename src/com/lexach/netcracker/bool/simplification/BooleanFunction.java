package com.lexach.netcracker.bool.simplification;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BooleanFunction {
    BooleanFunction(String str) {
        booleanFunction = new ArrayList<BooleanObject>();
        this.setBooleanFunction(str);
    }

    private ArrayList<BooleanObject> booleanFunction;

    //преобразование из строки в ArrayList
    private void setBooleanFunction(String input){

            for(int i = 0; i < input.length(); i++){
                switch(input.charAt(i)){
                    case Consts.lBracket: {
                        LBracket var = new LBracket( Consts.lBracket );
                        this.booleanFunction.add(var);
                        break;
                    }

                    case Consts.rBracket: {
                        RBracket var = new RBracket( Consts.rBracket );
                        this.booleanFunction.add(var);
                        break;
                    }

                    case Consts.plus: {
                        Or var = new Or( Consts.plus );
                        this.booleanFunction.add(var);
                        break;
                    }

                    case Consts.mult: {
                        And var = new And( Consts.mult );
                        this.booleanFunction.add(var);
                        break;
                    }

                    case Consts.not: {
                        Not var = new Not( Consts.not );
                        this.booleanFunction.add(var);
                        break;
                    }

                    default: {
                        //Не следует ли объявлять pattern за пределами цикла
                        Pattern pattern = Pattern.compile( "[a-zA-z]" );
                        Matcher matcher = pattern.matcher( input.substring(i) );

                        if ( matcher.find() ){
                            Variable var = new Variable( input.charAt(i) );
                            this.booleanFunction.add(var);
                            break;
                        }
                    }

                    case Consts.space: {
                        break;
                    }
                }
            }
    }

    //вывод функции
    public void print(){
        for (BooleanObject aBooleanFunction : this.booleanFunction)
            aBooleanFunction.print();
    }

    private void deleteNots(){
        for (int i = 0; i < this.booleanFunction.size(); i++) {
            if (this.booleanFunction.get(i).getObject() == Consts.not)
                this.booleanFunction.get(i).simplify(this.booleanFunction, i);
        }
    }

    private void simplifyBinaryOpertions(){

    }

    public void booleanSimplifying() {
        deleteNots();



    }
}
