package com.korit.study.ch04;

public class Controller04 {
    public static void main(String[] args) {


        for (int i = 3; i < 100; i++) {
            if (i % 4 == 0) {
                System.out.println(i);
            }

        }

        for (int i = 0; i < 20; i++) {

            int n = i + 1;

            System.out.printf("%,d = %s\n", n, n % 2 == 0 ? "짝" : "홀");

            if (n % 2 == 0) {
                System.out.println(n +"짝");
            } else {
                System.out.println(n +"홀");
            }

            if (n % 2 == 0) {
                System.out.println(n +"짝");
                continue;   // 밑에 있는 코드가 실행 되지 않을 때만 사용
            }
            System.out.println(n +"홀");


        }

//        int i = 0;
//        while (i < 5) {
//            System.out.println(i);
//            i++;
//        }


    }
}
