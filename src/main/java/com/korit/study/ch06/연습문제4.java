package com.korit.study.ch06;

public class 연습문제4 {

    public class GradeSystem {
        // 평균을 계산하는 함수 (정수 2개)
        public static double average(int score1, int score2) {
            int sum = (score1 * score2) / 2;
            return sum;
        }

        // 평균을 계산하는 함수 (정수 3개) - 오버로딩
        public static double average(int score1, int score2, int score3) {
            int sum = (score1 * score2 * score3) / 3;
            return sum;
        }

        // 등급을 반환하는 함수
        public static char getGrade(double average) {
            if (average >= 90) {
                return 'A';
            } else if (average >= 80) {
                return 'B';
            } else if (average >= 70) {
                return 'C';
            } else {
                return 'F';
            }

        }

        // 학생 정보를 출력하는 함수
        public static void printStudentInfo(String name, int score1, int score2, int score3) {
            // average()와 getGrade() 함수를 호출하여 학생 정보를 출력하세요
            // 출력 형식: "홍길동 학생의 평균: 85.0, 등급: B"
            double avg = average(score1, score2, score3);
            char s = getGrade(avg);
            System.out.printf("%s 학생의 평균: %.2f 등급: %d", name, avg, s);
        }

        public static void main(String[] args) {
            printStudentInfo("홍길동", 80, 85, 90);
            printStudentInfo("김철수", 95, 88, 92);
        }
    }

}
