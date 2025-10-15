package com.korit.study.ch15;

public class 푸들 extends 강아지 {
    푸들(String 이름) {
        super(이름); // 나의 상위 객체로 값을 넘김
        System.out.println("푸들 생성자: " + 이름);
    }

    // 상속을 하는데 정의를 하위 객체에서 하면 재정의 하여 상위 객체가 정의 한 것을 덮어 씌움
    void 먹다 () {
        System.out.println("먹다 오버라이드");
    }


}
