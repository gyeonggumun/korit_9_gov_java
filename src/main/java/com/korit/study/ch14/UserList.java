package com.korit.study.ch14;

public class UserList {
    User[] users;

    UserList() {
        this.users = new User[0];
    }

    // Id를 1씩 증가 시키는 함수
    int generateUserId() {
        int newId = 1;
        if (users.length == 0) { // Users 배열에 아무것도 들어 있지 않으면 그대로 newId에 1을 return
            return newId;
        }
        return users[users.length - 1].id + 1;
    }

    void add(User user) {
        User[] temp = new User[users.length + 1];
        for (int i = 0; i < users.length; i++) {
            temp[i] = users[i];
        }
        temp[temp.length - 1] = user;
        users = temp;
    }

    User findByUsername(String username) {
        for (User user : users) {
            if (user.username.equals(username)) {
                return user;
            }
        }
        return null;
    }
}
