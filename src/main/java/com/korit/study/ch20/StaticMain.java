package com.korit.study.ch20;

import com.korit.study.ch01.Casting;

public class StaticMain {
    public static void main(String[] args) {

        StaticStudy staticStudy = new StaticStudy(); // 동적 메모리 할당
        staticStudy.print("문경구");  // 동적 메모리 출력
        new StaticStudy().print("국비수업"); // 정적 메모리 할당 및 출력
        StaticStudy.print("스태틱 테스트");   // static 정의를 하였기 때문에 정적 메모리여서 그냥 사용할 수 있음
        Casting.main(null);  // 스태틱을 이용하여 main을 출력하기 때문에 다른 곳에서 정적 메모리를 받아 올 수 있다.
        staticStudy.age = 10; // 생성해야지만 사용이 가능한 번수
        System.out.println(staticStudy.age);
        System.out.println(staticStudy.age2);  // age2가 static 변수이기 때문에 기본값으로 출력
        StaticStudy.age2 = 20; // static을 사용한 변수는 새로 정의하여 할당하지 않아도 사용가능
        System.out.println(StaticStudy.age2);
        staticStudy.age2 = 30;
        System.out.println(StaticStudy.age2);  // 생성된것이 아닌 변수를 공유하기 때문에
        // 다른 생성자로 변수에 값을 넣어도 그 값이 공유된다.
        StaticStudy s2 = new StaticStudy();
        s2.age2 = 50;
        System.out.println(staticStudy.age2);

    }
}
