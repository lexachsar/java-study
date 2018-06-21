/*
SOURCE : http://www.quizful.net/post/java_enums
 */

package com.lexach.netcracker.theory.average.enums;

/**
 * Наследование в enum
 *
 * С помощью enum в Java можно реализовать иерархию классов, объекты которой создаются в единственном экземпляре
 * и доступны статически. При этом элементы enum могут содержать собственные конструкторы.
 */
public enum Type {

    INT(true) {
        public Object parse(String string) { return Integer.valueOf(string); }
    },
    INTEGER(false) {
        public Object parse(String string) { return Integer.valueOf(string); }
    },
    STRING(false) {
        public Object parse(String string) { return string; }
    };

    boolean primitive;
    Type(boolean primitive) { this.primitive = primitive; }

    public boolean isPrimitive() { return primitive; }
    public abstract Object parse(String string);

}
