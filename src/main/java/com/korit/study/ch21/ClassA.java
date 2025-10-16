package com.korit.study.ch21;

public class ClassA {
    public void run() {
        Singleton.getInstance().changeData();
        Singleton.getInstance().deleteData();
    }
}
