package com.korit.study.ch22.service;

import com.korit.study.ch22.dto.SignupDto;
import com.korit.study.ch22.entity.User;
import com.korit.study.ch22.repository.UserRepository;

import java.util.Objects;

public class SignupService {
    // 1. instance static 변수 정의
    private static SignupService instance;
    private UserRepository userRepository;

    // 클래스에서만 생성이 가능하도록 셋팅
    private SignupService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    // instance 함수 밖에서 사용이 가능하도록 get함수 셋팅
    public static SignupService getInstance() {
        if(Objects.isNull(instance)) {
            instance = new SignupService(UserRepository.getInstans());
        }
        return instance;
    }
    // 입력받은 username이 중복이 있는지 확인하는 코드
    public boolean isValidDuplicatedUsername(String username) {
        User foundUser = userRepository.findByusername(username);
        if (Objects.isNull(foundUser)) {
            return true;
        }
        return false;
    }
//  null인지 빈 공간이 있는지 확인하는 코드
    public boolean isValidPassword(String password) {
        return !Objects.isNull(password) && !password.isBlank();
    }
//  입력받은 비밀번호와 확인 비밀번호가 일치하는지 확인하는 코드
    public boolean isValidConfirmPassword(String password, String confirmpassword) {
        if (Objects.isNull(password) || Objects.isNull(confirmpassword)) {
            return false;
        }
        return password.equals(confirmpassword);
    }
//
    public void signup(SignupDto signupDto) {
        userRepository.insert(signupDto.toUser());
    }



}
