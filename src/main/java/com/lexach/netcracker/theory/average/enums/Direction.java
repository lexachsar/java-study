/*
SOURCE : http://www.quizful.net/post/java_enums
 */

package com.lexach.netcracker.theory.average.enums;

/**
 * Добавляем свои методы в enum-класс
 */
public enum Direction {

    UP {
        public Direction opposite() { return DOWN; }
    },
    DOWN {
        public Direction opposite() { return UP; }
    };

    public abstract Direction opposite();

}
