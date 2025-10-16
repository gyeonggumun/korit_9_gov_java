package com.korit.study.ch19;

import java.util.Objects;

public class Car {
    private String model;
    private String color;

    public Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    // Car클래스를 가지고 있는 객체가 Object로 업캐스팅이 일어난 상태로 함수에 들어옴
    // equals문은 비교를 해야하기 때문에 엄캐스팅하여 들어온 객체를 원래 객채와 같은지 먼저 비교하고
    // 변수에 대입을 하여 다운 캐스팅까지 완료하여 비교를 하는 형태의 코드
    // Collections 와 같은 Util함수들이 많음 먼가 필요한게 있으면 Util함수에서 찾아 볼 것

    @Override
//    public boolean equals(Object o) {
//        if (!(o instanceof Car car)) return false;
//        return Objects.equals(model, car.model) && Objects.equals(color, car.color);
//    }
//    위 항목을 풀어 해석한 함수
//    public boolean equals(Object o) {
//        if(!(o instanceof Car)) {
//            return false;
//        }
//        Car car = (Car) o;
//        return Objects.equals(model, car.model) && Objects.equals(color, car.color);
//    }

//    자바 리플렉션 : 고급단계
//    instanseof를 없애려고 했던 이유
//    Class class를 사용하면 할 수 있는 행위를 instanseof가 또 하고 있어서 사용하려 했으나
//    사용량이 너무 많아 없애지 못함
    public boolean equals(Object o) {
        if(o.getClass() != Car.class) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(model, car.model) && Objects.equals(color, car.color);
    }


    @Override
    public int hashCode() {
        return Objects.hash(model, color);
    }

    // 객채를 생성하고 값을 넣을 때 값을 확인하는 용도로 주로 사용됨
    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }




}
