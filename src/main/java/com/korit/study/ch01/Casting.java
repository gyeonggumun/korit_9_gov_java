package com.korit.study.ch01;

public class Casting {
    public static void main(String[] args) {
//      묵시적 형변환(업캐스팅)
        byte n1 = 10;
        short n2 = n1;
        int n3 = n2;
        long n4 = n3;
        float n5 = n4;
        double n6 = n5;
        System.out.println(n6);

//      명시적 형변환(다운캐스팅)
        double n7 = 10.0;
        float n8 = (float) n7;
        long n9 = (long) n8;
        int n10 = (int) n9;
        short n11 = (short) n10;
        byte n12 = (byte) n11;
        System.out.println(n12);

//        상수
        final String uploadPath = "~/upload/image";
        final String UPLOAD_PATH = "~/upload/image";
    }
}
