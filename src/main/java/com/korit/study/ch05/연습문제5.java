package com.korit.study.ch05;

public class 연습문제5 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 3, 1, 3, 3};
        int[] arr1 = new int[0];    //1들만 모으기
        int[] arr2 = new int[0];    //2들만 모으기
        int[] arr3 = new int[0];    //3들만 모으기

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                int[] temp = new int[arr1.length + 1];
                for (int j = 0; j < arr1.length; j++){
                    temp[j] = arr1[j];
                }
                temp[temp.length - 1] = nums[i];
                arr1 = temp;
            } else if (nums[i] == 2) {
                int[] temp = new int[arr2.length + 1];
                for (int j = 0; j < arr2.length; j++){
                    temp[j] = arr2[j];
                }
                temp[temp.length - 1] = nums[i];
                arr2 = temp;
            } else if (nums[i] == 3) {
                int[] temp = new int[arr3.length + 1];
                for (int j = 0; j < arr3.length; j++){
                    temp[j] = arr3[j];
                }
                temp[temp.length - 1] = nums[i];
                arr3 = temp;
            }
        }

        for (int i = 0; i < arr1.length; i++) {
            System.out.println("arr1[" + i + "]: " +arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            System.out.println("arr2[" + i + "]: " +arr2[i]);
        }
        for (int i = 0; i < arr3.length; i++) {
            System.out.println("arr3[" + i + "]: " +arr3[i]);
        }



    }
}
