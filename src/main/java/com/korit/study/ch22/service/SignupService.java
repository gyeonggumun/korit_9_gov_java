package com.korit.study.ch22.service;

import com.korit.study.ch21.Singleton;
import com.korit.study.ch22.dto.SignupDto;
import com.korit.study.ch22.entity.User;
import com.korit.study.ch22.repository.UserRepository;
import com.korit.study.ch22.util.PasswordEncoder;

import java.util.Objects;

public class SignupService {
    // 1. instance static 변수 정의
    private static SignupService instance; // 여기 까지만 읽은 상태에서는 SignupService 자료형의로된 static 변수를 정의 한 것
    private UserRepository userRepository;

    private SignupService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static SignupService getInstance() { // 공유되어지는 signupService 자료형을 공유하여 사용가능하도록 설계
        if (Objects.isNull(instance)) { // 스태틱 메서드앞에 is가 붙어있으면 return값이 boolean이다
            instance = new SignupService(UserRepository.getInstance());
        }
        return instance;
    }

    public boolean isValidDuplicatedUsername(String username) {
        User foundUser = userRepository.findByUsername(username);
        return Objects.isNull(foundUser);
    }

    public boolean isValidPassword(String password) {
        return !Objects.isNull(password) && !password.isBlank(); // 입력받은 비밀번호가 null이거나 공백이 있는지 확인
    }

    public boolean isValidConfirmPassword(String password, String confirmPassword) {
        if (Objects.isNull(password) || Objects.isNull(confirmPassword)) {
            return false;
        }
        return password.equals(confirmPassword);
    }

    public void signup(SignupDto signupDto) {
//        User newUser = new User(0, signupDto.getUsername(), PasswordEncoder.encode(signupDto.getPassword()));
        userRepository.insert(signupDto.toUser());
    }
}










