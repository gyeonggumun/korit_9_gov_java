package com.korit.study.ch23;

public class Generic<T, T2> {
    private T data;
    private T data2;
    private T2 data4;
    private double data3;

    public Generic(T data, T data2, T2 data4, double data3) {
        this.data = data;
        this.data2 = data2;
        this.data4 = data4;
        this.data3 = data3;
    }
}
