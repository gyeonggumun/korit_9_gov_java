package com.korit.study.ch33;

public class ThreadMain {
    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            for (int i =0; i < 10; i++) {
                System.out.println("1번 반복문: " + i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i =0; i < 10; i++) {
                System.out.println("2번 반복문: " + i);
            }
        });

        System.out.println("쓰레드 시작!!!");

        thread1.start();
        thread2.start();

        System.out.println("쓰레드 종료!!!");


    }
}
