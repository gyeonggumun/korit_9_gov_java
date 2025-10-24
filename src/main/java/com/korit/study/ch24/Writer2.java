package com.korit.study.ch24;

import java.util.Objects;

public class Writer2 {
    private String name;
    private int age;

    // 값을 넣어서 생성하거나 아무것도 없이 생성 할 수 있기 때문에 생성자 두개 생성
    public Writer2() {}

    public Writer2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // private값을 사용하기 위해 getter, setter 생성
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 값을 비교하기 위해 equals, hashCode 생성
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Writer2 writer2)) return false;
        return age == writer2.age && Objects.equals(name, writer2.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    // 값을 확인하기 위해 toString 생성
    @Override
    public String toString() {
        return "Writer2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
