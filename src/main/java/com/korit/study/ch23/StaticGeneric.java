package com.korit.study.ch23;

public class StaticGeneric {

    public static <T> void print(T data) {
        System.out.println(data);
    }

    public static <T extends String> void print(T data) {
        System.out.println(data);
    }
}
