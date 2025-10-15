package com.korit.study.ch17;

public interface UserDetails {

    // public abstract가 생략되어 있음
    String getUsername();
    String getPassword();
    GrantedAuthority[] getAuthorities();

}
