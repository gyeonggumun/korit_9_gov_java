package com.korit.study.ch10;

public class ClassC {
    String name;
    int age;
    String address;

    // 생성자 오버로딩
    ClassC() {
        // 매개변수가 있는 생성자들을 생성해 두면 아무 것도 없는 생성자를 생성할 수 없기 때문에
        // 비어 있는 생성자를 따로 만들어 주어야 한다.
    }

    ClassC(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    ClassC(String name, int age) {
        this.name = name;
        this.age = age;
    }

    ClassC(String name) {
        this.name = name;
    }

    ClassC(int age) {
        this.age = age;
    }



}
