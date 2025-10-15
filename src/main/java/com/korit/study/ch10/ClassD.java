package com.korit.study.ch10;

public class ClassD {
    final String name;  // 대입 후 변경하지 않아도 괜찮은 값 그리고 필수로 받아와야 하는 값에 final붙임
    int age;
    String address;

    ClassD(String name){ // final을 이용하여 상수를 받아오면 최초한번 값을 받아오고 수정이 불가 하다
        this.name = name; // final이 붙어 상수로 받아오기 위해서는 생성할 때 매개변수로 초기화 해주어야한다.
    }



}
