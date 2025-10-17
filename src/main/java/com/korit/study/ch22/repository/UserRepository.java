package com.korit.study.ch22.repository;

import com.korit.study.ch22.entity.User;

import java.util.Arrays;
import java.util.Objects;

public class UserRepository {

    private static UserRepository instans;
    private User[] users;
    private int autoIncrementId;

    private UserRepository () {
        users = new User[0];
        autoIncrementId = 1;
    }
    // instans가 null인지 확인하고 null이면 생성하는 함수
    public static UserRepository getInstans() {
        if (Objects.isNull(instans)) {
            instans = new UserRepository();
        }
        return instans;
    }
    // 새로운 유저를 추가할 때 배열을 늘리는 코드
    public void insert(User user) {
        User[] temp = Arrays.copyOf(users, users.length + 1);
        // 생성될 때 유저의 아이디를 하나씩 증가 시켜줌
        user.setId(autoIncrementId++);
        temp[temp.length - 1] = user;
        users = temp;
    }
    // 회원 가입되어 있는 username과 입력한 username이 중복인지 확인하는 코드
    public User findByusername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    // StringBuffer.append를 사용하여 문자열을 새로 추가해서 쓰레기값을 만들지 않고
    // 계속해서 문자를 추가 시켜주고 마지막에 String으로 변환하여 생성해줌
    @Override
    public  String toString() {
        StringBuffer stringBuffer = new StringBuffer(); // 일반 문자열 합치기 보다 속도가 빠름
        stringBuffer.append("User 배열: [");
        for (int i = 0; i < users.length; i++) {
            stringBuffer.append(users[i]);
            if (i != users.length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append("[");

        return stringBuffer.toString();
    }

}
