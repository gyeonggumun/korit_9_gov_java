package com.korit.study.ch06;

import java.util.Date;

public class 연습문제1 {

    public static void main(String[] args) {
        hello();
        hello("김준일");
        square(4);

    }

    public static void hello () {
        System.out.println("안녕하세요");
    }

    public static void hello (String name) {
        System.out.println("안녕하세요 " + name + "님");
    }

    public static int square (int number) {
        return number * number;
    }

    public static String isNowTime(int hours, int minutes) {
        Date now = new Date();
        int nowHours = now.getHours();
        int nowMinutes = now.getMinutes();
        return hours == nowHours && minutes == nowMinutes ? "현재 시간입니다." : "현재 시간이 아닙니다.";
    }


}
