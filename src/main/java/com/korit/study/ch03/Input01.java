package com.korit.study.ch03;

import java.io.InputStream;
import java.util.Scanner;

public class Input01 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        Scanner s = new Scanner(inputStream);
        String str = s.nextLine();
        System.out.println(String.format("입력값: %s", str));
        String address = s.nextLine();
        System.out.println("주소: " + address);
        System.out.println();

    }
}
