package com.korit.study.ch22.service;

import com.korit.study.ch22.dto.SignupDto;
import com.korit.study.ch22.entity.User;
import com.korit.study.ch22.repository.UserRepository;
import com.korit.study.ch22.util.PasswordEncoder;

import java.util.Objects;

public class SigninServiceImpl implements SigninService{
    // 싱글톤으로 만들것
    private static SigninServiceImpl instance;
    private UserRepository userRepository;

    public SigninServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static SigninServiceImpl getInstance() {
        return instance;
    }

    @Override
    public void signin(SignupDto signupDto) {
        // 로그인을 시도한 사용자이름 확인 userRepsitory에서
        // 해당 사용자 이름을 가진 User객체가 있는지 확인
        // 객체가 null이면 함수 탈출 (사용자 정보를 확인하세요.)
        User foundUser = userRepository.findByusername(signupDto.getUsername());
        while (true) {
            if (signupDto.equals(foundUser)) {
                break;
            }
            System.out.println("사용자 정보를 확인하세요.");
        }



        // 비밀번호 일치 확인
        // 비밀번호가 일치하지 않으면 함수 탈출


        }
        // 로그인 성공 -> 로그인 성공한 User 객체 toString으로 출력

    @Override
    public boolean isEmpty(String str) {
        // username, password가 각각 공백이 아닌지 확인용도
        return !Objects.isNull(str) && !str.isBlank();
    }
}







