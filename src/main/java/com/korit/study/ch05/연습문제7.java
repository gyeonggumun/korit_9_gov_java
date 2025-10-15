package com.korit.study.ch05;

public class 연습문제7 {
    public static void main(String[] args) {
        int[] 기본급 = {10000, 20000, 30000};
        double 세율 = 0.15;
        int[] 지급액 = new int[3];

        for (int j = 0; j < 기본급.length; j++) {
            double 세금 = 기본급[j] * 세율;
            지급액[j] =  (int) (기본급[j] - 세금);
        }

        for (int i = 0; i < 지급액.length; i++) {
            System.out.println(지급액[i]);
        }
    }
}
