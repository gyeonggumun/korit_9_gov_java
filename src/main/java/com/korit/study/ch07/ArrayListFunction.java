package com.korit.study.ch07;

import java.util.Scanner;

public class ArrayListFunction {

    public static void printNameAll(String[] names){
        if (names.length == 0) {
            System.out.println("등록된 이름이 없습니다");
        } else {
            for (int i = 0; i < names.length; i++) {
                System.out.println("이름(" + i + "):" + names[i]);
            }
        }
    }

    public static String[] addToArray (String value, String[] curentArray) {  // 매개변수 -> 내가 추가하고싶은 값의 자료형으로 변환
        String[] newArray = new String[curentArray.length + 1];
        for(int i = 0; i < curentArray.length; i++) {
            newArray[i] = curentArray[i];
        }
        newArray[newArray.length - 1] = value;
        return newArray;
    }

    public static String inputName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("이름입력: ");
        return scanner.nextLine();
    }

    public static String[] addInputNameToNames(String[] names) {
        String name = inputName();
        return addToArray(name, names);
    }

    public static void main(String[] args) {

        String[] names = new String[0];

        int num =  3;
        printNameAll(names);
        for (int i = 0; i < num; i++) {
            names = addInputNameToNames(names);
            printNameAll(names);
        }

    }




}
