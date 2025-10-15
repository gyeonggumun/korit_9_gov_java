package com.korit.study.ch04;

import java.util.Scanner;

public class Controller06 {
    public static void main(String[] args) {
        // 중첩 반복
//        for (int i = 0; i < 5; i++) {
//            System.out.println("i = " + i);
//            for (int j = 0; j < i; j++) {
//                System.out.println("j = " + j);
//            }
//        }

        //구구단
        Scanner scanner = new Scanner(System.in);
        int startDan = scanner.nextInt();
        int endDan = scanner.nextInt();

        int danRange = endDan - startDan + 1;

        for (int i = 0; i < danRange; i++) {
            int dan = (endDan - i);
            System.out.println(dan + "단");
            for (int j = 0; j < 9 ; j++) {
                int num = 9 - j;
                System.out.printf("%d X %d = %d\n", dan, num, dan * num);
            }
        }
//        for (int i = 0; i <= (endDan - startDan); i++) {
//            int num = startDan + i + 1;
//            System.out.println((num -1) + "단");
//
//            for (int j = 0; j < 9; j++) {
//                int n = j +1;
//                System.out.printf("%d X %d = %d\n", (num-1), n, n*(num-1));
//            }
//        }

//        for (int i = 1; i <= 9; i++){
//            for (int j = 1; j <= 9; j++){
//                System.out.printf("%d X %d = %d\n", i, j, i*j );
//            }
//        }

    }
}
