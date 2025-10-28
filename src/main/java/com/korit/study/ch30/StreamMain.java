package com.korit.study.ch30;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream(흐름)    -> 한번 사용하면 다시 쓰지 못함
 * 1. 생성         - 스트림 객체 생성
 * 2. 중간 연산     - 변환, 필터링 (반복)
 * 3. 최종 연산     - 결과 도출 (반복)  forEach(), collect(), count()
 * 배열, List, Map과 같이 데이터가 여러개 있어 반복 작업을 해야하는 경우 Stream사용 가능
 */

public class StreamMain {
    public static void main(String[] args) {
        Stream<String> strStream = Stream.of("a", "b", "c");
//        System.out.println(strStream.collect(Collectors.toList())); // Stream을 List로 변환 -> 리턴자료형 List

//        long c = strStream.count(); // 갯수를 세는 함수이기 때문에 size와 같음
//        System.out.println(c);
        strStream.forEach(System.out::println);   // 출력하는 코드
        strStream = Stream.of("a", "b", "c");
        strStream.forEach(System.out::println);  // 스트림은 한번사용하면 다시 사용하지 못하기 때문에 재 정의 해주고 사용해야함

        // 스트림 객체 생성

        // 1. Stream 인터페이스의 static 메서드를 통해 생성
        // add해서 Stream을 생성하면 기본적으로 자료형을 Object로 가진다
        // builder앞에 자료형을 명시해주면 그 자료형으로 변환되어 따로 형변환하지 않아도 됨
        Stream<String> stream = Stream.<String>builder()
                .add("a")
                .add("b")
                .add("c")
                .build();
        // 기본적인 Stream.of를 이용한 생성
        Stream<String> stream2 = Stream.of("a", "b", "c");
        // Stream.of와 같은 값으로 생성하는 방법
        // 2. 배열 또는 컬렉션을 Stream으로 변환하여 생성
        Stream<String> stream3 = Arrays.stream(new String[]{"a", "b", "c"});
        Stream<String> stream4 = List.of("a", "b", "c").stream();
        Stream<String> stream5 = Set.of("a", "b", "c").stream();
        Stream<String> stream6 = Map.of("a", "1", "b", "2", "c", "3").keySet().stream();
        Stream<String> stream7 = Map.of("a", "1", "b", "2", "c", "3").values().stream();
        Stream<Map.Entry<String, String>> stream8 = Map.of("a", "1", "b", "2", "c", "3").entrySet().stream();

        List<String> names = List.of("김준일", "김준이");
        List<String> lastNames = new ArrayList<>();
        for (String name : names) {
            String lastName = name.substring(0, 1);  // 문자열의 0번째부터 1번째전까지 lastName에 담음
            char lastName2 = name.charAt(0);  // 문자로 변환하여 첫번째 자리만 lastName2에 담음
            lastNames.add(lastName);  // lastNames라는 리스트의 0번째 인덱스 부터 lastName에 입는 값을 추가
        }
        lastNames.forEach(System.out::println);
        // Stream처리 버전
        /// /////////////////////////////////////////////////////////////////////////////////
        Stream<String> nameStream1 = names.stream();
        Stream<String> nameStream2 = nameStream1.map(name -> name.substring(0, 1));
        List<String> names2 = nameStream2.collect(Collectors.toList());
        names2.forEach(System.out::println);
        /// //////////////////////////////////////////////////////////////////////////////////////
        names.stream()
                .map(name -> name.substring(0, 1))  // name.substring을 실행해서 names에 다시 담는 행위
                .collect(Collectors.toList())     //리스트로 변환
                .forEach(System.out::println);   // 출력
        /// //////////////////////////////////////////////////////////////////////////////////////////
        // 양쪽에 대괄호를 추가하는 행위
        Stream<String> nameStream3 = names.stream();
        Stream<String> nameStream4 = nameStream3.map(name -> name.substring(0, 1));
        Stream<String> nameStream5 = nameStream4.map(name -> "[" + name + "]"); // 중간과정은 얼마든지 추가해도 문제가 없음
        List<String> names3 = nameStream5.collect(Collectors.toList());
        names3.forEach(System.out::println);

        // 중간 연산 map(), filter()
        // 1. map() 변환, 치환
        List<String> strNums = List.of("11", "20", "31");
        List<Integer> nums = StreamMap.map(strNums, strNum -> {
            int n = Integer.parseInt(strNum);
            if (n % 2 == 0){
                return n * 10;
            }
            return n;
        });
        System.out.println(nums);

        // 2. filter() 분류
        List<Integer> odds = nums.stream()
                .filter(num -> num % 2 != 0)
                .toList();
        System.out.println(odds);

    }
    class StreamMap {
        // 제네릭을 static메서드에 사용할 때는 자료형을 추론 할 수 있도록 설계를 해야함
        public static <T, R> List<R> map(List<T> list, Function<T, R> action) {
            Objects.requireNonNull(list);  // null체크
            Objects.requireNonNull(action);
            List<R> rList = new ArrayList<>();
            for (T t : list) {
                rList.add(action.apply(t));
            }
            return rList;
        }
    }
}
