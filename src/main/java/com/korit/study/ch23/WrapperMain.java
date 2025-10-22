package com.korit.study.ch23;

public class WrapperMain {
    public static void main(String[] args) {
        // 동일한 일반 자료형을 참조 자료형에 대입하는 것
        int num = 10;
        Integer num2 = num;  // autoBoxing
//        Integer num2 = new Integer(10);과 같은 걔념  => 9버전 이상부터 지원 중단
        int num20 = num2;  // autoUnBoxing
        String numStr = Integer.toString(num);
        String numStr2 = "" + num;
        String numStr3 = num2.toString();

        double num3 = 3.14;
        Double num4 = num3;

        long num5 = 20;
        Long num6 = num5;

        short num7 = 30;
        Short num8 = num7;

        float num9 = 2;
        Float num10 = num9;

        byte num11 = 3;
        Byte num12 = num11;

        boolean boo = true;
        Boolean boo2 = boo;

        char ch = 'A';
        Character ch2 = ch;


    }
}
