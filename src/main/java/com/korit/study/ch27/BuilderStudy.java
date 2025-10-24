package com.korit.study.ch27;

public class BuilderStudy {
    private String value1;
    private Integer value2;

    public BuilderStudy() {}

    public BuilderStudy(String value1, Integer value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public Integer getValue2() {
        return value2;
    }

    public void setValue2(Integer value2) {
        this.value2 = value2;
    }

    @Override
    public String toString() {
        return "BuilderStudy{" +
                "value1='" + value1 + '\'' +
                ", value2=" + value2 +
                '}';
    }

    public static BuilderStudyBuilder builder() {
        return new BuilderStudyBuilder();
    }

    // builder클래스는 같은 변수들을 가져와야함
    public static class BuilderStudyBuilder {
        private String value1;
        private Integer value2;
        // 본인의 value에 값을 넣고 본인의 주소를 리턴해줌
        public BuilderStudyBuilder value1(String value1) {
            this.value1 = value1;
            return this;
        }
        // 본인의 value2에 값을 넣고 본인의 주소를 리턴해줌
        public BuilderStudyBuilder value2(Integer value2) {
            this.value2 = value2;
            return this;
        }
        // 받아 온 값을 builderStudy로 옮기는 객체
        public BuilderStudy build() {
            return new BuilderStudy(value1, value2);
        }
    }
}
