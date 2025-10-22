package com.korit.study.ch24;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CollectionMain {
    public static void main(String[] args) {
        // 문자열을 담을 수 있는 ArrayList 생성
        List<String> list = new ArrayList<>(); // new한 후 머가 오냐에 따라서 List가 Array, Linked중 선택이 되는 것

        // 값을 추가
        list.add("문자열 값1");
        list.add("문자열 값2");

        // 값을 가져오기
        String str1 = list.get(0);
        String str2 = list.get(1);

        // 값을 수정
        String str3 = list.set(1, "문자열 값3");
        System.out.println(str3);

        // 값 삭제
        boolean removed = list.remove("문자열 값1");
        String str4 = list.remove(0);
        System.out.println(removed);
        System.out.println(str4);

        // 리스트의 크기(사이즈)
        int size = list.size();

        // 리스트 안에 값이 포함되어 있는지 확인
        list.add("10");
        list.add("20");
        list.add("30");
        list.add("30");
        list.add("30");
        System.out.println(list.contains("50"));

        // 리스트 안에서 값이 위치하고 있는 Index를 찾기
        int indexOf30 = list.indexOf("30"); // 앞에서 부터 찾음
        System.out.println(indexOf30);

        // 중간에 위치하고 있는 데이터 30의 index를 찾는 방법
        int start = list.indexOf("30") + 1;
        indexOf30 = -1;
        for (int i = start; i < list.size(); i++) {
            if (list.get(i).equals("30")) {
                indexOf30 = i;
                break;
            }
        }
        System.out.println(indexOf30);

        // 뒤에서 부터 찾음
        indexOf30 = list.lastIndexOf("30");
        System.out.println(indexOf30);

        // 리스트 자르기
        List<String> subList = list.subList(list.indexOf("30"), list.size());
        subList.indexOf("30");
        subList.add("40");
        System.out.println(subList);

        List<String> linkedList = new LinkedList<>();
        linkedList.add("10");
        linkedList.add("20");
        linkedList.add("30");
        linkedList.add("40");
        linkedList.indexOf("30");

    }
}
