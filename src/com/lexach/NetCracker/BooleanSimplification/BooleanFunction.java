package com.lexach.NetCracker.BooleanSimplification;

import com.lexach.NetCracker.*;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.lexach.NetCracker.BooleanSimplification.Consts.*;

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
                    case lBracket: {
                        LBracket var = new LBracket( lBracket );
                        this.booleanFunction.add(var);
                        break;
                    }

                    case rBracket: {
                        RBracket var = new RBracket( rBracket );
                        this.booleanFunction.add(var);
                        break;
                    }

                    case plus: {
                        Or var = new Or( plus );
                        this.booleanFunction.add(var);
                        break;
                    }

                    case mult: {
                        And var = new And( mult );
                        this.booleanFunction.add(var);
                        break;
                    }

                    case not: {
                        Not var = new Not( not );
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

                    case space: {
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
            if (this.booleanFunction.get(i).getObject() == not)
                this.booleanFunction.get(i).simplify(this.booleanFunction, i);
        }
    }

    private void simplifyBinaryOpertions(){

    }

    public void booleanSimplifying() {
        deleteNots();



    }
}
