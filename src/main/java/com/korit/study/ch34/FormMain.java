package com.korit.study.ch34;

import javax.swing.*;

public class FormMain {
    public static void main(String[] args) {
        // 기본적인 프레임과 화면 생성
        JFrame jFrame = new JFrame("FirstForm");
        jFrame.setContentPane(new FirstForm().getPanel1());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true); // false면 화면에 나오지 않음
    }
}

