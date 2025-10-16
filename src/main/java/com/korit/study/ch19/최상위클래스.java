package com.korit.study.ch19;

import java.util.Scanner;

public class 최상위클래스 {
    public static void main(String[] args) {
        int a = 10;
        double b = a;
        Object c = a;
        Object d = b;
        Object e = "test";
        String f = "abc";
        Car car = new Car("k3", "화이트");
        Car car2 = new Car("k3", "화이트");
        Car2 car3 = new Car2("k3", "화이트");

        System.out.println(car.equals(car3));  // 두 변수들의 자료형이 다름으로 false가 나옴
        System.out.println(car.hashCode() == car3.hashCode());
        // hashCode 값을 입력받아 확인을 하면 안의 값이 같음으로 true
        // eqals와 hashCode가 같이 생성되는 이유는 컴퓨터의 부담을 덜어주기 위해
        // hashCode로 값을 먼저 검사한 후 eqals를 사용하여 정확히 일치하는지 확인하기 위함

        System.out.println(car.equals(car2));
        Object g = car;
        System.out.println(car);
//        System.out.println(c + d);

        // name1 과 name2는 주소가 동일함
        String name1 = "김준일";
        String name2 = "김준일";
        boolean result1 = name1 == name2;
        System.out.println(result1);

        // 변수 선언 방식이 달라지면실행결과와 주소 값이 다르기 때문에
        // 그냥 등호를 사용하여 비교를 하면 주소값을 비교하기 때문에 false가 뜨서
        // equals를 사용하여 문자열을 비교해야 정환한 결과 값을 확인 할 수 있다.
        String name3 = new String("김준일");
        System.out.println(name3 + " 입니다.");
        Scanner scanner = new Scanner(System.in);
        String name4 = scanner.nextLine();
        System.out.println(name4);
        boolean result2 = name1.equals(name3);
        System.out.println(result2);
        boolean result3 = name2.equals(name4);
        System.out.println(result3);

    }
}
