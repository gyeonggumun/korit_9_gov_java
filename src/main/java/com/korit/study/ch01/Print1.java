package com.korit.study.ch01;

public class Print1 {
    public static void main(String[] args) {


        int num1 = 14;
        double num2 = 3.14;
//        double num4 = num1;
//        num1을 자동으로 double로 형 변환 해준
//        int num3 = (double) num2;
//        자동 형 변환을 할 수 없는 역방향! 컴파일 에러 발생!
        int num4 = (int) num2;
        System.out.println(num4);

        int i = 100;
        char c = 'a';
        int j = c;   //char형에서 int형으로 자동 변환
        double d = i;   // int형에서 double형으로 자동변환

        System.out.println("int형 변수 j의 값 :" + j);
        System.out.println("double형 변수 d의 값 :" + d);













    }
}
