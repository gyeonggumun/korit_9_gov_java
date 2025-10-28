package com.korit.study.ch29;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

// 람다 메서드 참조
// 람다식을 간결하게 표현하는 방법 (:: 더블콜론)
// 호출 구조가 기존의 메서드와 완전히 동일하면 가능
// (매개변수) -> 메서드(매개변수)
class StrPrinter {
    public static void print(String str) {
        System.out.println(str);
    }
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class LambdaMethodReference {
    public static void main(String[] args) {
        Consumer<String> stringConsumer = (s) -> System.out.println(s);
        stringConsumer.accept("람다 메서드 참조");

        Consumer<String> stringConsumer2 = (s) -> StrPrinter.print(s);
        stringConsumer2.accept("람다 메서드 참조");

        Consumer<String> stringConsumer3 = System.out::println;
        stringConsumer3.accept("람다 메서드 참조");

        Consumer<String> stringConsumer4 = StrPrinter::print;
        stringConsumer4.accept("람다 메서드 참조");

        // 람다 생성자 참조
        Supplier<List<String>> listSupplier = () -> new ArrayList<>();
        List<String> stringList = listSupplier.get();

        Supplier<List<String>> listSupplier2 = ArrayList::new;  // 매개변수를 받지 않는 생성자 생성
        List<String> stringList2 = listSupplier.get();

        BiFunction<String, Integer, Student> biFunction1 = (name, age) -> new Student(name, age);
        Student student1 = biFunction1.apply("김준일", 32);

        BiFunction<String, Integer, Student> biFunction2 = Student::new;
        Student student2 = biFunction2.apply("김준일", 32);

        System.out.println(student1);
        System.out.println(student2);

        Function<String, Integer> strToInt = Integer::parseInt;
        Integer num = strToInt.apply("100");
        System.out.println(num);

        Integer num2 = Integer.parseInt("100");

        List<String> strNums = List.of("10", "20", "30");
        Integer sumResult = 0;
        for (String str : strNums) {
            sumResult += Integer.parseInt(str);
        }
        System.out.println(sumResult);

        AtomicInteger atomicSumResult = new AtomicInteger(0);
        strNums.forEach(str -> atomicSumResult.set(atomicSumResult.get() + Integer.parseInt(str)));
        System.out.println(atomicSumResult.get());

        atomicSumResult.set(0);
        strNums.stream()
                // strNums에서 하나씩 꺼내서 Integer안에있는 parseInt메서드를 사용하겠다 => 정수 값으로 바꾸겠다
                .map(Integer::parseInt)
                .collect(Collectors.toList())
                .forEach(n -> atomicSumResult.set(atomicSumResult.get() + n));
        System.out.println(atomicSumResult.get());
    }
}
