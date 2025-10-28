package com.korit.study.ch29;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.*;
import java.util.stream.Collectors;

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

        // forEach()
        List<String> nameList = List.of("김준일", "김준이");
        nameList.forEach(n -> System.out.println(n));
        nameList.forEach(System.out :: println);  // 더블 콜론 => 람다 메서드 참조

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

        // 5. 매개변수 o, 리턴 Boolean
        String searchUsername = "test1234";
        Predicate<List<Map<String, String>>> listPredicate = list -> {
            AtomicBoolean isFound = new AtomicBoolean(false);
            list.forEach(map -> {
               if (map.get("username").equals(searchUsername)) {
                   isFound.set(true);
               }
           });
            return isFound.get();
        };
        List<Map<String, String>> userList = List.of(
                Map.of("username", "test1", "password", "1111"),
                Map.of("username", "test12", "password", "2222"),
                Map.of("username", "test123", "password", "3333"),
                Map.of("username", "test1234", "password", "4444")
        );
        System.out.println(listPredicate.test(userList));

        List<String> names = List.of("김준일", "김준이", "이준일", "이준이");
        String startedLastName = "이";
        List<String> filteringNames = names.stream()
                .filter(name -> name.startsWith(startedLastName))
                .collect(Collectors.toList());

        System.out.println(names);
        System.out.println(filteringNames);

        String foundName = names.stream()
                .filter(name -> name.equals("김준이"))
                .collect(Collectors.toList())
                .getFirst();
        System.out.println(foundName);

        // 매개변수 o, 리턴 o 둘의 자료형이 동일한 경우
        Function<String, String> f2 = s -> s + "문자열";  // f1, f2가 동일
        BiFunction<String, String, String> f3 = (s1, s2) -> s1 + s2; // f3, f4가 동일
        UnaryOperator<String> f1 = s -> s + "문자열";
        BinaryOperator<String> f4 = (s1, s2) -> s1 + s2;

    }
}
