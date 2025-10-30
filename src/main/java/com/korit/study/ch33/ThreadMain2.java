package com.korit.study.ch33;

class ThreadTest extends Thread {
    private String threadName;

    public ThreadTest(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println(threadName + "실행");;
    }
}

public class ThreadMain2 {
    public static void main(String[] args) throws InterruptedException {
        ThreadTest t1 = new ThreadTest("t1");
        ThreadTest t2 = new ThreadTest("t2");
        ThreadTest t3 = new ThreadTest("t3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("main method exit");


    }

}
