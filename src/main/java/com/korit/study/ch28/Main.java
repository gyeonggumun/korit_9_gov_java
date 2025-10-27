package com.korit.study.ch28;

class Button {
    private ClickListener listener;

    public void setClickListener(ClickListener listener) {
        this.listener = listener;
    }

    public void click() {
        if (listener != null) {
            listener.onClick();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Button button = new Button();

        // TODO: 여기에 익명 클래스를 사용하여 ClickListener 구현
        ClickListener c = new ClickListener() {
            @Override
            public void onClick() {
                System.out.println("버튼을 클릭하였습니다");
            }
        };
        button.setClickListener(c);
        button.click();

        // 조건이 충족이 되면 익명 클래스를 람다로 사용가능
        Button shopButton = new Button();
        shopButton.setClickListener(() -> System.out.println("상점으로 이동합니다."));
        shopButton.click();
    }
}
