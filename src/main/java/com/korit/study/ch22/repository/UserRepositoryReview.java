package com.korit.study.ch22.repository;

import com.korit.study.ch22.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserRepositoryReview {
    private static UserRepositoryReview instance;
    private List<User> users;
    private int autoIncrementId = 1;


    //생성자 호출 시 다른 곳에서 생성 못하도록 private
    private UserRepositoryReview() {
        users = new ArrayList<>();
        autoIncrementId = 1;
    }

    // User 객체를 가져오는 유일한 방법 = getInstance
    public static UserRepositoryReview getInstance() {
        if (Objects.isNull(instance)) {
            instance = new UserRepositoryReview();
        }
        return instance;
    }

    public void insert(User user) {
        user.setId(autoIncrementId++);
        users.add(user);
    }

    public User findByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("User 배열: [");
        for (int i = 0; i < users.size(); i++) {
            sb2.append(users.get(i));
            if (i != users.size() - 1) {
                sb2.append(", ");
            }
        }
        sb2.append(" ]");
        return sb2.toString();
    }
}
