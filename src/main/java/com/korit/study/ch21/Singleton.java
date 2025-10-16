package com.korit.study.ch21;

import java.util.Objects;

public class Singleton {
    // 한번만 생성하여 이것을 공유하고 싶을 때 Singleton을 생성하여 사용한다
    // private으로 생성한 후 getter을 생성하여 값을 반환해준다.
    private volatile static Singleton instance;
    private String data;
    // private을 통해 생성자를 밖에서 생성하지 못하도록 한다
    // 무조건 private 세팅을 해주어야 한다
    private Singleton(String data) {
        this.data = data;
    }

    public static Singleton getInstance() {
        if (Objects.isNull(instance)) {  // 처음에 instance가 null일때만 instance 변수에 값을 부여한다.
            instance = new Singleton("Class Data");
        }
        return instance;
    }

    public static Singleton getSynchronizedInstance() {
        if(Objects.isNull(instance)) {
            synchronized (Singleton.class) {
                if(Objects.isNull(instance)) {
                    instance = new Singleton("Class Data");
                }
            }
        }
        return instance;
    }

    public void changeData() {
        System.out.println("데이터를 변경: " + data);
    }

    public  void deleteData() {
        System.out.println("데이터를 삭제: " + data);
    }


}
