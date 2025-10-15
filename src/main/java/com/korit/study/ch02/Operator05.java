package com.korit.study.ch02;

public class Operator05 {
    public static void main(String[] args) {
        String r = 10 > 0 ? "영보다커" : "영보다작아.";
        double r2 = 10 > 0 ? 1.1 : 2.2;
        char r3 = 10 > 0 ? 'o' : 'x';
        String r4 = -10 > 0 ? "영보다커" : (-10 > -20 ? "마이너스이십보다커" :"작아");
        String r5 = 2002 % 100 == 0 ? "100의 배수" : "100의 배수 아님";

        int year = 1999; // 2024년
//        윤년인지 확인하세요. (4의 배수 이면서 100의 배수가 아님) 또는 400의 배수
        String result = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ? "윤년입니다." : "평년입니다.";
//        String result = year % 4 ==0 ? (year % 100 != 0 ? "윤년입니다": (year % 400 == 0 ? "윤년입니다." : "평년입니다.")): "평년입니다";
        System.out.println(result); //윤년입니다. /평년입니다.

        int 현재잔액 = 150000;
        int 출금금액 = 120000;

        String 상태 = 현재잔액 - (출금금액+1000) < 0 ? "성공": "실패" ; //성공, 실패
        int 출금액 = 0;  // 수수료 1000원 포함
        int 거래후잔액 = 0;
        int 수수료포함 = 출금금액 + 1000;

        출금액 = 현재잔액 > 수수료포함 ? 수수료포함 : 0;
        거래후잔액 = 출금금액 == 0 ? 현재잔액 : 현재잔액 - 출금액;

        System.out.println("거래상태 :" + 상태);
        System.out.println("출금액: " + 출금액 + "원 (수수료 1000원 포함)");
        System.out.println("거래 후 잔액: " + 거래후잔액 + "원");

    }
}
