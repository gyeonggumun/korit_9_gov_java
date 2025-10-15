package com.korit.study.ch01;

import java.util.Date;

/**
 *
 */
public class Type {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
//      논리 자료형
        boolean open;
        open = true;
        System.out.println(open);
        open = false;
        System.out.println(open);

//      문자 자료형
        char lastName = '김';
        System.out.println(lastName);
//        char firstName = '준일';

//      문자열 자료형
        String firstName = "준일";
        System.out.println(firstName);
//      줄 나누기
        String contents1 = "안녕하세요. \n김준일입니다.";
        System.out.println(contents1);
        String contents2 = """
                안녕하세요.
                김준일입니다.""";
        System.out.println(contents2);
//      숫자
        double avg = 89.33;
        System.out.println(avg);
        int number = 1000000;
        System.out.println(number);
        long nowTime = (int) new Date().getTime();
        System.out.println(nowTime);
        long longNumber = 220000000l;
        System.out.println(longNumber);
    }
}
