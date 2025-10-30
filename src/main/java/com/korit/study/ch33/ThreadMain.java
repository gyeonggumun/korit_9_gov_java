package com.korit.study.ch33;

import com.korit.study.ch22.util.PasswordEncoder;

class Counter {
    private int count = 0;
    // synchronized : 쓰레드를 동기화 해주지만 성능이 저하됨으로 상황에 맞게 사용
    public synchronized void increment () {
        count++;
    }

    public synchronized void decrement() {
        count--;
    }

    public synchronized int getCount() {
        return count;
    }

}

public class ThreadMain {
    public static void main(String[] args) {
        /**
         * Thread (쓰레드)
         * 1. 싱글쓰레드 : 쓰레드 하나만 사용의 의미(main메서드 하나만 사용)
         * 2. 멀티쓰레드 : 쓰레드 두개 이상 사용
         */

        Counter counter = new Counter();
        Thread thread1 = new Thread(() -> {
            for (int i =0; i < 10000; i++) {
                System.out.println("1번 반복문: " + i);
                counter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i =0; i < 10000; i++) {
                System.out.println("2번 반복문: " + i);
                counter.increment();
            }
        });

        System.out.println("쓰레드 시작!!!");

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();  // join 해주지 않으면 thread가 끝나기 전에 다음 실행문을 실행시켜버리는 문제점이 생김
            // 여기부터 Thread1 과 Thread2가 종료될 때까지 기다려라
            System.out.println(counter.getCount());
            System.out.println("쓰레드 종료!!!");
        } catch (InterruptedException e) {
            System.out.println("오류");
        }




    }
}
