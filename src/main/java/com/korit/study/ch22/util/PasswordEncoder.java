package com.korit.study.ch22.util;

import java.util.Objects;

public class PasswordEncoder {

    private static final String secrete = "암호화비밀번호";
    // 받은 문자열에 헤시코드로 변환하여 암호화 하는 코드
    public static String encode(String str) {
        if (Objects.isNull(str)) {
            return null;
        }
        long hash = Integer.toUnsignedLong(Objects.hash(str));
        long encodedHash = hash + Objects.hash(secrete);
        return Long.toHexString(encodedHash);
    }

//    입력받은 비밀번호를 암호화하여 데이터베이스에 암호화하여 보관해둔 헤시코드와
//    비교해주는 코드
    public static boolean match(String str, String encodeStr) {
        if (Objects.isNull(str) || Objects.isNull(encodeStr)) {
            return false;
        }
        return encode(str).equals(encodeStr);
    }
}
