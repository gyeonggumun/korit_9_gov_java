package com.korit.study.ch06;

public class 연습문제3 {

    public static void main(String[] args) {
        checkTemperatureConversion(32.7);
        calculate(10,20,50,40);
    }

    // 섭씨를 화씨로 변환하는 함수
    public static double celsiusToFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }

    // 화씨를 섭씨로 변환하는 함수
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    // 섭씨 온도를 받아서 화씨로 변환한 후, 다시 섭씨로 변환하여
    // 원래 값이 맞는지 확인하는 함수를 작성하세요
    public static void checkTemperatureConversion(double celsius) {
        double fahrenheit = celsiusToFahrenheit(celsius);
        double celsius2 = fahrenheitToCelsius(fahrenheit);
        System.out.println(celsius2 == celsius ? true : false);
    }

    public static int add(int a, int b) {
        return a + b;
    }
    public static int multiply(int a, int b) {
        return a * b;
    }
    public static int subtract(int a, int b) {
        return a - b;
    }
//     (a + b) * c - d 를 계산하는 함수를
//      위의 함수들을 이용해서 작성하세요
    public static int calculate(int a, int b, int c, int d) {
        int addResult = add(a, b);
        int mulResult = multiply(addResult, c);
        int subResult = subtract(mulResult, d);
        System.out.println(subResult);
        return subResult;
    }

}
