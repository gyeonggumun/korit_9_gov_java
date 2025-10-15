package com.korit.study.ch14;

public class UserService {

    UserList userList;

    UserService(UserList userList) {
        this.userList = userList;
    }

    boolean isDuplicatedUsername(String username) {
        return userList.findByUsername(username) != null;
    }

    // 로그인
    User signin (SigninDto signinDto) {
        User foundUser = userList.findByUsername(signinDto.username);
        if (foundUser == null) {
            // 사용자이름 (아이디)가 존재하지 않는다.
            return null;
        }
        if (!foundUser.password.equals(signinDto.password)) {
            return null;
        }
        return foundUser;
    }

    // 회원가입
    void signup(SignupDto signupDto) {
        User user = signupDto.toUser(); // User 객체를 사용하는 user에 touser을 삽입
        user.id = userList.generateUserId(); // user.id에 0이 들어가 있음으로 그 수에 generateUserId 함수를 통해 1씩 더해줌
        userList.add(user);
    }

    void printUserListAll() {
        System.out.println("등록된 사용자 전체 조회");
        for (User user : userList.users) {
            System.out.println(user.toString());
        }
    }
}
