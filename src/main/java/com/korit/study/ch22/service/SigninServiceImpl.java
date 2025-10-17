package com.korit.study.ch22.service;

import com.korit.study.ch22.dto.SigninDto;
import com.korit.study.ch22.entity.User;
import com.korit.study.ch22.repository.UserRepository;
import com.korit.study.ch22.util.PasswordEncoder;

import java.util.Objects;

public class SigninServiceImpl implements SigninService {
    // 싱글톤으로 만들것
    private static SigninServiceImpl instance;

    private UserRepository userRepository;

    private SigninServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static SigninServiceImpl getInstance() {
        if (Objects.isNull(instance)) {
            instance = new SigninServiceImpl(UserRepository.getInstance());
        }
        return instance;
    }

    @Override
    public void signin(SigninDto signinDto) {
        // 로그인을 시도한 사용자이름 확인 userRepository에서
        // 해당 사용자 이름을 가진 User객체가 있는지 확인
        // 객체가 null이면 함수 탈출(사용자 정보를 다시 확인하세요.)
        
        // 비밀번호 일치 확인
        // 비밀번호가 일치하지 않으면 함수 탈출(사용자 정보를 다시 확인하세요.)
        
        // 로그인 성공 -> 로그인 성공한 User객체 toString으로 출력

        User foundUser = userRepository.findByUsername(signinDto.getUsername());
        if (Objects.isNull(foundUser)) {
            System.out.println("사용자 정보를 다시 확인하세요.");
            return;
        }

        if (!PasswordEncoder.match(signinDto.getPassword(), foundUser.getPassword())) {
            System.out.println("사용자 정보를 다시 확인하세요.");
            return;
        }

        System.out.println("로그인 성공");
        System.out.println(foundUser);
    }

    @Override
    public boolean isEmpty(String str) {
        // username, password가 각각 공백이 아닌지 확인용도
        if (Objects.isNull(str)) {
            return false;
        }
        return str.isBlank();
    }
}
