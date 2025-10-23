package com.korit.study.ch22.repository;

import com.korit.study.ch22.entity.User;

import java.util.Arrays;
import java.util.Objects;

public class UserRepositoryImpl implements UserRepository{
    private static UserRepositoryImpl instance; // 데이터를 보호하기 위하여 변수명 앞에 private사용
    private User[] users;
    private int autoIncrementId;

    private UserRepositoryImpl() { // 외부에서 함부로 생성할 수 없도록 하기위해 생성자에 private 사용
        users = new User[0];
        autoIncrementId = 1;
    }

    public static UserRepositoryImpl getInstance() {  // instance함수가 계속 호출될 때 생성이 계속 일어나지 않도록 조건사용
        if (Objects.isNull(instance)) {
            instance = new UserRepositoryImpl();
        }
        return instance;
    }

    public void insert(User user) {  // 유저 정보를 담는 배열을 생성 하며 ID에 + 1적용
        User[] temp = Arrays.copyOf(users, users.length + 1);
        user.setId(autoIncrementId++);  // ID가 기본값이 1 이기때문에 후증가로 적용
        temp[temp.length - 1] = user;
        users = temp;
    }

    public User findByUsername(String username) { // 받은 유저이름과 데이터에 담겨있는 유저이름이 동일한게 있는지 검사
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

//    autoIncrementId로 대체
//    private int generateId() {
//        return users[users.length].getId() + 1;
//    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();  // 문자열을 효율적으로 합칠 때 사용
        stringBuilder.append("User 배열: [ ");
        for (int i = 0; i < users.length; i++) { // users배열 안에 있는 유저 정보를 탐색하는 for문
            stringBuilder.append(users[i]); // toString 생략
            if (i != users.length - 1) { // 배열의 제일 끝부분에 ,를 안 찍도록 하는 조건문
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(" ]");

        return stringBuilder.toString();
    }
}











