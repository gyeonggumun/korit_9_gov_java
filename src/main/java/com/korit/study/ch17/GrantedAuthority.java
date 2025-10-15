package com.korit.study.ch17;

public interface GrantedAuthority {
    // 인터페이스는 기본적으로 메서드 앞에 public이 포함되어 있다.
    // 생략 가능한 것임으로 public을 적어도 안적어도 무방함
    public String getAuthority();

}
