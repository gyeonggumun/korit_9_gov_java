package com.korit.study.ch03;

import java.util.Scanner;

public class Input02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1번 주소와 2번 주소를 입력하세요: ");
        String address1 = scanner.next();
        String address2 = scanner.next();
        System.out.println("주소1: " + address1);
        System.out.println("주소2: " + address2);
        int num1 = Integer.parseInt(scanner.next());
        int num2 = Integer.parseInt(scanner.next());
        System.out.println("num1 + num2 = " + (num1 + num2));
        int num3 = scanner.nextInt();
        int num4 = scanner.nextInt();
        System.out.println("num3 + num4 = " + (num3 + num4));
        scanner.nextLine();
        String addressAll = scanner.nextLine();
        System.out.println("전체 주소: " + addressAll);


    }
}
