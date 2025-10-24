package com.korit.study.ch28;

import java.util.concurrent.atomic.AtomicInteger;

public class AnonymousClassMain {
    public static void main(String[] args) {
        AnonymousClass a = new AnonymousClassImpl();
        a.fx1();
        System.out.println(a.fx2());

        int num = 10;
        // anonymous를 사용할 때는 atomic을 이용하여야 생성하며
        // 라킹을 이용하여 동시성을 해결해줌
        // 값을 변경해야 한다면 atomic을 이용
        AtomicInteger num2 = new AtomicInteger(10);
        // 익명 클래스
        AnonymousClass b = new AnonymousClass() {
            @Override
            public void fx1() {

                System.out.println(num);
                num2.set(num2.get() + 10);
            }

            @Override
            public int fx2() {
                return 0;
            }
        };
    }
}
