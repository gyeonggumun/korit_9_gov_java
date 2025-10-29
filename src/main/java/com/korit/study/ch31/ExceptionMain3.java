package com.korit.study.ch31;

import java.util.Map;

class CustomException extends RuntimeException {
    private Map<String, String> error;

    public CustomException(String message, Map<String, String> error) {
        super(message);
        this.error = error;
    }

    public Map<String, String> getError() {
        return error;
    }
}

// 강제 예외 생성
public class ExceptionMain3 {
    public static void main(String[] args) {

        NullPointerException nullPointerException = new NullPointerException("예외 발생");
        System.out.println(nullPointerException);
        System.out.println(nullPointerException.getMessage());

        try {
            throw nullPointerException; // throw해줄 때 예외처리를 하지 않으면 밑에있는 실행문들이 동작하지 않음
        } catch (NullPointerException e) {
            System.out.println("Null 처리하세요.");
        }

        try {
            throw new CustomException("내가 만든 예외", Map.of("errorId", "1", "message", "내가 만든 오류내용"));
        } catch (CustomException e) {
            System.out.println(e.getError());
        }

        System.out.println("프로그램 정상 종료");
    }
}
