package com.korit.study.ch23;

public class NonGeneric {
    // Object를 자료형으로 변수를 선언하면 따라오는 문제 (평등하게 Object로 처리)
    // Object를 자료형으로 변수를 선언했다는 것은 업캐스팅을 했다는 것이기 때문에
    // 원래 자료형들이 고유로 가지고 있던 역할들을 수행하지 못할 수 있다는 문제가 있음 (디테일 문제)
    private Object data;

    public NonGeneric(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "NonGeneric{" +
                "data='" + data + '\'' +
                '}';
    }
}
