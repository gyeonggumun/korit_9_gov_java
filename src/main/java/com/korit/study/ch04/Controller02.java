package com.korit.study.ch04;

import java.util.Scanner;

public class Controller02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("이름: ");
        String name = scanner.nextLine();

        switch (name) {
            case "김준일" :
                System.out.println("1");
                break;
            case "김준이" :
                System.out.println("2");
                break;
            case "김준삼" :
                System.out.println("3");
                break;
            default:
                System.out.println("나머지");
        }
    }
}
