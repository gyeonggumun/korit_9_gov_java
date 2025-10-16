package com.korit.study.ch20;

public class Factory {
    private static int id;
    private String name;

    public Factory(String name) {
        this.name = name;
    }

    // 상품이 들어올 때 마다 id를 1씩 증가 시키는 코드
    public Product createProduct(String name) {
        return new Product(++id, name);
    }

    @Override
    public String toString() {
        return "Factory{" +
                "name='" + name + '\'' +
                '}';
    }

}
