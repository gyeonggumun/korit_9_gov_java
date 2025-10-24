package com.korit.study.ch25;

import com.korit.study.ch24.Board2;
import com.korit.study.ch24.Comment2;
import com.korit.study.ch24.Writer2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// 불변 컬렉션
public class ImmutableCollection {
    public static void main(String[] args) {
        // 읽기전용 get명령어를 이용해 불러 오는 것만 가능
        // 생성이 쉽지만 바꿀 수 없다는 단점이 있음
        // 바뀔 일이 없는 데이터에만 적용 가능
        List<String> iList = List.of("김준일", "김준이");
        System.out.println(iList);
        Map<String, List<String>> iMap = Map.of(
                "k1", List.of("김준일", "김준이"),
                "k2", List.of("김준삼", "김준사"),
                "k3", List.of("김준오", "김준육"),
                "k4", List.of("김준칠", "김준팔", "김준구")
                );
        List<Board2> boards = new ArrayList<>();
        boards.add(new Board2("제목1",
                new Writer2("김준일", 32),
                "내용1",
                List.of(
                        new Comment2(new Writer2("김준이", 32), "댓글1"),
                        new Comment2(new Writer2("김준삼", 33), "댓글2")
                )));
        System.out.println(iMap);
        System.out.println(boards);
    }
}
