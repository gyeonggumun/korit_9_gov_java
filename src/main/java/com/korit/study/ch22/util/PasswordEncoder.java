package com.korit.study.ch22.util;

import java.util.Objects;

public class PasswordEncoder {

    private static final String secrete = "암호화비밀번호";

    public static String encode(String str) { // 헤시코드로 변환하는 코드
        if (Objects.isNull(str)) {  // 받은 문자가 null이면 검사할 필요가 없기 때문에 null반환
            return null;
        }
        long hash = Integer.toUnsignedLong(Objects.hash(str));
        long encodedHash = hash + Objects.hash(secrete);
        return Long.toHexString(encodedHash);
    }

    public static boolean match(String 평문, String 암호문) {
        if (Objects.isNull(평문) || Objects.isNull(암호문)) {
            return false;
        }
        return encode(평문).equals(암호문);
    }
}
