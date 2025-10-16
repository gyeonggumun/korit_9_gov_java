package com.korit.study.ch20;

public class StaticStudy {

    // static 변수는 개별적으로 사용하는 것이 아니라
    // 공유를 하기 때문에 값을 할당하면
    // 다른 곳에서 사용을 할 때도 그 값을 공유해서 사용 함
    int age;
    static int age2;


    public static void print(String str) {
        System.out.println("문자열 출력: " + str);
    }

    public void print2 () {
        System.out.println(age);
    }

    public static void print3 () {
//        System.out.println(age);
        System.out.println(age2);
    }



}
