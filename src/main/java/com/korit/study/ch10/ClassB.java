package com.korit.study.ch10;

public class ClassB {
    String name;
    int age;

    // 매번 사용해야하는 생성을 생략 할 수 있도록 클래스를 정의
    ClassB(String name, int age) {
        this.name = name;  // this를 붙임으로서 자기자신의 현재주소를 뜻함
        this.age = age;
    }
}
