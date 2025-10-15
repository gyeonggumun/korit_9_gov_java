package com.korit.study.ch09;

public class Product {
    String name;
    int price;

    int discount() {
        return (int) (price - (price * 0.2));
    }

    void printInfo () {
        System.out.println("상품명: " + name);
        System.out.println("원가: " + price);
        System.out.println("할인가: " + discount());
    }

}
