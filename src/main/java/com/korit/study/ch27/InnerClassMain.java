package com.korit.study.ch27;

public class InnerClassMain {
    public static void main(String[] args) {
        User user = new User("test1", "1234");
        System.out.println(user);
        // user는 이미 생성한 상태이기 때문에 그 안에 있는 내부 클래스만 따로 생성
        User.UserPrinter userPrinter = user.new UserPrinter(user.toString());
        userPrinter.print();
        // 내부 클래스에 static 함수를 사용하여 User와 안에있는 내부 클래스까지 한번에 생성
        User.UserPrinter2 userPrinter2 = new User.UserPrinter2(user.toString());
        userPrinter2.print();
    }
}
