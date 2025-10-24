package com.korit.study.ch27;

public class BuilderMain {
    public static void main(String[] args) {
        BuilderStudy builderStudy = new BuilderStudy("김준일", 32);
        // set을 사용하지 않고 builder을 사용하면 직관 적이라는 장점이 있음
        // 순서를 상관없이 작성 가능 마지막에 build해주는 것만 조심할 것
        // 갯수가 상관없이 값을 입력해줄 수 있음
        BuilderStudy builderStudy1 = builderStudy.builder()
                .value1("김준일")
                .value2(32)
                .build();

        Product product = Product.builder().name("상품").price(1000).size("L").build();
        System.out.println(product);

        ComputerBuilder computerBuilder = Computer.builder();
        computerBuilder.setCpu("i7");
        computerBuilder.setRam(8);
        Computer computer = computerBuilder.build();

        ComputerBuilder computerBuilder1 = Computer.builder().cpu("i5").ram(16);
        Computer computer2 = Computer.builder().build();

        Computer computer3 = Computer.builder().cpu("i5").ram(16).build();
    }
}
