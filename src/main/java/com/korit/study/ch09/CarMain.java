package com.korit.study.ch09;





class Car {
    String model;
    String color;
}


public class CarMain {

    public static void main(String[] args) {
        String modal1 = "소나타";
        String color1 = "검정색";
        String modal2 = "아반떼";
        String color2 = "파랑색";
        String[] models = new String[100000];
        String[] colors = new String[100000];
        models[99954] = "소나타";
        colors[99954] = "검정색";

        Car c1 = new Car();
        c1.model = "소나타";
        c1.color = "검정색";

        Car c2 = new Car();
        c2.model = "아반떼";
        c2.color = "파랑색";

        Car c3 = new Car();
        System.out.println(c3.model);
//        인스턴스는 기본값으로 자동 초기화 하기 때문에 따로 초기화 해주지 않아도 됨
//         int = 0, double = 0.0, String = null, char = \u0000, boolean = false

        int a = 10;
        System.out.println(a);
    }

}
