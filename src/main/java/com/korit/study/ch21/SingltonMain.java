package com.korit.study.ch21;

public class SingltonMain {
    public static void main(String[] args) {
        ClassA a = new ClassA();
        ClassB b = new ClassB();
        ClassC c = new ClassC();


        a.run();
        b.run();
        c.run();



    }
}
