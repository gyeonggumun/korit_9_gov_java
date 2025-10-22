package com.korit.study.ch23;

public class GenericMain {
    public static void main(String[] args) {
        NonGeneric a = new NonGeneric("문자열 데이터");
        NonGeneric b = new NonGeneric(10);
        NonGeneric c = new NonGeneric(new NonGeneric(null));
        NonGeneric d = new NonGeneric(a);
        NonGeneric[] arr = {a, b, c, d};
        for (NonGeneric n : arr) {
            System.out.println(n.getData().getClass());
            // if 문과 else if문이 같은 내용이기 때문에 else if문과 같이 사용하는 것이 좋다
            if (n.getData() instanceof String) {
                // 지역변수를 이용하여 if문 안의 String data를 사용하고 밖에서 따로 사용 가능하게 됨
                String data = (String) n.getData();
                System.out.println(data);
            } else if (n.getData() instanceof NonGeneric data) {
                System.out.println(data.getData());
            }
        }

        // Generic사용 방법 클래스뒤에 <>에 자료형을 담아 사용
        Generic<String, Integer> e = new Generic<String, Integer>("문자열 데이터", "", 10, 3.14);
        Generic<String, Integer> f = new Generic<>("문자열 데이터", "", 10, 3.14);


    }
}
