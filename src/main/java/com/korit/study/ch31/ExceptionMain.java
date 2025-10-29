package com.korit.study.ch31;

import java.util.List;

/**
 *  예외처리 (Exception or Error)
 *  Throwable -> Compile Error(실행 전), Runtime Error(실행 중)
 *  실행 전(사용자 제어 불가) -> OutOfMemoryError (메모리 공간 부족), stackoverflowError ()
 *  실행 중(사용자 제어 가능) -> RuntimeException(실행 중 예외)을 상속 받은 모든 Exception(오류)
 */

public class ExceptionMain {
    public static void main(String[] args) {
        int count = 0;
        while (true) {
            String name = "김준일";
            if (count == 10) {
                name = null;
            }
            try {
                System.out.println(name.startsWith("김"));
            } catch (NullPointerException e) {
                e.printStackTrace(); // 어떤 예외가 문제들이 생겼는지 오류가 생겼는지를 알려주는 코드
                break;
            }
            count++;
        }
        System.out.println("프로그램 정상 종료");

        String[] names = {"김준일", "김준이"};
        try {
            for (int i = 0; i < names.length + 1; i++) {
                System.out.println(names[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        System.out.println("프로그램 정상 종료");
        try {
            printAll(List.of(10, 20, 30, 40), 5);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void printAll(List<Integer> nums, int size) {
            for (int i = 0; i < size; i++) {
                System.out.println(nums.get(i));
        }
    }
}
