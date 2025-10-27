package com.korit.study.ch29;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaInterface {
    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable 인터페이스");
            }
        };
        runnable.run();
        Runnable runnable2 = () -> {
            System.out.println("runnable 인터페이스");
        };
        runnable2.run();

        // 2. 매개변수 o, 리턴 x
        Consumer<String> stringConsumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("consumer 인터페이스");
                System.out.println("매개변수 s: " + s);
            }
        };
        stringConsumer.accept("consumer");

        Consumer<String> stringConsumer2 = s -> {
            System.out.println("consumer 인터페이스");
            System.out.println("매개변수 s: " + s);
        };
        stringConsumer2.accept("consumer");

        Consumer<Integer> andThenStudy = num -> {
            System.out.println("1");
            System.out.println(num);
        };
        // andThenStudy2에 andThen의 호출결과를 닮는 행위
        Consumer<Integer> andThenStudy2 = andThenStudy.andThen(num2 -> {
            System.out.println("2");
            System.out.println(num2);
        });

        andThenStudy.accept(10);
        andThenStudy2.accept(20);

        Consumer<Double> doubleConsumer = (d -> {
            System.out.println("1");
            System.out.println("숫자: " + d);
        });
        doubleConsumer.andThen(d -> {
            System.out.println("2");
            System.out.println("숫자: " + d);
        }).andThen(d -> {
            System.out.println("3");
            System.out.println("숫자: " + d);
        }).andThen(d -> {
            System.out.println("4");
            System.out.println("숫자: " + d);
        }).accept(3.14);

        // 3. 매개변수 x, 리턴 o
        String str = null;
        Supplier<Boolean> booleanSupplier = () -> Objects.isNull(str);
        System.out.println(booleanSupplier.get());

        // 4. 매개변수 o, 리턴 o
        Function<Integer, String> function = num -> "num: " + num; // 매개변수 int , 리턴자료형 String
        String functionResult = function.apply(10);
        System.out.println(functionResult);

        String functionResult2 = function.andThen(num -> "num2: " + num).apply(20); // 매개변수 String, 리턴자료형 String
        System.out.println(functionResult2);


        String functionResult3 = function.compose(d -> {
            System.out.println("실수자료형을 정수로 리턴");
            return ((Double) d).intValue();
        }).apply(20.5);  // double 자료형 20.5가 d로 들어가서 intValue로 변환한 후 function에서 처리
        System.out.println(functionResult3);



    }
}
