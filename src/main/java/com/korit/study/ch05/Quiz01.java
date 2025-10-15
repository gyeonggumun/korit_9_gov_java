package com.korit.study.ch05;

import java.util.Scanner;

public class Quiz01 {
    public static void main(String[] args) {
        int[] nums = new int[]{10, 20, 30, 40, 50};
        for (int i = 0; i < 5; i++) {
            System.out.println(nums[i]);
        }


        int[] nums2 = new int[]{5, 10, 15, 20, 25};
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum = sum + nums2[i];
        }
        System.out.println("배열 요소들의 합: " + sum);

        int[] nums3 = new int[]{23, 45, 12, 67, 34, 89, 11};
        int max = 0;
        for (int i = 0; i < 7; i++) {
            max = max > nums3[i] ? max : nums3[i];
        }
        System.out.println("배열의 최댓 값: " + max);

//        int[] nums4 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        System.out.print("짝수: ");
//        for (int i = 0; i < 10; i++) {
//            if (nums4[i] % 2 == 0) {
//                System.out.print(nums4[i] + " ");
//            }
//        }

        int[] nums4 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] evens = new int[0];

        for (int i = 0; i < nums4.length; i++ ) {
            if(nums4[i] % 2 == 0) {
                int[] temp = new int[evens.length + 1];
                for (int j = 0; j < evens.length; j++) {
                    temp[j] = evens[j];
                }
                temp[temp.length - 1] = nums4[i];
                evens = temp;
            }
        }





        String[] names = new String[3];
        names[0] = "김준일";
        names[1] = "김준이";
        names[2] = "김준삼";
        for (int i = 0; i < 3; i++) {
            System.out.print( i + " => " + names[i] + " ");
        }
        System.out.println();

        int[] nums5 = new int[] {1, 2, 3, 4, 5};
        for (int i = 0; i < 5; i++) {
            System.out.print(nums5[4-i] + " ");
        }
        System.out.println();

        int[] nums6 = new int[]{3, 7, 3, 9, 3, 1, 3, 5};
        Scanner scanner = new Scanner(System.in);
        int num6 = scanner.nextInt();
        int cnt6 = 0;
        for (int i = 0; i < 8; i++) {
            if (nums6[i] == num6) {
                cnt6 = cnt6 + 1;
            }
        }
        System.out.printf("숫자 %d의 개수: %d개\n", num6, cnt6);

        int[] nums7 = new int[]{80, 90, 75, 85, 95};
        int sum7 = 0;
        double avg7 = 0;
        for (int i = 0; i < 5; i++) {
            sum7 = sum7 + nums7[i];
        }
        avg7 = (double) sum7/5;
        System.out.printf("배열의 평균: %.2f\n", avg7);

        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = new int[]{6, 7, 8, 9, 10};
        System.out.print("합 배열: ");
        for (int i = 0; i < 5; i++) {
            System.out.print((arr1[i] + arr2[i]) + " ");
        }
        System.out.println();

//        int[] nums9 = new int[]{45, 23, 67, 12, 89, 34, 78};
//        int min9 = 0;
//        int max9 = 0;
//        for (int i = 0; i < 7; i++) {
//            if (min9 < nums9[i]) {
//                min9 = nums9[i];
//            }
//            if (max9 < min9) {
//                max9 = min9;
//            } else if (max9 < nums[i]){
//                max9 = nums[i];
//            } else {
//                max9 = max9;
//            }
//        }
//        System.out.println("최솟 값: " + min9 + "최댓 값: " + max9);

    }
}